package com.questionpro.grocery.Items.Controller;

import com.questionpro.grocery.Items.Entity.Grocery;
import com.questionpro.grocery.Items.Entity.User;
import com.questionpro.grocery.Items.Repository.AdminRepository;
import com.questionpro.grocery.Items.Service.AdminService;
import com.questionpro.grocery.Items.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GroceryItemController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/admin/save")
    public ResponseEntity<Grocery> addGroceries(@RequestBody Grocery groceryPojo){
        System.out.println("Groceries ::"+groceryPojo);
        Grocery saveGrocery = adminService.saveGrocery(groceryPojo);
        return new ResponseEntity<>(saveGrocery,HttpStatus.CREATED);
    }

    @GetMapping("/admin/getAll")
    public List<Grocery> getAll(){
        return adminRepository.findAll();
    }

    //Update Grocery item
    @PutMapping("/admin/update")
    public ResponseEntity<Grocery> update(@RequestParam(value = "id") int id,@RequestBody Grocery update){
        Grocery modify = adminRepository.findById(id).get();
        modify.setName(update.getName());
        modify.setPrice(update.getPrice());
        return new ResponseEntity<>(modify,HttpStatus.OK);
    }

    //Delete Grocery item by id
    @Transactional
    @DeleteMapping("/admin/delete")
    public ResponseEntity<String> remove(@RequestParam int id){
        Grocery removedItem = adminRepository.findById(id).get();
        adminService.delete(removedItem);
        return new ResponseEntity<>("Deleted "+id,HttpStatus.OK);
    }

    //Delete multiple entries
    @Transactional
    @DeleteMapping("/admin/multiDelete")
    public void multiRemove(@RequestParam("id") List<Integer> id){
        System.out.println("Deleting groceries :"+id.stream().collect(Collectors.toList()));
        adminRepository.deleteAllById(id);
    }
    //Display all groceries to user
    @GetMapping("/user/get")
    private List<Grocery> showGroceries(){
        System.out.println("Showing list of grocery items....");
        return adminRepository.findAll();
    }

    //Add User and his/her orders in database
    @PostMapping("/user/save")
    private ResponseEntity<User> multipleOrder(@RequestBody User order){
        //Saving user and multiple order
        System.out.println("Saving...."+order);
        User res = userService.saveUser(order);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}
