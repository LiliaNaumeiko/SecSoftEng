package com.universitysys.SSE.controller;

import com.universitysys.SSE.model.Account;
import com.universitysys.SSE.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.universitysys.SSE.service.LoginService;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "index";
    }

    @RequestMapping(value = "/register/login", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
                                @ModelAttribute("account")Account account, @RequestParam String name, @RequestParam String password) {
        boolean isValidStudent = service.validateStudent(name, password);
        if (!isValidStudent) {
            service.registerAccount(account);
            return new ModelAndView("login");
        }

        else {
            return new ModelAndView("error", "firstname",account.getUsername());

        }
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){

        boolean isValidStudent = service.validateStudent(name, password);

        if (!isValidStudent) {
            model.addAttribute("errorMessage", "Error: Invalid Credentials");
            return "index";
        }

        else {
            model.put("name", name);
            model.put("password", password);
            return "welcome";
        }
    }
}
