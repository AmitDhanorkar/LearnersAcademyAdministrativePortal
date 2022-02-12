package com.learnersacademy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learnersacademy.entity.ClassSubjectMapping;
import com.learnersacademy.util.HibernateUtil;

public class ClassSubjectMappingDao {

	public ClassSubjectMapping saveClassSubjectMapping(ClassSubjectMapping classSubjectMapping) {
		Transaction transaction = null;
		ClassSubjectMapping createdClassSubjectMapping = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(classSubjectMapping);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return createdClassSubjectMapping;
	}

	@SuppressWarnings("unchecked")
	public List<ClassSubjectMapping> getAllClassSubjectMapping() {
		Transaction transaction = null;
		List<ClassSubjectMapping> listOfClassSubjectMappings = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			listOfClassSubjectMappings = session.createQuery("from ClassSubjectMapping").getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfClassSubjectMappings;
	}
	

	public void deleteClassSubjectMapping(int id) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			ClassSubjectMapping mappingObj = session.get(ClassSubjectMapping.class, id);
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
