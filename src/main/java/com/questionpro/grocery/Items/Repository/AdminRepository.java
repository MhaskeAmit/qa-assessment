package com.questionpro.grocery.Items.Repository;

import com.questionpro.grocery.Items.Entity.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Grocery,Integer>{
}
