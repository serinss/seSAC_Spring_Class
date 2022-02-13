package com.sesac.education.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.sesac.model.MemberService;
import kr.co.sesac.vo.BoardVO;
import kr.co.sesac.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberService mService;
	
	@RequestMapping("/member/joinForm.do")
	public String boardWriteForm(Model model) {
		//model.addAttribute("userVO", model);
		return "member/joinForm";
	}
	
	@RequestMapping(value="login.do", method = RequestMethod.POST)
	public String boardWrite(MemberVO member, RedirectAttributes attr) {
		
		int result = mService.insertMember(member);
		attr.addFlashAttribute("msg", result>0?"회원가입 완료":"회원가입 실패");
		return "redirect:/board/list.do";
	}
	
	
	@RequestMapping("/member/list")
	public String memberlist(Model model) {
		model.addAttribute("memberList", mService.selectAllMember());
		return "member/memberList";
	}
	
}
