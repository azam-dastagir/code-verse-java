package com.codeverse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Lesson {
	int courseId;
	@Id
	int lessonId;
	String lessonName;
	String lessonTopics;
	String videoLink;
	@ManyToOne
	Course course;
	
	public Lesson() {
		super();
	}

	public Lesson(int courseId, int lessonId, String lessonName, String lessonTopics, String videoLink, Course course) {
		super();
		this.courseId = courseId;
		this.lessonId = lessonId;
		this.lessonName = lessonName;
		this.lessonTopics = lessonTopics;
		this.videoLink = videoLink;
		this.course = course;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getLessonId() {
		return lessonId;
	}

	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getLessonTopics() {
		return lessonTopics;
	}

	public void setLessonTopics(String lessonTopics) {
		this.lessonTopics = lessonTopics;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Lesson [courseId=" + courseId + ", lessonId=" + lessonId + ", lessonName=" + lessonName
				+ ", lessonTopics=" + lessonTopics + ", videoLink=" + videoLink + ", course=" + course + "]";
	}
	
}