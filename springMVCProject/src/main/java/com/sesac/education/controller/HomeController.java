package com.sesac.education.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller //Component의 일종
public class HomeController {
	//상속받는 클래스 없음
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws ClassNotFoundException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws ClassNotFoundException {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		//int a=10/0;
		//System.out.println(a); -> 연산오류 페이지 이동
		
		//Class.forName("kr.co.sesac.vo.BookVO.class"); //에러 안남
		//Class.forName("kr.co.sesac"); //없는 클래스를 메모리에 올리려니 오류!
		//-> 기타 오류 페이지 이동
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("myname", "serin" );
		
		
		return "home";
	}
	
}
