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
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister() {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("students", new Students());
        return mav;
    }
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView showWelcome() {
        return new ModelAndView("welcome");
    }
    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public ModelAndView addPayment(HttpServletRequest request, HttpServletResponse response,
                                   @ModelAttribute("account")Account account) {

        service.payAccount(account);
        return new ModelAndView("mymodules");

    }
    @RequestMapping(value="/payment", method = RequestMethod.GET)
    public String showPayment( ){
        return "payments";
    }
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage( ){
        return "index";
    }

    @RequestMapping(value = "/logout")
    public String showLogoutPage( ){
        return "logout";
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
