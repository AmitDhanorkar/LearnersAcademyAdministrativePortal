package com.learnersacademy.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "class_subject_mapping")
public class ClassSubjectMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int classId;
	private String className;
	private int subjectId;
	private String subjectName;
	@CreationTimestamp
	private Date createdDt;
	
	public int getId() {
		return id;
	}
	
	public int getClassId() {
		return classId;
	}
	
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public int getSubjectId() {
		return subjectId;
	}
	
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	public Date getCreatedDt() {
		return createdDt;
	}
	
	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}
	
	public ClassSubjectMapping() {
		super();
	}
	
	public ClassSubjectMapping(int classId, String className, int subjectId, String subjectName) {
		super();
		this.classId = classId;
		this.className = className;
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}
	
}
