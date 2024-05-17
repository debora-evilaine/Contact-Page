package com.page.contact.emailcontact.user.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form() {
        logger.info("Handling /layout request.");
        return "layout";
        }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String userSubmit(Model model, String email, String name) {
        System.out.println(email);
        System.out.println(name);
        model.addAttribute("e", email);
        model.addAttribute("nam", name);
        logger.info("Handling /submit request.");
        return "submit";
    }

    }
