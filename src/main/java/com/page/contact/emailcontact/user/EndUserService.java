package com.page.contact.emailcontact.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void addNewUser(EndUser endUser) {
        //Mover esse método de encontrar o email do user para outra classe?
        Optional<EndUser> endUserEmail = endUserRepository.findUserByEmail(endUser.getEmail());

        if(endUserEmail.isPresent()) {
            //escrever 'Exception' customizada no futuro
            throw new IllegalStateException("EMAIL TAKEN.");
        }

        endUserRepository.save(endUser);
    }

    public void deleteUser(Long endUserId) {
        //Transferir esse método de checagem para outra classe?
        boolean endUserExists = endUserRepository.existsById(endUserId);

        if(!endUserExists) {
            throw new IllegalStateException("USER WITH ID " + endUserId + " DOES NOT EXIST.");
        }

        endUserRepository.deleteById(endUserId);
    }
}
