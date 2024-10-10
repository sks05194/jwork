package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService boardService = (BoardService) container.getBean("boardService");

		BoardVO vo = new BoardVO();
		vo.setTitle("JdbcTemplate 테스트");
		vo.setWriter("홍길동");
		vo.setContent("JdbcTemplate 테스트");
		boardService.insertBoard(vo);
		
		vo.setSeq(50);
		System.out.println("\ngetBoard(50) 데이터");
		System.out.println(boardService.getBoard(vo));
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO boardVO : boardList) {
			System.out.println(boardVO);
		}

		container.close();
	}
}