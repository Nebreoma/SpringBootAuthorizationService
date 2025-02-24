package ru.netology.SpringBootAuthorizationService.service;

import java.util.List;

import ru.netology.SpringBootAuthorizationService.model.Authorities;
import ru.netology.SpringBootAuthorizationService.exception.InvalidCredentials;
import ru.netology.SpringBootAuthorizationService.exception.UnauthorizedUser;
import ru.netology.SpringBootAuthorizationService.repository.UserRepository;

public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService() {
    }

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}