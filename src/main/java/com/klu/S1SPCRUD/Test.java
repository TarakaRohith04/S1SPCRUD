package com.klu.S1SPCRUD;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Test{
    public static void main(String args[]){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		StudentDao dao = (StudentDao) ac.getBean("dao");

		//Insert
		Student s1 = new Student();
		s1.setSid(222);
		s1.setSname("DEF");

		dao.insert(s1);
		
		System.out.println("Student Details: " + dao.get().getSid() + " " + dao.get().getSname());

		Student s2 = new Student();
		s2.setSid(222);
		s2.setSname("XYZ");
		dao.update(s2);

		dao.delete();
    }
}
