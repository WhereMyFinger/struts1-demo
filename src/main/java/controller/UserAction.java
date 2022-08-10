package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import entities.User;
import model.UserDTO;
import service.UserService;

public class UserAction extends MappingDispatchAction{
	
	public ActionForward getListUsers(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		UserService userService = new UserService();
		List<User> list = userService.getListUsers();
		request.setAttribute("userList", list);
		
		return mapping.findForward("getUserList");
	}
	
	public ActionForward addForm(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return mapping.findForward("addUserForm");
		
	}
	
	public ActionForward addUser(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		UserDTO userdto = (UserDTO) form;
		UserService userService = new UserService();
		User user = new User(userdto.getName(), Integer.valueOf(userdto.getAge()));
		int result = userService.addUser(user);
		if (result <=0) {
			request.setAttribute("message","Something wrong! Cannot add user");
		}else{
			request.setAttribute("message", "Add new user successfully!");
		}
		return mapping.findForward("addUser");
	}

}
