package com.mycompany.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String boardlist(Model model) {
		model.addAttribute("list",boardService.getBoardList());
		return "list";
	}
	
	@RequestMapping(value = "/view/{id}",method = RequestMethod.GET)
	public String viewPost(@PathVariable("id") int id, Model model) {
		BoardVO  boardVO = boardService.getBoard(id);
		model.addAttribute("u",boardVO);
		return "view";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addPost() {
		return "addpostform";
	}
	
	@RequestMapping(value="/addok", method=RequestMethod.GET)
	public String addPostOk(BoardVO vo) {
		if(boardService.insertBoard(vo)==0)
			System.out.println("addok is working");
		else
			System.out.println("addok is not working");
		return "redirect:list";
	}
	
	@RequestMapping(value="/editform/{id}", method=RequestMethod.GET)
	public String editPost(@PathVariable("id") int id, Model model) {
		BoardVO boardVO = boardService.getBoard(id);
		model.addAttribute("u",boardVO);
		return "editform";
	}
	
	@RequestMapping(value="/editok", method=RequestMethod.POST)
	public String editPostOk(BoardVO vo) {
		if(boardService.updateBoard(vo)==0)
			System.out.println("update is not working");
		else
			System.out.println("update is working");
		return "redirect:list";
	}
	
	@RequestMapping(value="/deleteok/{id}", method=RequestMethod.GET)
	public String deletePostOk(@PathVariable("id") int id) {
		if(boardService.deleteBoard(id)==0)
			System.out.println("delete is not working");
		else
			System.out.println("delete is  working");
		return "redirect:../list";
	}
	
	@RequestMapping(value="/good/{id}",method=RequestMethod.GET)
	public String good(@PathVariable("id") int id) {
		if(boardService.good(id)==0)
			System.out.println("good is not working");
		else
			System.out.println("good is  working");
		return "redirect:../list";
	}
	@RequestMapping(value="/bad/{id}",method=RequestMethod.GET)
	public String bad(@PathVariable("id") int id) {
		if(boardService.bad(id)==0)
			System.out.println("bad is not working");
		else
			System.out.println("bad is  working");
		return "redirect:../list";
	}
	
}
