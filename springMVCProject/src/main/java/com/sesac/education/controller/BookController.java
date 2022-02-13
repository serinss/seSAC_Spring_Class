package com.sesac.education.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import kr.co.sesac.vo.BookVO;

@Controller
@RequestMapping("/book")
public class BookController {
	List<BookVO> blist = new ArrayList<BookVO>();
	
	//생성할 때 값을 삽입하기
	public BookController(){
		blist.add(new BookVO(1, "javaSpring", "세린", "민음사", "2022-02-08", 0));
		blist.add(new BookVO(2, "javaCore", "지연", "민음사", "2022-02-08", 0));
		blist.add(new BookVO(3, "Python", "서영", "민음사", "2022-02-08", 0));
		blist.add(new BookVO(4, "HTML", "유진", "민음사", "2022-02-08", 0));
		blist.add(new BookVO(5, "CSS", "예진", "민음사", "2022-02-08", 0));
		blist.add(new BookVO(6, "javaSpring", "세린", "민음사", "2022-02-08", 0));
	}
	
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	// 405에러 – 허용되지 않는 메소드
	public String bookInsert() {

		return "book/bookInsertForm";
	}

	
	 @RequestMapping(value="/insert", method = RequestMethod.POST) 
	 public String bookInsertPost(
			 @RequestParam("bno") int bookNo, 
			 String title, String author, 
			 String pub, String pubDate, int status, @ModelAttribute("book") BookVO book,
			 Model model, RedirectAttributes redirectAttr) { 
		 //->BookVO 형태로 넣자
		 //지정된 파라미터를 사용하지 않으면 상태 500 에러
		 //Optional int parameter 'bookNo' is present but cannot be translated into a null value due to being declared as a primitive type.
		 //굳이 쓰고 싶다면 @RequestParam("bno") 를 붙여주자
		 
		 //@RequestParam = int bookNo = Integer.parseint(request.getParameter("bno"))
		 // -> 변수 이름과 파라미터 이름이 같다면 생략
		 //@ModelAttribute("등록할 이름") 사용 : 받은 내용을 전달하여 출력
		 
		 //+RedirectAttributes redirectAttr 변수 : 리다이렉트시, 값을 전달하는 역할
		 // 리다이렉트 하면 모델에 저장한 값은 전달되지 않으므로
		 
		 model.addAttribute("myname", "serin");
		 model.addAttribute("book2", book);
		 blist.add(book);
		 redirectAttr.addFlashAttribute("msg", "신규 도서 등록이 완료되었습니다.");
		 //입력력한 후, 리스트를 다시 조회
		 return "redirect:/book/list"; 
		 
	 } //함수의 경우 파라미터가 보이지 않음!
	 

	/*
	 * @RequestMapping(value="/insert2", method = RequestMethod.GET) public String
	 * bookInsertPost() { return "book/bookResult"; }
	 */
	// http://localhost:9999/education/book/insert2?bno=sdsdf&title=d&author=d&pub=d&pubDate=d&status=d
	// 형태로 보여줄 수 있음
	
	/*@RequestMapping(value="/insert", method = RequestMethod.POST) 
	 public String bookInsertPost(BookVO book) { 
		 System.out.println(book);
		 return "book/bookResult"; 
	 }*/
	
	/* 하나의 Controller에서의 Exception처리
	 * @ExceptionHandler(Exception.class) public String processException(Exception
	 * e) { e.printStackTrace(); System.out.println("오류 : " +e.getMessage()); return
	 * "error/errorPage500"; }
	 */
	 
	@RequestMapping("/list")
	public String bookList(Model model, HttpServletRequest request) {
		
		//int a = 10/0;
		
		//리스트 출력 시, 등록을 하고 왔는지, 수정을 하고 왔는지 확인해야 한다 -> Map형태로
		//request타입은 스프링api에 들어있으므로 직접 선언 가능
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if(flashMap != null) {
			String msg = (String)flashMap.get("msg");
			System.out.println(msg);
			model.addAttribute("msg", msg); //->이제 해당 페이지에서 사용 가능하다
		}
		
		model.addAttribute("bookList", blist);
		return "book/bookList";
	}
	
	//상세 페이지
	@RequestMapping("/list/detail")
	public String bookDetail(int bno, Model model) {
		//List에서 bno를 찾기
		BookVO book = null;
		for(BookVO b : blist) {
			if(b.getBno() == bno) {
				book = b;
				break;
			}
		}
		//정보를 model에 저장하기
		model.addAttribute("book", book);
		//detail페이지에 forward
		return "book/bookDetail";
	}
	
	//수정하기
	@RequestMapping(value = "/list/update", method = RequestMethod.POST)
	public String bookUpdate(BookVO book, Model model, RedirectAttributes redirectAttr) {
		System.out.println("수정된 book : " +book);
		
		for(BookVO b : blist) {
			if(b.getBno() == book.getBno()) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
				b.setPub(book.getPub());
				b.setPubDate(book.getPubDate());
				b.setStatus(book.getStatus());
				break;
			}
		}
		redirectAttr.addFlashAttribute("msg", "수정되었습니다.");
		//리스트를 다시 조회
		return "redirect:/book/list"; //새로운 요청
		/*
		 * 스프링은 default가 forward이다
		 * -> redirect는 forward가 아니라 새롭게 book/list를 요청하여 list.jsp를 출력함
		 */
	}
	
	//삭제하기
	@RequestMapping(value = "/delete")
	public String bookUpdate(int bno, RedirectAttributes redirectAttr) {
		
		for(BookVO b : blist) {
			if(b.getBno() == bno) {
				blist.remove(b);
				break;
			}
		}
		redirectAttr.addFlashAttribute("msg", "삭제되었습니다.");
		//리스트를 다시 조회
		return "redirect:/book/list"; //새로운 요청
		
	}
	
	
	
	
}
