package com.learnersacademy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learnersacademy.entity.TeacherClassSubjectMapping;
import com.learnersacademy.util.HibernateUtil;

public class TeacherClassSubjectMappingDao {

	public TeacherClassSubjectMapping saveTeacherClassSubjectMapping(TeacherClassSubjectMapping teacherClassSubjectMapping) {
		Transaction transaction = null;
		TeacherClassSubjectMapping createdTeacherClassSubjectMapping = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(teacherClassSubjectMapping);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return createdTeacherClassSubjectMapping;
	}

	@SuppressWarnings("unchecked")
	public List<TeacherClassSubjectMapping> getAllTeacherClassSubjectMapping() {
		Transaction transaction = null;
		List<TeacherClassSubjectMapping> listOfTeacherClassSubjectMappings = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an student object
			listOfTeacherClassSubjectMappings = session.createQuery("from TeacherClassSubjectMapping").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfTeacherClassSubjectMappings;
	}
	

	public void deleteTeacherClassSubjectMapping(int id) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			TeacherClassSubjectMapping mappingObj = session.get(TeacherClassSubjectMapping.class, id);
			session.delete(mappingObj);
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
