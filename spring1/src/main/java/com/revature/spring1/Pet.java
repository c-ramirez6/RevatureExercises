package com.revature.spring1;

public class Pet {
	private int id;
	private String name;
	private String type;
	
	public Pet(int id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", type=" + type + "]";
	}

	public void init()	{
		System.out.println("Bought a pet");
	}
	
	public void destroy()	{
		System.out.println("Lost the pet");
	}
}
