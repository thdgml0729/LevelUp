package com.user.mag.model;

import java.util.Map;

public interface OTP_IService {
	
	public int makeOTP();
	
	public int deleteOTP();
	
	public String selOTPKey(String seq);
}
