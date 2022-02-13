package com.sesac.education.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.sesac.vo.BookVO;

@Controller
@RequestMapping("/test") //type level에 요청주소 작성하기
public class HelloController {
	
	@RequestMapping("/hello1") //method level 작성 
	public String hello1() {
		System.out.println("Hello1 요청");
		return "helloPage1"; ///WEB-INF/views/helloPage1.jsp 로 forward
		//이 방식을 servlet-context.xml 에서 설정한다
		//또한 이제 bean.properties로 관리할 필요 없음! 스프링이 직접 관리
	}
	
	@RequestMapping("/hello2") //유저가 /hello2 로 요청 --> 이 이름이 중요! 
	public ModelAndView test2() { //함수명은 마음대로 쓸 수 있음
		System.out.println("Hello2 요청");
		ModelAndView mv = new ModelAndView();
		
		//request.setAttribute 동일하게 등록해놓으면 el태그 사용 가능하다
		mv.addObject("title", "SpringFrameWork학습");
		mv.addObject("price", 5000);
		mv.addObject("book", new BookVO(10, "javaSpring", "serin", null, null));
		
		mv.setViewName("helloPage1"); //이 페이지로 포워드 시킬 것
		
		return mv; ///WEB-INF/views/helloPage1.jsp 로 forward
	}
	
	@RequestMapping(value = {"/hello3", "/hello.do", "/hello.test"}) //여러 요청 주소들을 배열 형태로 설정하기 가능
	public String hello3(Model model) {
		//Model 공유영역에 등록할 수 있는 데이터를 뜻함
		model.addAttribute("myname", "serin");
		model.addAttribute("phone", "010-1234-9876");
		return "helloPage3";
	}
	
	@RequestMapping("/hello5")
	public void hello5(Model model) {
		model.addAttribute("myname", "serin");
		model.addAttribute("phone", "010-1234-9876");
		//파일 [/WEB-INF/views/test/hello5.jsp]을(를) 찾을 수 없습니다. 자동으로 hello5.jsp를 찾는다
		//이름이 같으면 꼭 리턴하지 않아도 된다
		//하지만 경로에 test가 들어갔으므로 잘 확인할 것
	}
	
	//리턴 방법 3가지 (ModelAndView, String, void)
	//String, void 방법 권장
	
	
	
	//Get방식 요청하는 방법
	//1. 직접 url 경로 엔터 2.a태그 이용 3.form 태그 이용
	@RequestMapping(value = "/login", method = RequestMethod.GET) //method = RequestMethod.GET 원래는 생략되어 있음
	public String loginGet() {
		return "user/loginForm"; //Servlet-context에서 접두사 확인할 수 있음 -> 앞에 슬래시 없어도됨
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(String userid, String userpwd, Model model) {
		
		System.out.println("id : "+userid+", pwd : "+userpwd);
		
		if(userid == null) {
			model.addAttribute("msg", "아이디가 존재하지 않습니다.");
		} else{
			model.addAttribute("msg", "로그인 성공!");
		}
		
		return "user/loginResult"; 
	}
	
	
	
	
	//params관련 속성
	@RequestMapping(value = {"helloParam.do"}, 
			params = {"userid=serin", "userpwd", "!email"}, method = RequestMethod.GET)
	//id는 무조건 serin, pwd는 있기만 하면 가능, email은 존재하면 안됨
	public String helloParam(Model model, String userid, String userpwd) {
		System.out.println("useid : " +userid);
		System.out.println("userpwd : " +userpwd);
		model.addAttribute("msg", "helloParam 로그인 성공!");
		return "user/loginResult";
	}
	//http://localhost:9999/education/test/helloParam.do?userid=serin&userpwd=1111
	//http://localhost:9999/education/test/helloParam.do?userid=serin&userpwd=1234
	//둘 다 loginResult 나온다
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
