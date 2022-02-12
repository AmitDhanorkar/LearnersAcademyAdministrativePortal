package com.learnersacademy.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.learnersacademy.entity.Student;
import com.learnersacademy.entity.TeacherClassSubjectMapping;
import com.learnersacademy.util.HibernateUtil;

public class ClassReportDetailsDao {

	public List<TeacherClassSubjectMapping> getTeacherClassSubjectMappingsDetails(int classId) {

		Transaction transaction = null;
		List<TeacherClassSubjectMapping> getTeachersHandlingSubjectsList = new ArrayList<TeacherClassSubjectMapping>();

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Criteria teachersHandlingSubjectsCriteria  = session.createCriteria(TeacherClassSubjectMapping.class);
			teachersHandlingSubjectsCriteria.add(Restrictions.eq("classId", classId));
			teachersHandlingSubjectsCriteria.setProjection(Projections.distinct(Projections.projectionList()
					 .add(Projections.property("teacherId"))         
					 .add(Projections.property("teacherName"))       
					 .add(Projections.property("subjectId"))         
					 .add(Projections.property("subjectName"))       
			));
			List results = teachersHandlingSubjectsCriteria.list();
			if(results != null && results.size() > 0) {
				Iterator<Object> it = results.iterator();
				while(it.hasNext()) {
					Object[] row = (Object[]) it.next();
					TeacherClassSubjectMapping teachersClassesSubjectsMappingObj = new TeacherClassSubjectMapping();
					teachersClassesSubjectsMappingObj.setTeacherId((Integer) row[0]);
					teachersClassesSubjectsMappingObj.setTeacherName((String) row[1]);
					teachersClassesSubjectsMappingObj.setSubjectId((Integer) row[2]);
					teachersClassesSubjectsMappingObj.setSubjectName((String) row[3]);
					getTeachersHandlingSubjectsList.add(teachersClassesSubjectsMappingObj);
				}
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return getTeachersHandlingSubjectsList;
	
	}
	
	public List<Student> getStudentDetails(int classId) {

		Transaction transaction = null;
		List<Student> getStudentInTheClassList = new ArrayList<Student>();

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Criteria studentsCriteria  = session.createCriteria(Student.class);
			studentsCriteria.add(Restrictions.eq("classId", classId));
			studentsCriteria.setProjection(Projections.distinct(Projections.projectionList()
					 .add(Projections.property("id"))
					 .add(Projections.property("name"))
					 .add(Projections.property("emergencyContactNumber"))
					 .add(Projections.property("bloodGroup"))
					 .add(Projections.property("gender"))        
			));
			List results = studentsCriteria.list();
			if(results != null && results.size() > 0) {
				Iterator<Object> it = results.iterator();
				while(it.hasNext()) {
					Object[] row = (Object[]) it.next();
					Student student = new Student();
					student.setId((Integer) row[0]);
					student.setName((String) row[1]);
					student.setEmergencyContactNumber((String) row[2]);
					student.setBloodGroup((String) row[3]);
					student.setGender((String) row[4]);
					getStudentInTheClassList.add(student);
				}
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return getStudentInTheClassList;
	
	}

}
