package com.learn.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Student;


public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			
			int id1 = 3;

			session.beginTransaction();
			
			session.createQuery("delete from Student where id=" + id1).executeUpdate();
			
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
