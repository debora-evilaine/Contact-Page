package com.page.contact.emailcontact.user.controllers;

import com.page.contact.emailcontact.user.EndUser;
import com.page.contact.emailcontact.user.EndUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(path = "userapi/user")
public class EndUserController {
    private final EndUserService endUserService;

    @Autowired
    public EndUserController(EndUserService userService) {
        this.endUserService = userService;
    }

    @GetMapping
    public List<EndUser> getUser() {
        return endUserService.getUser();
    }

    @PostMapping
    public void addNewUser(@RequestBody EndUser endUser) {
        endUserService.addNewUser(endUser);
    }

    @DeleteMapping(path = "{enduserId}")
    public void deleteUser(@PathVariable("enduserId") Long endUserId) {
        endUserService.deleteUser(endUserId);
    }

    @PutMapping(path = "{enduserId}")
    public void updateUser(
            @PathVariable("enduserId") Long endUserId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        endUserService.updateUser(endUserId, name, email);
    }



}
