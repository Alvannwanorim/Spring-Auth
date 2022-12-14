package com.alvan.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvan.auth.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long>{

    public AppUser findByUsername (String username);
    
}
