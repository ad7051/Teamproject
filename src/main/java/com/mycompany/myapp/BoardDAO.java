package com.mycompany.myapp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Autowired
	SqlSession sqlSession;
	
	public int insertBoard(BoardVO vo) {
		int result = sqlSession.insert("Board.insertBoard",vo);
		return result;
	}
	
	public int updateBoard(BoardVO vo) {
		int result = sqlSession.update("Board.updateBoard",vo);
		return result;
	}
	
	public int deleteBoard(int seq) {
		int result = sqlSession.delete("Board.deleteBoard",seq);
		return result;
	}

	public int good(int sid) {
		int result=sqlSession.update("Board.updateG",sid);
		return result;
	}
	public int bad(int sid) {
		int result=sqlSession.update("Board.updateB",sid);
		return result;
	}
	
	public BoardVO getBoard(int seq) {
		BoardVO result = sqlSession.selectOne("Board.getBoard",seq);
		return result;
	}
	
	public List<BoardVO> getBoardList() {
		List<BoardVO> result = sqlSession.selectList("Board.getBoardList");
		return result;
	}
	public String getPhoto(int seq) {
		System.out.println("DAO"+seq);
		BoardVO vo = sqlSession.selectOne("Board.getPhoto",seq);
		String result=vo.getPhoto();
		return result;
	}
	
}
