package com.mycompany.myapp;

import java.util.List;

public interface BoardService {
	public int insertBoard(BoardVO vo);
	public int deleteBoard(int seq);
	public int updateBoard(BoardVO vo);
	public BoardVO getBoard(int seq);
	public int good(int seq);
	public int bad(int seq);
	public List<BoardVO> getBoardList();
}
