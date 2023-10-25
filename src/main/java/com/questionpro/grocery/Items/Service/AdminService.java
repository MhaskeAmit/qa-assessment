package com.questionpro.grocery.Items.Service;

import com.questionpro.grocery.Items.Entity.Grocery;
import com.questionpro.grocery.Items.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Grocery saveGrocery(Grocery grocery){
        return adminRepository.save(grocery);
    }
}
