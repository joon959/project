package com.ace.controller;

import java.io.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ace.company.model.CompanyDTO;
import com.ace.company.service.CompanyService;

@Controller
public class CompanyJoinController {
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping("/companyFind.do")
	public String companyFind() {
		return "member/companyFind";
	}
	@RequestMapping(value="/companyFind.do", method = RequestMethod.POST)
	public ModelAndView companyViewOk(
			@RequestParam("com_name")String com_name) {
		ModelAndView mav = new ModelAndView();
		List<CompanyDTO> comList = companyService.comFind(com_name);
		mav.addObject("comList", comList);
		mav.setViewName("member/companyFind");
		
		return mav;		
	}
	
	@RequestMapping("/companyJoin.do")
	public String companyJoin() {
		return "member/companyJoin";
	}
	@RequestMapping(value="/companyJoin.do", method = RequestMethod.POST)
	public ModelAndView companyJoin(CompanyDTO dto,
			@RequestParam("fupload")MultipartFile fupload) {		
		dto.setCom_img(fupload.getOriginalFilename());
		ModelAndView mav = new ModelAndView();
		boolean check = companyService.comCheck(dto.getCom_name());
		if(check) {		
			String msg = "이미 등록된 기업명 입니다.";
			String url = "/aceworks";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("member/message");
		}else {
			copyInto(dto.getCom_name(),fupload);
			int result = companyService.comJoin(dto);
			String msg = result>0?"기업등록 성공":"기업등록 실패";
			String url = "/aceworks";		
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("member/message");
		}
		return mav;
	}
	
	@RequestMapping("/comCheck.do")
	public ModelAndView comCheck(
			@RequestParam("com_name")String com_name) {
		boolean result = companyService.comCheck(com_name);
		ModelAndView mav = new ModelAndView();
		String msg = result==true?"이미 등록된 기업명 입니다.":"사용 가능한 기업명 입니다.";
		mav.addObject("msg",msg);
		mav.setViewName("member/checkMsg");
		return mav;
	}
	
	
	/**파일복사메서드*/
	public void copyInto(String com_name, MultipartFile upload) {
		try {
			byte bytes[] = upload.getBytes();
			//File dirPath = new File("src/main/webapp/img/"+ writer+"/");
			File dirPath = new File("C:/student_java/final/aceworks/src/main/webapp/img/"+ com_name +"/");
			System.out.println(dirPath.getPath());
			String ddd = System.getProperty("user.dir");
	        System.out.println(ddd);
			
			if (!dirPath.exists()) {
	            dirPath.mkdirs();
	        }
	        //File f = new File("src/main/webapp/img/"+writer+"/"+upload.getOriginalFilename());      
	        File f = new File("C:/student_java/final/aceworks/src/main/webapp/img/"+com_name+"/"+upload.getOriginalFilename());      
	        FileOutputStream fos = new FileOutputStream(f);
	        fos.write(bytes);
	        fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
