package com.questionpro.grocery.Items.Service;

import com.questionpro.grocery.Items.Entity.Grocery;
import com.questionpro.grocery.Items.Entity.User;
import com.questionpro.grocery.Items.Repository.AdminRepository;
import com.questionpro.grocery.Items.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private AdminRepository adminRepository;

    public User saveUser(User user){

        for(Grocery g : user.getGroceries()){
            Grocery grocery = new Grocery();
            grocery.setUser(user);
            grocery.setName(g.getName());
            grocery.setPrice(g.getPrice());
            System.out.println("User ::"+grocery.getUser());
        }
        return userRepository.save(user);
    }
}
