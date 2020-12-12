package com.mycompany.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Autowired
	BoardService boardService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String boardlist(Model model) {
		model.addAttribute("list", boardService.getBoardList());
		return "list";
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String viewPost(@PathVariable("id") int id, Model model) {
		BoardVO boardVO = boardService.getBoard(id);
		model.addAttribute("u", boardVO);
		return "view";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPost() {
		return "addpostform";
	}

	@RequestMapping(value = "/addok", method = RequestMethod.POST)
	public String insertBoard(BoardVO vo, HttpServletRequest request) throws Exception {
		boardService.insertfile(request);
		return "redirect:list";
	}

	/*
	 * public String addPostOk(BoardVO vo) { if (boardService.insertBoard(vo) == 0)
	 * System.out.println("addok is not working"); else
	 * System.out.println("addok is  working"); return "redirect:list"; }
	 */
	@RequestMapping(value = "/editform/{id}", method = RequestMethod.GET)
	public String editPost(@PathVariable("id") int id, Model model) {
		BoardVO boardVO = boardService.getBoard(id);
		model.addAttribute("u", boardVO);
		System.out.println("testcheck"+boardVO.getPhoto());
		model.addAttribute("photo", boardVO.getPhoto());
		return "editform";
	}

	@RequestMapping(value = "/editok", method = RequestMethod.POST)
	public String editPostOk(HttpServletRequest request) {
		if (boardService.updateBoard(request) == 0)
			System.out.println("update is not working");
		else
			System.out.println("update is working");
		return "redirect:list";
	}

	@RequestMapping(value = "/deleteok/{id}", method = RequestMethod.GET)
	public String deletePostOk(@PathVariable("id") int id) {
		if (boardService.deleteBoard(id) == 0)
			System.out.println("delete is not working");
		else
			System.out.println("delete is  working");
		return "redirect:../list";
	}

	@RequestMapping(value = "/good/{id}", method = RequestMethod.GET)
	public String good(@PathVariable("id") int id) {
		if (boardService.good(id) == 0)
			System.out.println("good is not working");
		else
			System.out.println("good is  working");
		return "redirect:../list";
	}

	@RequestMapping(value = "/bad/{id}", method = RequestMethod.GET)
	public String bad(@PathVariable("id") int id) {
		if (boardService.bad(id) == 0)
			System.out.println("bad is not working");
		else
			System.out.println("bad is  working");
		return "redirect:../list";
	}

}
