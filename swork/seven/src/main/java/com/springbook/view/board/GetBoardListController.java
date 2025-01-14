package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class GetBoardListController implements Controller {
	@Autowired
	BoardService boardService;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글 목록 검색 처리");

//		request.setCharacterEncoding("utf-8");

		// 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		String keyword, condition;		

		keyword = request.getParameter("searchKeyword") == null ? "" : request.getParameter("searchKeyword");
		condition = request.getParameter("searchCondition") == null ? "TITLE" : request.getParameter("searchCondition");

		if (condition.equals("TITLE")) {
			vo.setTitle(keyword);
			vo.setContent("");
		} else {
			vo.setTitle("");
			vo.setContent(keyword);
		}

		List<BoardVO> boardList = boardService.getBoardList(vo, keyword, condition);

		// 3. 검색 결과를 세션에 저장하고 목록 화면을 리턴한다.
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.setViewName("board/getBoardList");
		return mav;
	}
}