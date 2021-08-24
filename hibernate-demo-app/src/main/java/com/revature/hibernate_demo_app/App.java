package com.revature.hibernate_demo_app;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project started..." );
        
        //Create config
        Configuration cfg = new Configuration();
        
        //read config and load in the object
        cfg.configure("hibernate.cfg.xml");
        
        //Create factory
        SessionFactory factory = cfg.buildSessionFactory();
        
        //create employee object
//        Employee emp = new Employee();
//        emp.setId(1);
//        emp.setName("Mark");
//        emp.setEmail("mark@gmail.com");
//        System.out.println(emp);
//        
        //Create addresss
//        Address address = new Address();
//        address.setCity("California");
//        address.setStreet("100 Temp Road");
//        address.setOpen(true);
//        address.setCreatedDate(new Date());
//        address.setX(123.1);
        
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        
        Address address = session.get(Address.class, 1);
        System.out.println(address);
        
        Address address1 = session.load(Address.class, 2);
        System.out.println(address1);
        
        //session.save(emp);
//        session.save(address);
        transaction.commit();
        session.close();
        
    }
}
