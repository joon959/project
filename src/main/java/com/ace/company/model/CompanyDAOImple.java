package com.ace.company.model;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;

public class CompanyDAOImple implements CompanyDAO {
	
	private SqlSessionTemplate sqlMap;
	
	public CompanyDAOImple(SqlSessionTemplate sqlMap) {
		super();
		this.sqlMap = sqlMap;
	}

	public List<CompanyDTO> comFind(String com_name) {
		List<CompanyDTO> list = sqlMap.selectList("companyFind", com_name);
		return list;
	}
	
	public int comJoin(CompanyDTO dto) {
		int cout = sqlMap.insert("companyJoin", dto);
		return cout;
	}
	
	public boolean comCheck(String com_name) {
		String result = sqlMap.selectOne("comCheck", com_name);
		boolean res = result==null?false:true;
		return res;
	}
	
	public CompanyDTO getComInfo(int com_idx) {
		CompanyDTO cdto = sqlMap.selectOne("comInfo", com_idx);
		return cdto;
	}
}
