package com.universitysys.SSE.controller;

import com.universitysys.SSE.model.Account;
import com.universitysys.SSE.model.Module;
import com.universitysys.SSE.repository.ModuleRepository;
import com.universitysys.SSE.repository.StatisticRepository;
import com.universitysys.SSE.service.ModuleService;
import com.universitysys.SSE.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.universitysys.SSE.exception.ModuleNotFound;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class ModuleController {
    @Autowired
    public ModuleService moduleService;


    @RequestMapping(value = "/module" , method = RequestMethod.GET)
    @ResponseBody
    protected List<Module> getById(Model model){
        List<Module> moduleList = moduleService.showInfo();
        model.addAttribute("moduleList", moduleList);
        //students.forEach((students1-> System.out.println(students.toString())));
        return moduleList;
    }


}
