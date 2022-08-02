package com.spring.ex02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.spring.ex01.PersonService;

public class PersonTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//실행시 person_1.xml을 읽어 들여 빈을 생성
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person_1.xml"));
		//id가 personService1인 빈을 가져옮
		PersonService person1 = (PersonService) factory.getBean("personService1");
		person1.sayHello(); // 빈의 sayHello()를 호출
		System.out.println();
		
		PersonService person2 = (PersonService) factory.getBean("personService2");
		person2.sayHello(); // 빈의 sayHello()를 호출
	}
}
