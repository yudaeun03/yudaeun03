package com.kh.springhome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.kh.springhome.dao.CertDao;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class RegularServiceImpl implements RegularService {

	@Autowired
	CertDao certDao;
	
	// 스케줄러 메소드는 언제 실행할 것인지에 대한 설정이 추가로 필요 
	// @Scheduled(fixedRate = 1000) // 1000ms에 한번씩 실행
	// @Scheduled(cron = "* * * * * *") // 매초 매분 매시 매일 매월 매요일 
	// @Scheduled(cron = "0 * * * * *") // 0초 매분 매시 매일 매월 매요일 
//	@Scheduled(cron = "*/2 * * * * *") // 매2초 매분 매시 매일 매월 매요일 
//	@Scheduled(cron = "0 0 * * * *") // 0초 매분 매시 매일 매월 매요일 (1분마다)
//	@Scheduled(cron = "0 30 * * * *") // 매 시 정각마다
// 	@Scheduled(cron = "0 0 9 * * *") // 매일아침 9시 
//	@Scheduled(cron = "0 30 9,18") // 출근 9:30, 퇴근 18:30
//  @Scheduled(cron = "0 30 9-18 * * *") // 출근 할 때 부터 퇴근할 때 까지 1시간마다 
//	@Scheduled(cron = "0 30 9-18 * * 1-5") // 월 ~ 금까지 근무시간 1시간마다 
//	@Scheduled(cron = "0 30 9-18 * * mon-fri") // 월 ~ 금까지 근무시간 1시간마다 
//	@Scheduled(cron = "* * * * * mon") // 월요일 1초마다 ?
//	@Scheduled(cron = "* * * 18 * *") // 
//	@Scheduled(cron = "0 0 12 ? * 4L") // 매월 마지막 (L) 목요일 (4) 12시정각 
	
	@Override
	public void clearCert() {
		certDao.deleteOver5min();
	//log.debug("실행 되니 ?? ?? ???");
		
	}
	
	
}
