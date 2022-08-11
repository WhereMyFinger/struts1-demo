package service;

import java.sql.SQLException;
import java.util.List;

import entities.User;
import repositories.UserRepository;

public class UserService {
	
	private UserRepository userRepository;
	
	public UserService() {
		userRepository = new UserRepository();
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> getListUsers() throws SQLException, Exception {
		return userRepository.getAllUsers();
	}
	
	public int addUser(User user) {
		try {
			return userRepository.addUser(user);
		} catch (Exception e) {
			return -1;
		}
	}
	
	public boolean checkLogin(User user) {
		try {
			return userRepository.checkLogin(user);
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * public static void main(String[] args) throws SQLException, Exception {
	 * System.out.print(new UserService().addUser(new User("heh", 22))); }
	 */
}
