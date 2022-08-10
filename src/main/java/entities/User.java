package entities;

import java.sql.Date;

import org.apache.struts.action.ActionForm;

public class User extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int age;
	
	public User() {}
	
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public User(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
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
}
