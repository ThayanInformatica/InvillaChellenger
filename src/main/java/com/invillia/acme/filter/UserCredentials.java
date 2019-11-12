package com.invillia.acme.filter;

import lombok.*;

@Data
@Getter
@Setter
public class UserCredentials {
    public String getUsername() {
        return email;
    }

    public void setUsername(String username) {
        this.email = email;
    }

    public String getPassword() {
        return senha;
    }

    public void setPassword(String password) {
        this.senha = senha;
    }

    private String email;
    private String senha;
}
