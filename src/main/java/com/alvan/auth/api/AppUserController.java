package com.alvan.auth.api;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alvan.auth.entity.AppUser;
import com.alvan.auth.entity.Role;
import com.alvan.auth.service.AppUserService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserService appUserService;

    /**
     * 
     * @param: none
     * @return users
     */
    @GetMapping("/users")
    public ResponseEntity<List<AppUser>>getUsers(){
        return ResponseEntity.ok().body(appUserService.getUsers());
    }

    /**
     * 
     * @param: AppUser appUser
     * @return AppUser
     */
    @PostMapping("/user/save")
    public ResponseEntity<AppUser>saveUser(AppUser appUser){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveUser(appUser));
    }

    /**
     * 
     * @param: Role role
     * @return Role
     */
    @PostMapping("/role/save")
    public ResponseEntity<Role>saveRole(Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveRole(role));
    }

    @PostMapping("/user/add-role-user")
    public ResponseEntity<?>addRoleToUSer(AddRoleToUserForm form){
        appUserService.addRoleToAppUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

}

@Data 
class AddRoleToUserForm {
    private String username;
    private String roleName;
}