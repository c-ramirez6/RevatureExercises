package com.revature.spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("resources/config.xml");
        context.registerShutdownHook();
        Student student1 = (Student) context.getBean("student1");
        Student student2 = (Student) context.getBean("student2");
        Student student3 = (Student) context.getBean("student3");
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        
        Employee emp1 = (Employee) context.getBean("employee1");
        System.out.println(emp1.getName());
        System.out.println(emp1.getPhoneNumbers());
        System.out.println(emp1.getAddresses());
        System.out.println(emp1.getDepartment());
        
        Customer cust = (Customer) context.getBean("customer1");
        System.out.println(cust);
        
        Pet pet = (Pet) context.getBean("pet1");
        System.out.println(pet);
        
        Company company = (Company) context.getBean("company1");
        System.out.println(company);
    }
}
