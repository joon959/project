package com.ace.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ace.client_tel.model.Client_TelDTO;
import com.ace.client_tel.service.Client_TelService;
import com.ace.member.model.MemberDTO;
import com.ace.member.service.MemberService;

@Controller
public class ComManaController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private Client_TelService client_telService;
	
	@RequestMapping("companyManager.do")
	public String companyManager() {
		return "comManager/comManager";
	}
	@RequestMapping("sales.do")
	public String sales() {
		return "comManager/sales";
	}
	@RequestMapping("salesWrite.do")
	public String salesWrite() {
		return "comManager/salesWrite";
	}
	@RequestMapping("memberList.do")
	public ModelAndView memberList(
			@RequestParam("com_idx")int com_idx) {
		ModelAndView mav = new ModelAndView();
		List<MemberDTO> list = memberService.memberList(com_idx);
		mav.addObject("list", list);
		mav.setViewName("comManager/memberList");
		return mav;
	}
	
	@RequestMapping("memberNot.do")
	public ModelAndView memberNot(
			@RequestParam("com_idx")int com_idx,
			@RequestParam("rank_num")int rank_num) {
		
		Map map = new HashMap();
		map.put("com_idx", com_idx);
		map.put("rank_num", rank_num);
		
		ModelAndView mav = new ModelAndView();
		List<MemberDTO> list = memberService.memberNot(map);
		mav.addObject("list", list);
		mav.setViewName("comManager/memberList");
		return mav;
	}
	@RequestMapping("memberPromotion.do")
	public ModelAndView memberPromotion(
			@RequestParam("idx")int idx) {
		ModelAndView mav = new ModelAndView();
		int count = memberService.memberPromotion(idx);
		String url = "companyManager.do";
		String msg = count>0?"성공":"실패";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("member/message");
		return mav;
	}
	
	
	
	@RequestMapping("memberUpdate.do")
	public ModelAndView memberUpdate(
			@RequestParam("id")String id) {
		ModelAndView mav = new ModelAndView();
		MemberDTO dto = memberService.getUserInfo(id);
		
		mav.addObject("mdto", dto);
		mav.setViewName("comManager/memberUpdate");
		return mav;
	}
	
	@RequestMapping(value="memberUpdate.do", method = RequestMethod.POST)
	public ModelAndView memberUpdateOk(
			MemberDTO dto,
			@RequestParam("id")String id) {
		dto.setId(id);
		ModelAndView mav = new ModelAndView();
		int count = memberService.update(dto);
		String url = "companyManager.do";
		String msg = count>0?"성공":"실패";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("member/message");
		return mav;
	}

	@RequestMapping("clientTel.do")
	public ModelAndView clientTel(int com_idx,
			@RequestParam(value = "cp", defaultValue = "1") int cp) {
		
		int totalCnt = client_telService.getTelTotalCnt(com_idx);
		int listSize = 10;
		int pageSize = 5;
		
		String pageStr = com.ace.page.com_memberListPage.makePage("clientTel.do", totalCnt, listSize, pageSize, cp, com_idx);
		
		ModelAndView mav = new ModelAndView();
		List<Client_TelDTO> list = client_telService.telList(com_idx, cp, listSize);		
		mav.addObject("list", list);
		mav.addObject("pageStr",pageStr);
		mav.setViewName("comManager/clientTel");
		return mav;
	}
	
	
	
	@RequestMapping("clientTelWrite.do")
	public String clientTelWrite() {
		return "comManager/clientTelWrite";
	}
	@RequestMapping(value="clientTelWrite.do", method = RequestMethod.POST)
	public ModelAndView clientTelWriteOk(Client_TelDTO dto) {
		ModelAndView mav = new ModelAndView();
		int count = client_telService.insertTel(dto);
		String url = "companyManager.do";
		String msg = count>0?"성공":"실패";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("member/message");
		return mav;
	}
	@RequestMapping("rewriteTel.do")
	public ModelAndView rewriteTel(
			@RequestParam("client_tel_idx")int client_tel_idx) {
		ModelAndView mav = new ModelAndView();
		Client_TelDTO tdto = client_telService.rewriteTel(client_tel_idx);
		
		mav.addObject("tdto", tdto);
		mav.setViewName("comManager/clientTelReWrite");
		return mav;
	}
	
	@RequestMapping(value = "rewriteTel.do", method = RequestMethod.POST)
	public ModelAndView rewriteTelOk(Client_TelDTO dto) {
		ModelAndView mav = new ModelAndView();
		int count = client_telService.rewriteTelOk(dto);
		String url = "companyManager.do";
		String msg = count>0?"성공":"실패";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("member/message");
		return mav;
	}
}
