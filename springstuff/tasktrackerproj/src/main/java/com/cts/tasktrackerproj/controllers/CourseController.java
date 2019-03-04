package com.cts.tasktrackerproj.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.tasktrackerproj.entities.Course;

@RestController
@RequestMapping(path="/api")
public class CourseController {
	
	@RequestMapping(method=RequestMethod.GET, path="/courses")
	public Course findCourse(){
		return new Course(23, "Angular", "UI framework by google");
	}

}
