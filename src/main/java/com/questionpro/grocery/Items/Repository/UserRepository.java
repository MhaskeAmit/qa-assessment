package com.questionpro.grocery.Items.Repository;

import com.questionpro.grocery.Items.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
