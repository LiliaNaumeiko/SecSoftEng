package com.universitysys.SSE.controller;

import com.universitysys.SSE.model.*;
import com.universitysys.SSE.repository.ModuleRepository;
import com.universitysys.SSE.repository.StatisticRepository;
import com.universitysys.SSE.service.ModuleService;
import com.universitysys.SSE.service.ProfessorService;
import com.universitysys.SSE.service.StatisticService;
import com.universitysys.SSE.service.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.universitysys.SSE.exception.ModuleNotFound;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
public class ModuleController {
    @Autowired
    public ModuleService moduleService;
    @Autowired
    public ProfessorService professorService;
    @Autowired
    public TopicsService topicsService;


    @RequestMapping(value = "/module" )
        public ModelAndView  getById(ModelAndView model) throws IOException {
        List<Module> moduleList = moduleService.showInfo();
        model.addObject("moduleList", moduleList);
        model.setViewName("mymodules");
        //students.forEach((students1-> System.out.println(students.toString())));
        return model;
    }
    @RequestMapping(value = "/professor" , method = RequestMethod.GET)
    public Object showProfessor(Model model){
        List<Professor> professorList = professorService.showAll();
        model.addAttribute("professorList", professorList);

        //students.forEach((students1-> System.out.println(students.toString())));
        return professorList;
    }
    @RequestMapping(value = "/grades" , method = RequestMethod.GET)
    public Object showGrades(Model model){
        List<Student_has_module> gradesList = professorService.showGrades(1,2);
        model.addAttribute("gradesList", gradesList);

        //students.forEach((students1-> System.out.println(students.toString())));
        return gradesList.toArray();
    }
    @RequestMapping(value = "/topics" , method = RequestMethod.GET)
    public Object showTopics(Model model){
        List<Topics> topicsList = topicsService.showAll();
        model.addAttribute("topicsList", topicsList);

        //students.forEach((students1-> System.out.println(students.toString())));
        return topicsList;
    }
    //@RequestMapping(value = "/grades/edit", method = RequestMethod.POST)
    //public ModelAndView addGrade(HttpServletRequest request, HttpServletResponse response,
      //                          @ModelAttribute("grades")Student_has_module student_has_module, @RequestParam int grade) {

      // professorService.inputGrades(student_has_module, grade);
        //    return new ModelAndView("login");
    //}

}
