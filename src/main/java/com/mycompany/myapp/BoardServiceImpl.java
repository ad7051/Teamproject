package com.mycompany.myapp;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mycompany.myapp.BoardDAO;
import com.mycompany.myapp.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO boardDAO;

	@Override
	public int insertfile(HttpServletRequest request) {
		System.out.println("insertfile");
		String filename = ""; // 업로드되는 파일이름 저장용
		int sizeLimit = 15 * 1024 * 1024; // 파일크기 (15MB)

		// 실제로 서버에 저장되는 path를 upload로 정한다.
		String realPath = request.getServletContext().getRealPath("upload");
		// System.out.println(realPath);

		// 혹시 저장될 경로가 없으면 생성한다.
		File dir = new File(realPath);
		if (!dir.exists())
			dir.mkdirs();

		BoardVO one = null;
		MultipartRequest multipartRequest = null;
		try {
			// 파일 업로드 처리하는 과정 
			// 파라미터 : request, 파일저장경로, 최대용량, 인코딩, 중복파일명에 대한 정책
			// DefaultFileRenamePolicy() - 중복된 이름이 존재할 경우의 처리방법 - 뒤에 숫자붙임
			multipartRequest = new MultipartRequest(request, realPath, 
					sizeLimit, "utf-8",new DefaultFileRenamePolicy());

			// "photo"라는 이름으로 전송되어 업로드된 파일 이름을 가져옴 
			filename = multipartRequest.getFilesystemName("photo");
			
			one = new BoardVO();
			String id = multipartRequest.getParameter("sid");
			if(id!=null&&!id.equals("")) one.setSid(Integer.parseInt(id));
			one.setTitle(multipartRequest.getParameter("title"));
			if (id!=null&&!id.equals("")) {  // edit 인 경우 기존 파일이름과 비교해야 함 
				BoardDAO dao = new BoardDAO();
				String oldfilename = dao.getPhoto(Integer.parseInt(id));
				if(filename!=null && oldfilename!=null) // 새로 덮어씌울 파일이 전송된 경우 이전 파일을 제거함 
					BoardService.deleteFile(request, oldfilename);
				else if(filename==null && oldfilename!=null) // 새로운 파일이 없는 경우 이전 파일을 유지함 
					filename = oldfilename;
			}
			one.setPhoto(filename);			
		} catch (IOException e) {
			e.printStackTrace();
		}
		one.setPhoto(filename);
		one.setTitle(multipartRequest.getParameter("title"));
		one.setPassword(multipartRequest.getParameter("password"));
		one.setDetail(multipartRequest.getParameter("detail"));
		System.out.println("realPath:" + realPath);
		
		return boardDAO.insertBoard(one);
	}

	/*
	 * // TODO Auto-generated method stub return boardDAO.insertBoard(vo); }
	 */
	@Override
	public int insertBoard(BoardVO vo) {
		return boardDAO.insertBoard(vo);
	}

	@Override
	public int deleteBoard(int seq) {
		// TODO Auto-generated method stub
		return boardDAO.deleteBoard(seq);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.updateBoard(vo);
	}
	
	@Override
	public int updatefile(HttpServletRequest request) {
		System.out.println("updatefile");
		String filename = ""; // 업로드되는 파일이름 저장용
		int sizeLimit = 15 * 1024 * 1024; // 파일크기 (15MB)

		// 실제로 서버에 저장되는 path를 upload로 정한다.
		String realPath = request.getServletContext().getRealPath("upload");
		// System.out.println(realPath);

		// 혹시 저장될 경로가 없으면 생성한다.
		File dir = new File(realPath);
		if (!dir.exists())
			dir.mkdirs();

		BoardVO one = null;
		MultipartRequest multipartRequest = null;
		try {
			// 파일 업로드 처리하는 과정 
			// 파라미터 : request, 파일저장경로, 최대용량, 인코딩, 중복파일명에 대한 정책
			// DefaultFileRenamePolicy() - 중복된 이름이 존재할 경우의 처리방법 - 뒤에 숫자붙임
			multipartRequest = new MultipartRequest(request, realPath, 
					sizeLimit, "utf-8",new DefaultFileRenamePolicy());

			// "photo"라는 이름으로 전송되어 업로드된 파일 이름을 가져옴 
			filename = multipartRequest.getFilesystemName("photo");
			System.out.println(filename);
			
			one = new BoardVO();
			String id = multipartRequest.getParameter("sid");
			one.setSid(Integer.parseInt(id));	
			BoardVO to=new BoardVO();
			to=getBoard(Integer.parseInt(id));
			String photoname=to.getPhoto();
			System.out.println("Photo"+photoname);
			if(filename==null) {
				System.out.println("testwork on null");
				one.setPhoto(photoname);
			}else {
			one.setPhoto(filename);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		one.setTitle(multipartRequest.getParameter("title"));
		one.setPassword(multipartRequest.getParameter("password"));
		one.setDetail(multipartRequest.getParameter("detail"));
		System.out.println("realPath:" + realPath);
		System.out.println("file name: "+one.getPhoto()+"  title: "+one.getTitle()+" detail: "+one.getDetail()+"id :"+one.getSid()+"pssword: "+one.getPassword());
		
		
		boardDAO.updateBoard(one);
		// TODO Auto-generated method stub
		return  0;
	}

	@Override
	public BoardVO getBoard(int seq) {
		// TODO Auto-generated method stub
		return boardDAO.getBoard(seq);
	}
	@Override
	public String getPhoto(int seq) {
		BoardVO vo = boardDAO.getBoard(seq);
		String photo = vo.getPhoto();
		// TODO Auto-generated method stub
		return photo;
	}

	@Override
	public List<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return boardDAO.getBoardList();
	}

	@Override
	public int good(int seq) {
		int sid = seq;
		return boardDAO.good(sid);
	}

	@Override
	public int bad(int seq) {
		int sid = seq;
		return boardDAO.bad(sid);
	}

}
