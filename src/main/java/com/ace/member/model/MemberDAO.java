package com.ace.member.model;

import java.util.*;

public interface MemberDAO {
	public int memberJoin(MemberDTO dto);
	public boolean idCheck(String userid);
	public String loginCheck(String userid, String userpwd);
	public MemberDTO getUserInfo(String userid);
	public String idFind(Map map);
	public String pwdFind(Map map);
	public List<MemberDTO> memberList(int com_idx);
	public int update(MemberDTO dto);
	public int memberPromotion(int idx);
	public List<MemberDTO> memberNot(Map map);

	public List<MemberDTO> bossList(Map map);
	public List<MemberDTO> withdrawList(Map map);
	public List<MemberDTO> bossSearchList(Map map);
	public int getTotalBossCnt();
	public int getTotalBossSearchCnt(String keyword);
	public int getTotalWithdrawCnt();
	public int submitWithdraw(int com_idx);
}
