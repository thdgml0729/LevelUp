package com.user.mag.model;

import java.util.Map;

import com.user.mag.dto.User_DTO;

public interface Member_IService {

	public User_DTO loginmember(Map<String, String> map);
	
	public int idduplicatecheck(String seq);
	
	public boolean signupmember(User_DTO dto);
	
	public String selStringId(Map<String, String> map);
	
	public String selStringPw(String seq);
}
