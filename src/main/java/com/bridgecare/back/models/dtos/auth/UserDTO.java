package com.bridgecare.back.models.dtos.auth;

import com.bridgecare.back.models.entities.Users;

public class UserDTO {
    private Long id;
    private String username;
    private String password;

    public UserDTO() {
        super();
        this.id = null;
        this.username = null;
        this.password = null;
    }

    public UserDTO(Long id, String username, String email, String password) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UserDTO(Users user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
