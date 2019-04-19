package com.user.mag.model;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.user.mag.batch.MakeAccessNumber;

@Repository
public class OTP_Dao implements OTP_Interface{

	private final String NS = "com.user.mag.Statement_OTP.";
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private MakeAccessNumber makeAccessNumber;
	
	@Override
	public int makeOTP() {
		int n = 0;
		Map<String, String> map = new HashMap<>();
		for (int i = 1; i <= 20; i++) {
			map.put("seq", Integer.toString(i));
			String str = makeAccessNumber.makeRandomNum(6, 2);
			map.put("accesscode", str);
			n += sqlSession.insert(NS+"makeOTP", map);
			System.out.println(map);
		}
		return n;
	}

	@Override
	public int deleteOTP() {
		System.out.println("OTP삭제 메소드");
		return sqlSession.delete(NS+"deleteOTP");
	}

	@Override
	public String selOTPKey(String seq) {
		System.out.println("인증키 가져오기");
		return sqlSession.selectOne(NS+"selOTPKey",seq);
	}

}
