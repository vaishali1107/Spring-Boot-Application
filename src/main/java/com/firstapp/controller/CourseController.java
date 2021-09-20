package com.firstapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.firstapp.model.Course;
import com.firstapp.service.CourseService;

@Controller
//to have name attribute valid for multiple requests.
@SessionAttributes("name")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	//Binding data entered in textbox (String) to type required by Bean
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
		
	}

	@RequestMapping(value = "/list-courses", method = RequestMethod.GET)
	// model map stores the view of application . It acts as a container that
	// contains data of application
	public String listCourses(ModelMap model) {
		String name = (String) model.get("name");
		model.put("courses", courseService.retriveCourses(name));
		return "course";
	}

	@RequestMapping(value = "/add-course", method = RequestMethod.GET)
	public String showAddCoursePage(ModelMap model) {

		// bean to form binding
		// used by modelAttribute "course"
		model.addAttribute("course", new Course(0, (String) model.get("name"), "Enter description", new Date(), false));
		return "add-course";
	}

	@RequestMapping(value = "/add-course", method = RequestMethod.POST)
	public String addCourse(ModelMap model, @Valid Course course, BindingResult result) {
		
		courseService.addCourse((String) model.get("name"), course.getDesc(), new Date(), false);
		if (result.hasErrors()) {
			return "add-course";
		}
		// redirecting again to listing courses after adding a new one
		return "redirect:/list-courses";
	}

	@RequestMapping(value = "/update-course", method = RequestMethod.GET)
	public String showUpdateCoursePage(ModelMap model,@RequestParam int id) {

		Course course=courseService.getCourseByID(id);
		model.addAttribute("course",course);
		return "add-course";
	}

	@RequestMapping(value = "/update-course", method = RequestMethod.POST)
	public String updateCourse(ModelMap model, @Valid Course course, BindingResult result) {
		
		if (result.hasErrors()) {
			return "add-course";
		}
		
		course.setUser((String) model.get("name"));
		
		courseService.updateCourse(course);
		
		// redirecting again to listing courses after updating
		return "redirect:/list-courses";
	}

	@RequestMapping(value = "/delete-course", method = RequestMethod.GET)
	public String deleteCourse(@RequestParam int id) {
		
		courseService.deleteCourse(id);

		return "redirect:/list-courses";
	}
}
