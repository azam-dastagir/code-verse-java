package com.codeverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeverse.entity.Course;

public interface CourseRepository extends JpaRepository<Course , Integer>{
	
}
