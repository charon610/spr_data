package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userID = "";
		String passwd = "";
		String viewName=getViewName(request); // getViewName() 메서드를 호출, 요청명에서 확장명 .do를 제외한 뷰이름을 가져옴
		
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		/*
		 * String id = request.getParameter("id"); 
		 * String pwd = request.getParameter("pwd"); 
		 * String name = request.getParameter("name");
		 * String email = request.getParameter("email");
		 */
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");

		mav.addObject("userID", userID); // ModelAndView에 로그인 정보를 바인딩합니다.
		mav.addObject("passwd", passwd);

		/*
		 * mav.addObject("id", id); 
		 * mav.addObject("pwd", pwd); 
		 * mav.addObject("name", name); 
		 * mav.addObject("email", email); 
		 * mav.setViewName("memberInfo"); //
		 * memberInfo.jsp로 포워딩
		 */
		/*
		 * mav.setViewName("result"); // ModelAndView 객체에 포워딩할 JSP 이름을 설정.
		 */
		mav.setViewName(viewName);  // 뷰 이름 지정
		System.out.println("ViewName:" + viewName);
		return mav;
	}

	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String fileName = uri.substring(begin, end);
		if (fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}
		if (fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
		}
		return fileName;
	}

	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		return new ModelAndView(viewName);
	}

	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		return new ModelAndView(viewName);
	}

}
