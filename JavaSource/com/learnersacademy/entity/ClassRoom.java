package com.learnersacademy.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "class")
public class ClassRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String className;
	private String sectionName;
	private int totalNumberOfStudents;
	private String roomNo;
	private String classTeacherName;
	@CreationTimestamp
	private Date createdDt;
	
	public int getId() {
		return id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	
	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public int getTotalNumberOfStudents() {
		return totalNumberOfStudents;
	}

	public void setTotalNumberOfStudents(int totalNumberOfStudents) {
		this.totalNumberOfStudents = totalNumberOfStudents;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getClassTeacherName() {
		return classTeacherName;
	}

	public void setClassTeacherName(String classTeacherName) {
		this.classTeacherName = classTeacherName;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public ClassRoom() {
		super();
	}

	public ClassRoom(String className, String sectionName, int totalNumberOfStudents, String roomNo,
			String classTeacherName) {
		super();
		this.className = className;
		this.sectionName = sectionName;
		this.totalNumberOfStudents = totalNumberOfStudents;
		this.roomNo = roomNo;
		this.classTeacherName = classTeacherName;
	}

}
