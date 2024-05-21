package com.page.contact.emailcontact.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    @Transactional
    public void updateUser(Long endUserId, String name, String email) {
        //Criar um método para cada em outra (s) classe (s) e só chamar

        EndUser user = endUserRepository.findById(endUserId).orElseThrow(
                () -> new IllegalStateException("USER WITH ID " + endUserId + " DOES NOT EXIST."));

        if(name != null && !name.isEmpty() && !Objects.equals(user.getName(),name)) {
            user.setName(name);
        }

        if(email != null && !email.isEmpty() && !Objects.equals(user.getEmail(), email)) {
            user.setEmail(email);
        }
    }
}
