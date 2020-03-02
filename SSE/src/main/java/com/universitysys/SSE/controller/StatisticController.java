package com.universitysys.SSE.controller;

import com.universitysys.SSE.exception.WrongPasswordOrLogin;
import com.universitysys.SSE.model.Account;
import com.universitysys.SSE.model.Students;
import com.universitysys.SSE.repository.StatisticRepository;
import com.universitysys.SSE.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class StatisticController {
    @Autowired
    public StatisticService statisticService;

    @RequestMapping(value = "/statistic" , method = RequestMethod.GET)
    @ResponseBody
    public List<Account> getById(Model model){
        List<Account> studentsList = statisticService.showInfo();
        model.addAttribute("studentsList", studentsList);
        //students.forEach((students1-> System.out.println(students.toString())));
        return studentsList;
        }



}
