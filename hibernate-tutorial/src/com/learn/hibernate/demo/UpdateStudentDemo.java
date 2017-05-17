package com.learn.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Student;


public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			
			int id = 1;

			session.beginTransaction();
			
			Student stud = session.get(Student.class, id);
			
			session.createQuery("update Student set email = 'test@gmail.com' where lastName = 'Clamp'").executeUpdate();
			List<Student> list = session.createQuery("from Student").getResultList();
			
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
