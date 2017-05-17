package com.learn.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Student;


public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			

			session.beginTransaction();
			
			List<Student> list = session.createQuery("from Student").getResultList();
			
			displayStudent(list);
			
			list = session.createQuery("from Student s where s.lastName = 'Clamp'").getResultList();
			System.out.println("\n");
			displayStudent(list);
			
			list = session.createQuery("from Student s where s.lastName = 'Clamp' OR s.firstName = 'Ganesh'").getResultList();
			System.out.println("\n");
			displayStudent(list);
			
			list = session.createQuery("from Student s where s.email LIKE '__1%'").getResultList();
			System.out.println("\n");
			displayStudent(list);
			
			
			session.getTransaction().commit();


		} finally {
			factory.close();
		}

	}

	private static void displayStudent(List<Student> list) {
		for(Student stud : list){
			System.out.println(stud);
		}
	}

}
