package com.kh.springhome.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.springhome.dao.MemberDao;
import com.kh.springhome.dto.MemberDto;
import com.kh.springhome.dto.StatDto;

@CrossOrigin
@RestController
@RequestMapping("/rest/member")
public class MemberRestController {

	@Autowired
	private MemberDao memberDao;
	
	@PostMapping("/idCheck")
	public String idCheck(@RequestParam String memberId) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		if(memberDto == null) {//아이디가 없으면
			return "Y";
		}
		else {//아이디가 있으면
			return "N";
		}
	}
	
	@PostMapping("/nicknameCheck")
	public String nicknameCheck(@RequestParam String memberNickname) {
		MemberDto memberDto = 
			memberDao.selectOneByMemberNickname(memberNickname);
		if(memberDto == null) {
			return "Y";
		}
		else {
			return "N";
		}
	}
	
	//회원 등급별 인원 수 데이터 반환 매핑
	@GetMapping("/stat/count")
	public List<StatDto> statCount() {
		return memberDao.selectGroupByMemberLevel();
	}
	
}




