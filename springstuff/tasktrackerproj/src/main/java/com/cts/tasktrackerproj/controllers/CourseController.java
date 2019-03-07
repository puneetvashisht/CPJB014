package com.cts.tasktrackerproj.controllers;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.tasktrackerproj.entities.Course;
import com.cts.tasktrackerproj.repos.CourseRepo;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/api")
public class CourseController {
	
	@Autowired
	CourseRepo courseRepo;
	
	@RequestMapping(method=RequestMethod.GET, path="/courses/{id}")
	public ResponseEntity<Course> findCourse(@PathVariable("id") int id){
		Course course = null;
		try{
			course = courseRepo.getOne(id);
			System.out.println("Printing course....  **** " + course);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("Course is Null ***");
//			response = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			throw new CourseNotFoundException("Course not found with id " + id);
		}
		
		
		ResponseEntity<Course> response = null; 
		response = new ResponseEntity<>(course, HttpStatus.OK);
		return response;
//		return new Course(23, "Angular", "UI framework by google");
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/courses")
	public List<Course> findAllCourse(){
		 return courseRepo.findAll();
//		return course;
//		return new Course(23, "Angular", "UI framework by google");
	}
	
	@RequestMapping(method=RequestMethod.POST, path="/courses")
	public ResponseEntity<Void> add(@RequestBody Course course){
		System.out.println(course);
//		Course course = new Course(23, "Angular", "UI framework by google");
		
//		try{
			Course courseFind = courseRepo.findByTitle(course.getTitle());
			System.out.println(courseFind);
			if(courseFind == null){
				courseRepo.save(course);
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			}
			else{
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}
			
			
//		}
//		catch(NoResultException nre){
//			nre.printStackTrace();
//			
//		}	
		
		
		
		
		
		
		
		
//		ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.CREATED);
//		return response;
//		return course;
//		return 
	}

}
