package com.infy;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.infy.entity.Student;

public class CreateReadStudent {
	public static void main(String[] args) {
		
		Student s1=new Student("Mitesh", "Karmur", "mk@gmail.com");
		Student s2=new Student("Subhash", "Karmur", "sk@gmail.com");
		Student s3=new Student("Payal", "Karmur", "pk@gmail.com");
		
		SessionFactory sessionFactory=new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		
		try {
			
			session.getTransaction().begin();
			Integer id1=(Integer) session.save(s1);
			Integer id2=(Integer) session.save(s2);
			Integer id3=(Integer) session.save(s3);
			session.getTransaction().commit();
			
			System.out.println("Printing Ids of students created");
			System.out.println(id1);
			System.out.println(id2);
			System.out.println(id3);
			
			session=sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Student stud1=session.get(Student.class, id1);
			Student stud2=session.get(Student.class, id2);
			Student stud3=session.get(Student.class, id3);
			
			System.out.println("Getting student objects:");
			System.out.println(stud1);
			System.out.println(stud2);
			System.out.println(stud3);

			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
		
		
	}

}
