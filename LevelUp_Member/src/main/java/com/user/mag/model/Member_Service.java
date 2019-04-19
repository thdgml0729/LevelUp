package com.user.mag.model;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.mag.dto.User_DTO;

@Service
public class Member_Service implements Member_IService {
	
	@Autowired
	private Member_Interface member_Interface;
	
	private Logger logger = LoggerFactory.getLogger(Member_Service.class);

	@Override
	public User_DTO loginmember(Map<String, String> map) {
		logger.info("로그인 loginmember {}", map);
		return member_Interface.loginmember(map);
	}

	@Override
	public int idduplicatecheck(String seq) {
		logger.info("아이디중복체크 idduplicatecheck {}", seq);
		return member_Interface.idduplicatecheck(seq);
	}

	@Override
	public boolean signupmember(User_DTO dto) {
		logger.info("회원가입 signupmember {}", dto);
		return member_Interface.signupmember(dto);
	}

	@Override
	public String selStringId(Map<String, String> map) {
		logger.info("아이디찾기 selStringId {}",map);
		return member_Interface.selStringId(map);
	}

	@Override
	public String selStringPw(String seq) {
		logger.info("비밀번호찾기 ");
		return member_Interface.selStringPw(seq);
	}
	
	

}
