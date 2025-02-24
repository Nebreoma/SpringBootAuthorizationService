package ru.netology.SpringBootAuthorizationService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.netology.SpringBootAuthorizationService.controller.AuthorizationController;
import ru.netology.SpringBootAuthorizationService.repository.UserRepository;
import ru.netology.SpringBootAuthorizationService.service.AuthorizationService;

@Configuration
public class JavaConfig{

    @Bean
    public AuthorizationController authorizationController() {
        return new AuthorizationController (authorizationService());
    }

    @Bean
    public AuthorizationService authorizationService() {
        return new AuthorizationService (userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }
}