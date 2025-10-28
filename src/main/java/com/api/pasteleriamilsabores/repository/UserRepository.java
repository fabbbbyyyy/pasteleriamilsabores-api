package com.api.pasteleriamilsabores.repository;
import com.api.pasteleriamilsabores.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface UserRepository extends JpaRepository<User, Long>{

}
