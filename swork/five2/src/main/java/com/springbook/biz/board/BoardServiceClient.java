package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService boardService = (BoardService) container.getBean("boardService");

		BoardVO vo = new BoardVO();
		vo.setTitle("AOP annotation 테스트");
		vo.setWriter("홍길동");
		vo.setContent("AOP annotation 테스트");

//		try {
//			boardService.insertBoard(vo);
//		} catch (Exception e) {}
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO boardVO : boardList) {
			System.out.println(boardVO);
		}

		container.close();
	}
}