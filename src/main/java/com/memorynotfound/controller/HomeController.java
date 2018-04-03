package com.memorynotfound.controller;

import com.memorynotfound.model.Course;
import com.memorynotfound.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    List<Course> documents = Arrays.asList(
            new Course(1, "Spring MVC PDF IText Example", new Date()),
            new Course(3, "Spring MVC PDF Lowagie Example", new Date())
    );

    List<Person> personList = Arrays.asList(
            new Person(1L,"Person1")
            ,new Person(2L,"Person2")
    );

    @RequestMapping(value = "/courses",method = RequestMethod.GET)
    public String getDocuments(Model model) {
        model.addAttribute("courses", documents);
        return "index";

    }

    @RequestMapping(value = "/people",method = RequestMethod.GET)
    private String getDocumentOfPerson(Model model){
        model.addAttribute("people",personList);
        return "person";
    }
}
