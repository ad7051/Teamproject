package com.mycompany.myapp;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {
	public int insertBoard(BoardVO vo);
	public int insertfile(HttpServletRequest request);
	public int deleteBoard(int seq);

	public int updateBoard(BoardVO vo);

	public BoardVO getBoard(int seq);

	public int good(int seq);

	public int bad(int seq);

	public List<BoardVO> getBoardList();

	public static void deleteFile(HttpServletRequest request, String filename) {
		String filePath = request.getServletContext().getRealPath("upload");

		File f = new File(filePath + "/" + filename);
		if (f.exists())
			f.delete();
	}

	public String getPhoto(int seq);

}
