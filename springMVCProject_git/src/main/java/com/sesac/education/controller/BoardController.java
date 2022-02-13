package com.sesac.education.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import kr.co.sesac.model.BoardService;
import kr.co.sesac.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	BoardService bService;
	
	@RequestMapping("/board/list.do")
	public String boardList(Model model, HttpServletRequest request) {
		
		Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
		if(map != null) {
			model.addAttribute("msg", map.get("msg"));
		}
		
		model.addAttribute("list", bService.selectAllBoard());
		return "board/list";
	}
	
	@RequestMapping("/board/detail.do")
	public String boardDetail(int no, Model model) {
		bService.viewCnt(no);
		model.addAttribute("fileList", bService.selectFileByNo(no));
		model.addAttribute("board", bService.selectBoardByNo(no));
		return "board/detail";
	}
	
	@RequestMapping("/board/writeForm.do")
	public String boardWriteForm(Model model) {
		//model.addAttribute("userVO", model);
		return "board/writeForm";
	}
	
	@RequestMapping(value="/board/write.do", method = RequestMethod.POST)
	public String boardWrite(BoardVO board, RedirectAttributes attr) {
		
		int result = bService.insertBoard(board);
		attr.addFlashAttribute("msg", result>0?"등록 완료":"등록 실패");
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value="/board/update.do", method = RequestMethod.GET)
	public String boardUpdateForm(int no, Model model) {
		
		model.addAttribute("board", bService.selectBoardByNo(no));
		return "board/updateForm";
	}
	
	@RequestMapping(value="/board/update.do", method = RequestMethod.POST)
	public String boardUpdate(BoardVO board, RedirectAttributes attr) {
		
		int result = bService.updateBoard(board);
		attr.addFlashAttribute("msg", result>0?"수정 완료":"수정 실패");
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value="/board/delete.do")
	public String boardDelete(int no, RedirectAttributes attr) {
		
		int result = bService.deleteByNo(no);
		attr.addFlashAttribute("msg", result>0?"삭제 완료":"삭제 실패");
		return "redirect:/board/list.do";
	}
	
}
