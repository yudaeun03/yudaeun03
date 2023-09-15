package com.kh.springhome.controller;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.springhome.dao.BoardDao;
import com.kh.springhome.dao.MemberDao;
import com.kh.springhome.dto.BoardDto;
import com.kh.springhome.dto.BoardListDto;
import com.kh.springhome.dto.MemberDto;
import com.kh.springhome.error.NoTargetException;
import com.kh.springhome.vo.PaginationVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private MemberDao memberDao;
	
	//등록(새글 or 답글)
	//- boardParent라는 항목의 유무에 따라 새글과 답글을 구분하여 처리
	@GetMapping("/write")
	public String write(Model model, 
		@RequestParam(required = false) Integer boardParent) {

		//답글이라면 원본글 정보를 화면에 전달
		if(boardParent != null) {//답글 = boardParent가 있으면
			BoardDto originDto = boardDao.selectOne(boardParent);
			model.addAttribute("originDto", originDto);
			model.addAttribute("isReply", true);
		}
		else {//새글 = boardParent가 없으면
			model.addAttribute("isReply", false);
		}
		
		return "/WEB-INF/views/board/write.jsp";
	}
	
	@PostMapping("/write")
	public String write(
			@ModelAttribute BoardDto boardDto,
			HttpSession session) {
		int boardNo = boardDao.sequence();
		boardDto.setBoardNo(boardNo);
		
		String memberId = (String) session.getAttribute("name");
		boardDto.setBoardWriter(memberId);
		
		//글 등록 전에 새글/답글에 따른 그룹,상위글,차수를 계산
		if(boardDto.getBoardParent() == null) {//새글일 경우
			boardDto.setBoardGroup(boardNo);//그룹번호는 글번호로 설정
			//boardDto.setBoardParent(null);//상위글번호는 null로 설정
			//boardDto.setBoardDepth(0);//차수 0으로 설정
		}
		else {//답글일 경우
			BoardDto originDto = boardDao.selectOne(boardDto.getBoardParent());
			boardDto.setBoardGroup(originDto.getBoardGroup());//그룹번호는 원본글 그룹번호와 동일
			//boardDto.setBoardParent(originDto.getBoardNo());//상위글번호는 원본글 번호
			boardDto.setBoardDepth(originDto.getBoardDepth()+1);//차수는 원본글 차수 + 1
		}
		
		//이 사용자의 마지막 글번호를 조회
		Integer lastNo = boardDao.selectMax(memberId);
		
		//글을 등록하고
		boardDao.insert(boardDto);
		
		//포인트 계산 작업
		//- lastNo가 null이라는 것은 처음 글을 작성했다는 의미
		//- lastNo가 null이 아니면 조회한 다음 시간차를 비교
		if(lastNo == null) {//처음이라면
			memberDao.increaseMemberPoint(memberId, 10);//10점 부여
		}
		else {//처음이 아니라면 시간 차이를 계산
			BoardDto lastDto = boardDao.selectOne(lastNo);
			Timestamp stamp = new Timestamp(
								lastDto.getBoardCtime().getTime());
			LocalDateTime lastTime = stamp.toLocalDateTime();
			LocalDateTime currentTime = LocalDateTime.now();
			
			Duration duration = Duration.between(lastTime, currentTime);
			long seconds = duration.getSeconds();
			if(seconds > 300) {//시간차가 300초보다 크다면(5분 초과)
				memberDao.increaseMemberPoint(memberId, 10);//10점 부여
			}
		}
		
		return "redirect:detail?boardNo="+boardNo;
	}
	
	//목록+검색
	//- 검색일 경우에는 type과 keyword라는 파라미터가 존재
	//- 목록일 경우에는 type과 keyword라는 파라미터가 없음
	//- 만약 불완전한 상태(type이나 keyword만 있는 경우)라면 목록으로 처리
	//- (추가) 페이징 관련 처리
//	@RequestMapping("/list")
//	public String list(Model model, 
//			@RequestParam(required = false) String type,
//			@RequestParam(required = false) String keyword,
//			@RequestParam(required = false, defaultValue = "1") int page) {
//		boolean isSearch = type != null && keyword != null;
//		
//		//페이징과 관련된 값들을 계산하여 JSP로 전달
//		int begin = (page - 1) / 10 * 10 + 1;
//		int end = begin + 9;
//		//int count = 목록 개수 or 검색 결과수;
//		int count = isSearch ? 
//					boardDao.countList(type, keyword) : boardDao.countList();
//		int pageCount = (count-1) / 10 + 1;
//		model.addAttribute("page", page);
//		model.addAttribute("begin", begin);
//		model.addAttribute("end", Math.min(pageCount, end));
//		model.addAttribute("pageCount", pageCount);
//		
//		if(isSearch) {//검색일 경우
//			//List<BoardListDto> list = boardDao.selectList(type, keyword);
//			List<BoardListDto> list = 
//								boardDao.selectListByPage(type, keyword, page);
//			model.addAttribute("list", list);
//			model.addAttribute("isSearch", true);
//		}
//		else {//목록일 경우
//			//List<BoardListDto> list = boardDao.selectList();
//			List<BoardListDto> list = boardDao.selectListByPage(page);
//			model.addAttribute("list", list);
//			model.addAttribute("isSearch", false);
//		}
//		return "/WEB-INF/views/board/list.jsp";
//	}
	
//	(추가) @ModelAttribute로 받은 데이터는 이름만 정하면 자동으로 화면으로 넘어간다
//	- @ModelAttribute(name="vo")는 model.addAttribute("vo", ??)와 같다
	@RequestMapping("/list")
	public String list(@ModelAttribute(name = "vo") PaginationVO vo,
									Model model) {
		int count = boardDao.countList(vo);
		vo.setCount(count);
//		model.addAttribute("vo", vo);

		List<BoardListDto> list = boardDao.selectListByPage(vo);
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/board/list2.jsp";
	}
	
	//상세
	@RequestMapping("/detail")
	public String detail(@RequestParam int boardNo, 
							Model model, HttpSession session) {
		BoardDto boardDto = boardDao.selectOne(boardNo);//조회
		model.addAttribute("boardDto", boardDto);
		//작성자의 회원정보 추가
		String boardWriter = boardDto.getBoardWriter();
		if(boardWriter != null) {
			MemberDto memberDto = memberDao.selectOne(boardWriter);
			model.addAttribute("writerDto", memberDto);
		}
		return "/WEB-INF/views/board/detail.jsp";
	}
	
	//삭제
	//- 만약 소유자 검사를 추가한다면
	//- 현재 로그인 한 사용자와 게시글 작성자가 같다면 소유자로 판정
//	@RequestMapping("/delete")
//	public String delete(@RequestParam int boardNo, HttpSession session) {
//		BoardDto boardDto = boardDao.selectOne(boardNo);
//		String boardWriter = boardDto.getBoardWriter();
//		
//		String memberId = (String) session.getAttribute("name");
//		
//		if(memberId.equals(boardWriter)) {//소유자라면
//			boardDao.delete(boardNo);
//			return "redirect:list";
//		}
//		else {
//			throw new AuthorityException("글 작성자가 아닙니다");
//		}
//	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int boardNo) {
		boolean result = boardDao.delete(boardNo);
		if(result) {
			return "redirect:list";
		}
		else {
			//return "redirect:에러페이지";
			throw new NoTargetException("없는 게시글 번호");
		}
	}
	
	//수정
	@GetMapping("/edit")
	public String edit(@RequestParam int boardNo, Model model) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		model.addAttribute("boardDto", boardDto);
		return "/WEB-INF/views/board/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto boardDto) {
		boolean result = boardDao.update(boardDto);
		if(result) {
			return "redirect:detail?boardNo=" + boardDto.getBoardNo();
		}
		else {
			throw new NoTargetException("존재하지 않는 글번호");
		}
	}
	
	//추가 : 멘션 형태의 게시글 목록(멘션일 경우 BE에서 검색은 없습니다)
	@RequestMapping("/list-mention")
	public String listMention(Model model) {
		model.addAttribute("list", boardDao.selectMentionList());
		return "/WEB-INF/views/board/listMention.jsp";
	}
	
	//관리자가 이용하는 선택삭제 기능
	@PostMapping("/deleteByAdmin")
	public String deleteByAdmin(
			@RequestParam List<Integer> boardNoList) {
		for(int boardNo : boardNoList) {
			boardDao.delete(boardNo);
		}
		return "redirect:list";
	}
	
}






