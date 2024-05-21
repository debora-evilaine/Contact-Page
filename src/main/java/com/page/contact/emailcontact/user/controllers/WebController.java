package com.page.contact.emailcontact.user.controllers;

import com.page.contact.emailcontact.EmailService;
import com.page.contact.emailcontact.user.EndUser;
import com.page.contact.emailcontact.user.EndUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class WebController {
    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    private final EndUserService endUserService;

    private final EmailService emailService;

    @Autowired
    public WebController(EndUserService userService, EmailService emailService) {
        this.endUserService = userService;
        this.emailService = emailService;
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form() {
        logger.info("Handling /layout request.");
        return "layout";
        }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String userSubmit(Model model, String email, String name, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dob) {
        System.out.println(email);
        System.out.println(name);
        System.out.println(dob);
        model.addAttribute("email", email);
        model.addAttribute("name", name);
        model.addAttribute("birthday", dob);
        logger.info("Handling /submit request.");
        return "submit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("enduser") EndUser endUserObj) {
        String email = endUserObj.getEmail();
        String body = "Hello, " + endUserObj.getName();
        String subject = "[TESTE]";

        emailService.sendEmail(email, subject, body);
        endUserService.addNewUser(endUserObj);
        return "redirect:/userapi/user/enduser";
    }

    @GetMapping("/userapi/user/enduser")
    public String getUser(Model model) {
        List<EndUser> users = endUserService.getUser();
        model.addAttribute("users", users);
        return "user-list";
    }




    }
