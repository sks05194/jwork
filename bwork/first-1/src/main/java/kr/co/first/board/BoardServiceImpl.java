package kr.co.first.board;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{
	private final BoardDAO dao;

	@Override
	public void register(Board board) throws Exception {
		dao.create(board);
	}

	@Override
	public List<Board> list() throws Exception {
		return dao.list();
	}

	@Override
	public Board read(int boardNo) throws Exception {
		return dao.read(boardNo);
	}

	@Override
	public void modify(Board board) throws Exception {
		dao.update(board);
	}

	@Override
	public void remove(int boardNo) throws Exception {
		dao.delete(boardNo);
	}
	
	

}
