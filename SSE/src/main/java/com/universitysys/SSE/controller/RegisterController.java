package com.universitysys.SSE.controller;

import com.universitysys.SSE.model.Account;
import com.universitysys.SSE.model.Students;
import com.universitysys.SSE.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("name")
public class RegisterController {
    @Autowired
    public LoginService service;

    @RequestMapping(value = "/register", method = RequestMethod.GET )
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("students", new Students());
        return mav;
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
        @ModelAttribute("account") Account account) {
        boolean isValidStudent = service.validateStudent(account.getUsername(), account.getPassword());
        if (!isValidStudent) {
            service.register(account);
            return new ModelAndView("welcome", "firstname", account.getUsername());
        }

        else {
            return new ModelAndView("error", "firstname", account.getUsername());

        }
    }
}

