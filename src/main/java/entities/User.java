package entities;

import java.sql.Date;

import Utils.CommonUtil;

import org.apache.struts.action.ActionForm;

public class User extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int age;
	private String email;
	private String password;
	
	public User() {}
	
	public User(String email, String password) {
		super();
		this.email = email;
		setPassword(password);
	}
	
	public User(String name, int age, String email, String password) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		setPassword(password);
	}
	
	public User(int id, String name, int age, String email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = CommonUtil.getHashedPassword(password);
	}
}
