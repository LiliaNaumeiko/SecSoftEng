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


    @RequestMapping(value = "mymodules" , method = RequestMethod.GET)
    public ModelAndView modules() {
        ModelAndView mod = new ModelAndView("mymodules");
        mod.addObject("modules",  moduleService.showInfo());
        return mod;
    }
    @RequestMapping(value = "allmodules" , method = RequestMethod.GET)
    public ModelAndView allmodules() {
        ModelAndView mod = new ModelAndView("allmodules");
        mod.addObject("modules",  moduleService.showInfo());
        return mod;
    }
    @ModelAttribute("modules")
    public List<Module> module() {
        return moduleService.showInfo();
    }

    @ModelAttribute("allmodules")
    public List<Module> allmodule() {
        return moduleService.showInfo();
    }


}
