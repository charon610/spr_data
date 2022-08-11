package com.spring.ex02;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController") // 컨트롤러 빈을 자동으로 생성.
public class LoginController {
	@RequestMapping(value = { "/test/loginForm.do", "/test/loginForm2.do" }, method = { RequestMethod.GET }) // /test/loginForm2.do와
																												// /test/loginForm2.do로
																												// 요청시
																												// loginForm()을
																												// 호출
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginForm");
		return mav;
	}

	@RequestMapping(value = "/test/login.do", method = { RequestMethod.GET, RequestMethod.POST }) // GET방식과 POST방식 요청 시
																									// 모두 처리
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		String userID = request.getParameter("userID");
		String userName = request.getParameter("userName");
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);

		return mav;
	}

	/*
	 * @RequestMapping(value = "/test/login2.do", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public ModelAndView login2(@RequestParam("userID")
	 * String userID,
	 * 
	 * @RequestParam("userName") String userName, HttpServletRequest request,
	 * HttpServletResponse response) throws Exception {
	 * request.setCharacterEncoding("utf-8"); ModelAndView mav = new ModelAndView();
	 * mav.setViewName("result");
	 * 
	 * // String userID = request.getParameter("userID"); // String userName =
	 * request.getParameter("userName");
	 * 
	 * System.out.println("userID: " + userID); System.out.println("userName: " +
	 * userName); mav.addObject("userID", userID); mav.addObject("userName",
	 * userName);
	 * 
	 * return mav; }
	 */
	
	
	@RequestMapping(value = "/test/login2.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login2(@RequestParam("userID") String userID,  // required 생략 시 기본값은 true.
							   @RequestParam(value = "userName", required = true) String userName,  
							   @RequestParam(value = "email", required = false) String email, HttpServletRequest request, HttpServletResponse response) throws Exception {  // 명시적으로 false 설정.
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");

		// String userID = request.getParameter("userID");
		// String userName = request.getParameter("userName");

		System.out.println("userID: " + userID);
		System.out.println("userName: " + userName);
		System.out.println("email: " + email);
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);
		return mav;
	}

	@RequestMapping(value = "/test/login3.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login3(@RequestParam Map<String, String> info, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// @RequestParam을 이용해 Map에 전송된 매개변수 이름을 key, 값을 value로 저장.
		
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();

		String userID = info.get("userID");  // Map에 저장된 매개변수의 이름으로 전달된 값을 가져 옮.
		String userName = info.get("userName");
		System.out.println("userID: " + userID);
		System.out.println("userName: " + userName);

		mav.addObject("info", info);  // @RequestParam에서 설정한 Map 이름으로 바인딩.
		mav.setViewName("result");
		return mav;
	}

	@RequestMapping(value = "/test/login4.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login4(@ModelAttribute("info") LoginVO loginVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		System.out.println("userID: " + loginVO.getUserID());
		System.out.println("userName: " + loginVO.getUserName());
		mav.setViewName("result");
		return mav;
	}

	@RequestMapping(value = "/test/login5.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String login5(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		model.addAttribute("userID", "hong");
		model.addAttribute("userName", "홍길동");
		return "result";
	}
}
