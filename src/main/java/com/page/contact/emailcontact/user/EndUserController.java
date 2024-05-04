package com.page.contact.emailcontact.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
