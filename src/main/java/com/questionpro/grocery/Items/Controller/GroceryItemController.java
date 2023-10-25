package com.questionpro.grocery.Items.Controller;

import com.questionpro.grocery.Items.Entity.Grocery;
import com.questionpro.grocery.Items.Entity.User;
import com.questionpro.grocery.Items.Service.AdminService;
import com.questionpro.grocery.Items.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroceryItemController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @PostMapping("/admin/save")
    public Grocery addGroceries(@RequestBody Grocery groceryPojo){
        System.out.println("Groceries ::"+groceryPojo);
        return adminService.saveGrocery(groceryPojo);
    }




    @PostMapping("/user/save")
    private User multipleOrder(@RequestBody User order){
        //Saving user and multiple order
        System.out.println("Saving...."+order);
        return userService.saveUser(order);

    }
}
