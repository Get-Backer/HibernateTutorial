package com.learn.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			
			Student stud = new Student("Kirsty", "Haddon", "kh27@njit.edu");
			
			session.beginTransaction();
			
			session.save(stud);
			System.out.println("Save Complete");
			System.out.println("details: " + stud.toString());
			
			session.getTransaction().commit();
			
			System.out.println("Saved ID: " + stud.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Getting student with ID: " + stud.getId());
			Student mystud = session.get(Student.class, stud.getId());
			
			System.out.println("Get Complete: " + mystud.toString());
			
			session.getTransaction().commit();
			
		}finally{
			factory.close(); 
		}

	}

}
