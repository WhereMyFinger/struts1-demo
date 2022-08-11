package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import entities.User;
import service.UserService;

public class UserAction extends MappingDispatchAction{
	
	public ActionForward getListUsers(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		/*
		 * HttpSession session = request.getSession(); if (session == null) {
		 * response.sendRedirect("/struts1-demo/login.html"); } else {
		 * 
		 * }
		 */
		UserService userService = new UserService();
		List<User> list = userService.getListUsers();
		request.setAttribute("userList", list);
		
		return mapping.findForward("getUserList");
	}
	
	public ActionForward getLoginPage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return mapping.findForward("loginPage");
		
	}
	
	public void login(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserService userService = new UserService();
		User user = new User(email, password);
		boolean isValid = userService.checkLogin(user);
			
		if (isValid) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("/struts1-demo/home.html");
		}
		else {
			request.setAttribute("message","Invalid email or/and password!");
			response.sendRedirect("/struts1-demo/login.html");
		}
	}
	
	public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			
		HttpSession session = request.getSession();
		session.invalidate();
		
		return mapping.findForward("logout");
	}
	
	public ActionForward addForm(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return mapping.findForward("addUserForm");		
	}
	
	public void addUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserService userService = new UserService();
		User user = new User(name, Integer.valueOf(age), email, password);
		int result = userService.addUser(user);
		if (result <=0) {
			request.setAttribute("message","Something wrong! Cannot add user");
		}else{
			response.sendRedirect("/struts1-demo/home.html");
		}
		/* return mapping.findForward("addUser"); */
	}

}
