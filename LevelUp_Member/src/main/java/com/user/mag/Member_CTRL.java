package com.user.mag;

import java.util.HashMap;
import java.util.Scanner;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.user.mag.model.Member_IService;
import com.user.mag.model.OTP_IService;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Controller
public class Member_CTRL {
	
	Logger logger = LoggerFactory.getLogger(Member_CTRL.class);
	
	@Autowired
	private Member_IService member_iservice;
	
	@Autowired
	private OTP_IService otp_iservice;
	
	@RequestMapping(value="/loginForm.do",method=RequestMethod.GET)
	public String loginForm() {
		logger.info("Member_CTRL loginForm");
		return "loginForm";
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(String id, String pw) {
		logger.info("Member_CTRL login");
		System.out.println("받아온 아이디 : "+id+", 받아온 패스워드 : "+pw);
		return null;
	}
	
	@RequestMapping(value="/terms.do",method=RequestMethod.GET)
	public String JoinMember() {
		logger.info("Member_CTRL 회원가입페이지로 이동");
		return "terms";
	}

	@RequestMapping(value="/join.do",method=RequestMethod.GET)
	public String Join() {
		return "joinMember";
	}
	
	@RequestMapping(value="/msgsend1.do",method=RequestMethod.POST,
			produces="application/text; charset=UTF-8")
	@ResponseBody
	public String msgsend(String phone, HttpSession session) {
		logger.info("Member_CTRL 문자인증");
		System.out.println("받은 data : "+phone);
		session.setAttribute("message", "성공");
		otp_iservice.deleteOTP();
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■OTP삭제완료");
		otp_iservice.makeOTP();
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■OTP생성완료");
		// 정송희인증
//		String api_key = "NCSNRUD6LZXEYC5J";
//	    String api_secret = "LWGVMHKOX8VEFKAPTUDAWV8NG6F1Z2Y8";
		
		//언니 인증
		String api_key = "NCSBBEI5PLLEXGD2";
		String api_secret = "OFVHZ33HQYWVQSCCZRWTYRWZNE8ZT1LU";
		
	    Message coolsms = new Message(api_key, api_secret);
	    int number = (int)(Math.random()*20+1);
	    String num = String.valueOf(number);
	    System.out.println("■■■■■■■■■■■■■■■■■■■■■■num의 값은?"+num);
	    String key = otp_iservice.selOTPKey(num);
//	    session.setAttribute("key", key);
	    System.out.println("■■■■■■■■■■■■■■■■■■■■■■인증키의 값은?"+key);
//	    String key = new TempKey().getKey(6, false);

	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", phone); // 수신번호
//	    params.put("from", "01094096075"); // 발신번호
	    params.put("from", "01065491058");
	    params.put("type", "SMS"); // Message type ( SMS, LMS, MMS, ATA )
	    params.put("text", "[LevelUp]본인확인 인증번호["+key+"]입니다.\"타인 노출 금지\""); // 문자내용    
	    params.put("app_version", "JAVA SDK v1.2"); // application name and version

	    // Optional parameters for your own needs
	    // params.put("image", "desert.jpg"); // image for MMS. type must be set as "MMS"
	    // params.put("image_encoding", "binary"); // image encoding binary(default), base64 
	     params.put("mode", "test"); // 'test' 모드. 실제로 발송되지 않으며 전송내역에 60 오류코드로 뜹니다. 차감된 캐쉬는 다음날 새벽에 충전 됩니다.
	    // params.put("delay", "10"); // 0~20사이의 값으로 전송지연 시간을 줄 수 있습니다.
	    // params.put("force_sms", "true"); // 푸시 및 알림톡 이용시에도 강제로 SMS로 발송되도록 할 수 있습니다.
	    // params.put("refname", ""); // Reference name
	    // params.put("country", "KR"); // Korea(KR) Japan(JP) America(USA) China(CN) Default is Korea
	    // params.put("sender_key", "5554025sa8e61072frrrd5d4cc2rrrr65e15bb64"); // 알림톡 사용을 위해 필요합니다. 신청방법 : http://www.coolsms.co.kr/AboutAlimTalk
	    // params.put("template_code", "C004"); // 알림톡 template code 입니다. 자세한 설명은 http://www.coolsms.co.kr/AboutAlimTalk을 참조해주세요. 
	    // params.put("datetime", "20140106153000"); // Format must be(YYYYMMDDHHMISS) 2014 01 06 15 30 00 (2014 Jan 06th 3pm 30 00)
	    // params.put("mid", "mymsgid01"); // set message id. Server creates automatically if empty
	    // params.put("gid", "mymsg_group_id01"); // set group id. Server creates automatically if empty
	    // params.put("subject", "Message Title"); // set msg title for LMS and MMS
	    // params.put("charset", "euckr"); // For Korean language, set euckr or utf-8
	    // params.put("app_version", "Purplebook 4.1") // 어플리케이션 버전

	    //{"group_id":"GID5CB5878D159B1","success_count":1,"error_count":0}
	    
	    try {
	      JSONObject result = coolsms.send(params);
	      System.out.println(result.toString());
	      System.out.println(result.get("result_message"));
	      if ((long)result.get("success_count") > 0) {
	          // 메시지 보내기 성공 및 전송결과 출력
	          System.out.println("성공");            
	          System.out.println("group_id : "+result.get("group_id")); // 그룹아이디
	          System.out.println("result_code : "+result.get("result_code")); // 결과코드
	          System.out.println("result_message"+result.get("result_message"));  // 결과 메시지
	          System.out.println("success_count"+result.get("success_count")); // 메시지아이디
	          System.out.println("error_count"+result.get("error_count"));  // 여러개 보낼시 오류난 메시지 수
//	          
//	          Scanner scan = new Scanner(System.in);
//	          String input = scan.nextLine();
//	          if(input.equalsIgnoreCase(key)) {
//	        	  System.out.println("인증성공");
//	          }else {
//	        	  System.out.println("인증실패");
//	          }
	      } else {
	          // 메시지 보내기 실패
	          System.out.println("실패");
	          System.out.println(result.get("code")); // REST API 에러코드
	          System.out.println(result.get("message")); // 에러메시지
	      }        
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	    }
	    
		return key;
	}
	@RequestMapping(value="/msgsend.do",method=RequestMethod.POST,
			produces="application/text; charset=UTF-8")
	@ResponseBody
	public String msgsend1(String phone, HttpSession session) {
		logger.info("Member_CTRL 문자인증");
		System.out.println("받은 data : "+phone);
		 int number = (int)(Math.random()*20+1);
		    String num = String.valueOf(number);
		    System.out.println("■■■■■■■■■■■■■■■■■■■■■■num의 값은?"+num);
		    String key = otp_iservice.selOTPKey(num);
		return key;
	}
	
	@RequestMapping(value="/idcheck.do",method=RequestMethod.POST,
		produces="application/text; charset=UTF-8")
	@ResponseBody
	public String idcheck(String id) {
		logger.info("Member_CTRL 아이디 중복체크");
		int n = member_iservice.idduplicatecheck(id);
		// n>0? 아이디사용 불가능
		// n<=0? 아이디 사용가능
		return n>0? "true": "false";
	}
	
	
}
