package com.sesac.education.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

//1.설정 파일을 이용해서 500Error 전역처리 -> servlet-context.xml 확인
//2.@ControllerAdvice 를 이용해서 전역 Exception을 처리
@ControllerAdvice //web.xml 에 param조건 추가
public class ExceptionController {

	@ExceptionHandler(NoHandlerFoundException.class)
	public String handler404(HttpServletRequest request, Model model) {
		model.addAttribute("msg", "존재하지않는 페이지입니다.");
		model.addAttribute("url", request.getRequestURL());
		return "error/errorPage404";
	}
	
	/* 500에러도 여기서 처리할 수도 있음
	 * @ExceptionHandler(Exception.class) public String
	 * handler500(HttpServletRequest request, Model model) {
	 * model.addAttribute("aaa", "문법 오류"); return "error/errorPage500"; }
	 */
}
