package com.page.contact.emailcontact.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EndUserService {
    private final EndUserRepository endUserRepository;

    @Autowired
    public EndUserService(EndUserRepository userRepository) {
        this.endUserRepository = userRepository;
    }

    public List<EndUser> getUser() {
        return endUserRepository.findAll();
    }
}
