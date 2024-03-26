package com.ace.member.model;

import java.sql.*;
import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;

public class MemberDAOImple implements MemberDAO {
	
	private SqlSessionTemplate sqlMap;
	
	public MemberDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}

	public int memberJoin(MemberDTO dto) {
		int cout = sqlMap.insert("memberInsert", dto);
		return cout;
	}
	public boolean idCheck(String userid) {
		String result = sqlMap.selectOne("idCheck", userid);
		boolean res = result==null?false:true;
		return res;
	}
	public String loginCheck(String userid, String userpwd) {
		String result = sqlMap.selectOne("memberLogin", userid);
		return result;
	}
	public MemberDTO getUserInfo(String userid) {
		MemberDTO dto = sqlMap.selectOne("getUserInfo",userid);
		return dto;
	}
	
	public String idFind(Map map) {
		String idfind = sqlMap.selectOne("idFind", map);
		return idfind;
	}
	public String pwdFind(Map map) {
		String pwdfind = sqlMap.selectOne("pwdFind", map);
		return pwdfind;
	}
	public List<MemberDTO> memberList(int com_idx){
		List<MemberDTO> list = sqlMap.selectList("memberList", com_idx);
		return list;
	}
	@Override
	public int update(MemberDTO dto) {
		int count = sqlMap.update("update", dto); 
		return count;
	}
	@Override
	public int memberPromotion(int idx) {
		int count = sqlMap.update("memberPromotion", idx);
		return count;
	}
	@Override
	public List<MemberDTO> memberNot(Map map) {
		List<MemberDTO> list = sqlMap.selectList("memberNot", map);
		return list;
	}
	
	@Override
	   public List<MemberDTO> bossList(Map map) {
	      List<MemberDTO> list = sqlMap.selectList("bossList", map);
	      return list;
	   }

	   @Override
	   public List<MemberDTO> bossSearchList(Map map) {
	      List<MemberDTO> list = sqlMap.selectList("bossSearchList", map);
	      return list;
	   }

	   @Override
	   public int getTotalBossCnt() {
	      int count = sqlMap.selectOne("totalBossCnt");
	      return count;
	   }

	   @Override
	   public int getTotalBossSearchCnt(String keyword) {
	      int count = sqlMap.selectOne("totalBossSearchCnt", keyword);
	      return count;
	   }

	   @Override
	   public int getTotalWithdrawCnt() {
	      int count = sqlMap.selectOne("totalWithdrawCnt");
	      return count;
	   }

	   @Override
	   public List<MemberDTO> withdrawList(Map map) {
	      List<MemberDTO> list = sqlMap.selectList("withdrawList", map);
	      return list;
	   }

	   @Override
	   public int submitWithdraw(int com_idx) {
	      int result= sqlMap.update("submitWithdraw", com_idx);
	      return result;
	   }
	
}
