package com.alvan.auth.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alvan.auth.entity.AppUser;
import com.alvan.auth.entity.Role;
import com.alvan.auth.repository.AppUserRepository;
import com.alvan.auth.repository.RoleRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Transactional
@Slf4j

public class AppUserServiceImp implements AppUserService, UserDetailsService {
    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username);

        if (appUser == null){
            log.info("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }else {
            log.info("User  found in the database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        appUser.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(appUser.getUsername(), appUser.getPassword(), authorities);
    }


    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving User to the database {}", user.getName());
        return appUserRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving role to the database {}", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToAppUser(String username, String name) {
        log.info("Updating user {} with role {}", username, name);
        AppUser appUser = appUserRepository.findByUsername(username);
        Role role = roleRepository.findByName(name);
        appUser.getRoles().add(role);
        
    }

    @Override
    public AppUser getUser(String username) {
        log.info("Fetching User {}",username);
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Fetching all Users");
        List<AppUser> appUsers = appUserRepository.findAll();
        return appUsers;
    }

   
    
}
