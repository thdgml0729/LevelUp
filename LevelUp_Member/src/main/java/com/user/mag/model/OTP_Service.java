package com.user.mag.model;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OTP_Service implements OTP_IService{

	private Logger logger = LoggerFactory.getLogger(OTP_Service.class);
	
	@Autowired
	private OTP_Interface otp_Interface;
	
	@Override
	public int makeOTP() {
		logger.info("OTP생성 makeOTP {}");
		return otp_Interface.makeOTP();
	}

	@Override
	public int deleteOTP() {
		logger.info("OTP삭제 deleteOTP");
		return otp_Interface.deleteOTP();
	}

	@Override
	public String selOTPKey(String seq) {
		logger.info("OTP 인증번호 가져오기");
		return otp_Interface.selOTPKey(seq);
	}
	
}
