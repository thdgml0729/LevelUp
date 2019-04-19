package com.user.mag.model;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.user.mag.dto.User_DTO;

@Repository
public class Member_Dao implements Member_Interface {

	private final String NS = "com.user.mag.Statement_User.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public User_DTO loginmember(Map<String, String> map) {
		return sqlSession.selectOne(NS+"loginmember",map);
	}

	@Override
	public int idduplicatecheck(String seq) {
		return sqlSession.selectOne(NS+"idduplicatecheck",seq);
	}

	@Override
	public boolean signupmember(User_DTO dto) {
		int n = sqlSession.insert(NS+"signupmember",dto);
		return n>0? true:false;
	}

	@Override
	public String selStringId(Map<String, String> map) {		
		return sqlSession.selectOne(NS+"selStringId",map);
	}

	@Override
	public String selStringPw(String seq) {
		return sqlSession.selectOne(NS+"selStringPw",seq);
	}

}
