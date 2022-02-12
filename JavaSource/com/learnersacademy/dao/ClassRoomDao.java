package com.learnersacademy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learnersacademy.entity.ClassRoom;
import com.learnersacademy.util.HibernateUtil;

public class ClassRoomDao {

	public ClassRoom getClassRoom(int id) {
		Transaction transaction = null;
		ClassRoom classRoom = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			classRoom = session.get(ClassRoom.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return classRoom;
	}

	public ClassRoom saveClassRoom(ClassRoom classRoom) {
		Transaction transaction = null;
		ClassRoom createdClassRoom = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(classRoom);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return createdClassRoom;
	}

	@SuppressWarnings("unchecked")
	public List<ClassRoom> getAllClassRooms() {
		Transaction transaction = null;
		List<ClassRoom> listOfClassRooms = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			listOfClassRooms = session.createQuery("from ClassRoom").getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfClassRooms;
	}
	
	public void deleteClass(int id) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			ClassRoom classRoomObj = session.get(ClassRoom.class, id);
			session.delete(classRoomObj);
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
