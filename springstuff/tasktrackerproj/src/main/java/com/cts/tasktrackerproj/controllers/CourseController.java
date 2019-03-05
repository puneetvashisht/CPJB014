package com.cts.tasktrackerproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.tasktrackerproj.entities.Course;
import com.cts.tasktrackerproj.repos.CourseRepo;

@RestController
@RequestMapping(path="/api")
public class CourseController {
	
	@Autowired
	CourseRepo courseRepo;
	
	@RequestMapping(method=RequestMethod.GET, path="/courses")
	public Course findCourse(){
		Course course = courseRepo.getOne(4);
		return course;
//		return new Course(23, "Angular", "UI framework by google");
	}
	
	@RequestMapping(method=RequestMethod.POST, path="/courses")
	public void add(){
		Course course = new Course(23, "Angular", "UI framework by google");
		courseRepo.save(course);
//		return course;
//		return 
	}

}
