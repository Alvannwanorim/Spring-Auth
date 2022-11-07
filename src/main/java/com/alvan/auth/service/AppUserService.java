package com.alvan.auth.service;

import java.util.List;

import com.alvan.auth.entity.AppUser;
import com.alvan.auth.entity.Role;

public interface AppUserService {
    public AppUser saveUser(AppUser user);
    public Role saveRole(Role role);
    public void addRoleToAppUser(String username, String name);
    public AppUser getUser(String username);
    List<AppUser>getUsers();
}
