package com.example.base.Users;


import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    public static  List<User> Users = new ArrayList<>();
    public static int userCount=0;
    static{
        Users.add(new User(++userCount,"Anuma", LocalDate.now().minusYears(30)));
        Users.add(new User(++userCount,"Abhi", LocalDate.now().minusYears(30)));
        Users.add(new User(++userCount,"Ajith", LocalDate.now().minusYears(30)));
        Users.add(new User(++userCount,"ramesh", LocalDate.now().minusYears(30)));
    };

    // All Users

    public List<User> findAll(){
        return Users;
    }

    public User saveUser(User user){
        user.setId(++userCount);
        Users.add(user);
        return user;
    }

    public User findOne(int id){
        Predicate<? super User> predicate= user-> user.getId().equals(id);
        return Users.stream().filter(predicate).findFirst().orElse(null);
    }
    public void deleteById(int id){
        Predicate<? super User> predicate= user-> user.getId().equals(id);
        Users.removeIf(predicate);
    }

}
