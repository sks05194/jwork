package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDAODBCP {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// CRUD 기능의 메소드 구현
	// 글 등록
	private final String BOARD_INSERT = "INSERT INTO board (title, writer, content) VALUES(?, ?, ?)";

	public int insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
		return jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	// 글 수정
	private final String BOARD_UPDATE = "UPDATE board SET title = ?, content = ? WHERE seq = ?";

	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 updateBoard() 기능처리");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	// 글 삭제
	private final String BOARD_DELETE = "DELETE FROM board WHERE seq = ?";

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 deleteBoard() 기능처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}

	// 글 상세 조회
	private final String BOARD_GET = "SELECT * FROM board WHERE seq = ?";

	public BoardVO getBoard(BoardVO vo) {
		try {
			System.out.println("===> Spring JDBC로 getBoard() 기능처리");
			Object[] args = { vo.getSeq() };
			return jdbcTemplate.queryForObject(BOARD_GET, new BoardRowMapper(), args);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	// 글 목록 조회
	private final String BOARD_LIST = "SELECT * FROM board ORDER BY seq DESC";

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring JDBC로 getBoardList() 기능처리");
		try {
			return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}