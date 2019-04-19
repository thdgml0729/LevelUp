package com.user.mag.dto;

public class OTP_DTO {
	
	private static final long serialVersionUID = -6975832134231401425L;

	private int seq;

	private String accesscode;

	public OTP_DTO() {

	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getAccesscode() {
		return accesscode;
	}

	public void setAccesscode(String accesscode) {
		this.accesscode = accesscode;
	}

	@Override
	public String toString() {
		return "OTP_DTO [seq=" + seq + ", accesscode=" + accesscode + "]";
	}


}
