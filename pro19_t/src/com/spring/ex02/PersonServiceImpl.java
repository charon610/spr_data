package com.spring.ex02;

import com.spring.ex01.PersonService;

public class PersonServiceImpl implements PersonService {

	private String name;
	private int age;

	public PersonServiceImpl(String name) { // person1.xml에서 인자가 한 개인 생성자 설정 시 사용
		this.name = name;
	}

	public PersonServiceImpl(String name, int age) { // person1.xml에서 인자가 두 개인 생성자 설정 시 사용
		this.name = name;
		this.age = age;
	}
	
	
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("이름: " + name);
		System.out.println("나이: " + age + "세");
	}

}
