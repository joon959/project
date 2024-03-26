package com.ace.member.model;

import java.sql.Date;

public class MemberDTO {
	private int idx;
	private int com_idx;
	private String name;
	private String id;
	private String pwd;
	private String email;
	private String addr;
	private String tel;
	private String hum_num;
	private String dept;
	private int rank_num;
	private int sal;
	private Date hiredate;
	private String com_name;
	private int usernum;
	
	public MemberDTO() {
		super();
	}

	public MemberDTO(int idx, int com_idx, String name, String id, String pwd, String email, String addr, String tel,
			String hum_num, String dept, int rank_num, int sal, Date hiredate) {
		super();
		this.idx = idx;
		this.com_idx = com_idx;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.addr = addr;
		this.tel = tel;
		this.hum_num = hum_num;
		this.dept = dept;
		this.rank_num = rank_num;
		this.sal = sal;
		this.hiredate = hiredate;
	}
	
	public MemberDTO(int idx, int com_idx, String name, String id, String pwd, String email, String addr, String tel,
			String hum_num, String dept, int rank_num, int sal, Date hiredate, String com_name, int usernum) {
		super();
		this.idx = idx;
		this.com_idx = com_idx;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.addr = addr;
		this.tel = tel;
		this.hum_num = hum_num;
		this.dept = dept;
		this.rank_num = rank_num;
		this.sal = sal;
		this.hiredate = hiredate;
		this.com_name = com_name;
		this.usernum = usernum;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getCom_idx() {
		return com_idx;
	}

	public void setCom_idx(int com_idx) {
		this.com_idx = com_idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHum_num() {
		return hum_num;
	}

	public void setHum_num(String hum_num) {
		this.hum_num = hum_num;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getRank_num() {
		return rank_num;
	}

	public void setRank_num(int rank_num) {
		this.rank_num = rank_num;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	///
	public String getCom_name() {
		return com_name;
	}

	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}

	public int getUsernum() {
		return usernum;
	}

	public void setUsernum(int usernum) {
		this.usernum = usernum;
	}
	
}
