package com.cts.tasktrackerproj.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.tasktrackerproj.entities.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
	
	public Course findByTitle(String title);

}
