package com.learnersacademy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learnersacademy.entity.Teacher;
import com.learnersacademy.util.HibernateUtil;

public class TeacherDao {

	public Teacher getTeacher(int id) {
		Transaction transaction = null;
		Teacher teacher = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			teacher = session.get(Teacher.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return teacher;
	}

	public Teacher saveTeacher(Teacher teacher) {
		Transaction transaction = null;
		Teacher createdTeacher = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(teacher);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return createdTeacher;
	}

	@SuppressWarnings("unchecked")
	public List<Teacher> getAllTeachers() {
		Transaction transaction = null;
		List<Teacher> listOfTeachers = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			listOfTeachers = session.createQuery("from Teacher").getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfTeachers;
	}
	
	public void deleteTeacher(int id) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Teacher teacherObj = session.get(Teacher.class, id);
			session.delete(teacherObj);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
}
