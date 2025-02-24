package ru.netology.SpringBootAuthorizationService.repository;

import ru.netology.SpringBootAuthorizationService.exception.InvalidCredentials;
import ru.netology.SpringBootAuthorizationService.model.Authorities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserRepository {

    protected CopyOnWriteArrayList<Authorities> allAuthorities = new CopyOnWriteArrayList<>();
    protected Map<String, String > allUsers = new HashMap<>();

    public List<Authorities> getUserAuthorities(String user, String password) {
        allUsers.put("nebreoma", "Net");
        allUsers.put("Alan", "Dark");

        if(allUsers.containsKey(user) && allUsers.get(user).equals(password)){
            if("nebreoma".equals(user)) {
                allAuthorities.add(Authorities.READ);
                allAuthorities.add(Authorities.WRITE);
                allAuthorities.add(Authorities.DELETE);
            } else if("Alan".equals(user)) {
                allAuthorities.add(Authorities.READ);
            } else
                throw new InvalidCredentials("Username or password invalid");
        }
        return allAuthorities;
    }
}