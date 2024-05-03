package com.page.contact.emailcontact.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
