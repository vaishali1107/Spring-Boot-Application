package com.firstapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.firstapp.model.Course;

@Service
public class CourseService {
	private static List<Course> courses = new ArrayList<Course>();
	private static int courseCount = 3;

	static {
		courses.add(new Course(1, "vaishali", "Learn Spring MVC", new Date(), false));
		courses.add(new Course(2, "vaishali", "Learn Struts", new Date(), false));
		courses.add(new Course(3, "vaishali", "Learn Hibernate", new Date(), false));
	}

	public List<Course> retriveCourses(String user) {
		List<Course> filteredTodos = new ArrayList<Course>();
		for (Course course : courses) {
			if (course.getUser().equals(user)) {
				filteredTodos.add(course);
			}
		}
		return filteredTodos;
	}

	public void addCourse(String name, String desc, Date targetDate, boolean isDone) {
		courses.add(new Course(++courseCount, name, desc, targetDate, isDone));
	}

	public void deleteCourse(int id) {
		Iterator<Course> iterator = courses.iterator();
		while (iterator.hasNext()) {
			Course course = iterator.next();
			if (course.getId() == id) {
				iterator.remove();
			}
		}
	}

	public void updateCourse(Course course) {
		courses.remove(course);
		courses.add(course);
	}

	public Course getCourseByID(int id) {
		for (Course c : courses) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}
}
