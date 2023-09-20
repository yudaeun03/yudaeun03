package com.kh.springhome.rest;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.springhome.dao.CertDao;
import com.kh.springhome.dto.CertDto;

@CrossOrigin
@RestController
@RequestMapping("/rest/cert")
public class CertRestController {
	
	@Autowired
	private CertDao certDao;
	
	@Autowired
	private JavaMailSender sender;
	
	@PostMapping("/send")
	public void send(@RequestParam String certEmail) {
		//[1] 인증번호 생성
		Random r = new Random();
		int number = r.nextInt(1000000);
		DecimalFormat fm = new DecimalFormat("000000");
		String certNumber = fm.format(number);
		
		//[2] 이메일 발송
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(certEmail);
		message.setSubject("[KH정보교육원] 인증번호 안내");
		message.setText("인증번호는 [" + certNumber + "] 입니다");
		sender.send(message);
		
		//[3] DB에 저장(기존 데이터 삭제)
		certDao.delete(certEmail);
		CertDto certDto = new CertDto();
		certDto.setCertEmail(certEmail);
		certDto.setCertNumber(certNumber);
		certDao.insert(certDto);
	}
		
		// 인증번호 검사
		@PostMapping("/check")
		public Map<String, Object> check(@ModelAttribute CertDto certDto) {
			// [1] 이메일로 인증정보를 조회
			
			//CertDto findDto = certDao.selectOne(certDto.getCertEmail()); // 기간제한 
			CertDto findDto = certDao.selectOneIn5min(certDto.getCertEmail()); //5분전 
			if(findDto != null) {
				// [2] 인증번호 비교
				boolean isVaild = findDto.getCertNumber().equals(certDto.getCertNumber());
				if(isVaild) {
					// 인증 성공하면 인증번호를 삭제
					certDao.delete(certDto.getCertEmail());
					return Map.of("result", true);
				}
			}
			return Map.of("result", false);
			
	}
}





