package dev.danvega.jpasecurity.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


@Controller
public class mainController {


    @RequestMapping(value = "/")
    public ModelAndView mainPage(@RequestParam(name = "M", required = false) String message) {
        System.out.println(message);
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("message", "salam");
        return mv;
    }

    @RequestMapping(value = "/Admin/Home")
    public ModelAndView mainPageAdmin(@RequestParam(name = "M", required = false) String message) {
        System.out.println(message);
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("message", "salam");
        return mv;
    }
}

