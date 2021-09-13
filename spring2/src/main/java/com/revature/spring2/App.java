package com.revature.spring2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("resources/config.xml");
        
        Student student = (Student) context.getBean("student1");
        Student student2 = (Student) context.getBean("student2");
        //Course course = (Course) contex.getBean("course1");
        System.out.println(student);
        System.out.println(student2);
//        System.out.println(course);
    }
}
