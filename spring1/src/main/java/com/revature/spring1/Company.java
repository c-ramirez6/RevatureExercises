package com.revature.spring1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Company implements InitializingBean, DisposableBean{
	private String name;
	private String size;
	
	public Company(String name, String size) {
		super();
		this.name = name;
		this.size = size;
	}
	
	
	
	@Override
	public String toString() {
		return "Company [name=" + name + ", size=" + size + "]";
	}



	public void destroy() throws Exception {
		System.out.println(this.name + " is closed for the day");
		
	}
	public void afterPropertiesSet() throws Exception {
		System.out.println(this.name + " is open for buisness!");
		
	}

}
