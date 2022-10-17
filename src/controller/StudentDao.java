package controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import model.Student;

public class StudentDao 
{
Session ses;
Transaction tx;

void getConnect()
{
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	
	SessionFactory factory=cfg.buildSessionFactory();
	ses=factory.openSession();
	
	tx=ses.beginTransaction();
}

public boolean insert(Student s)
{
	getConnect();
	ses.save(s);
	tx.commit();
	ses.close();
	return true;
}
	
void update(Student s)
{
	getConnect();
	ses.update(s);
	tx.commit();
	ses.close();
}

void delete(Student s)
{
	getConnect();
	ses.delete(s);
	tx.commit();
	ses.close();
}

List<Student> getAllUser()
{
	getConnect();
	Query query=ses.createQuery("from Student");
	List<Student> list=query.list();
	tx.commit();
	ses.close();
	return list;
}
}
