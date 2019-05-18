package com.nezopont.web.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class LogindDTO {
    @Email
    private String email;

    @NotEmpty
    private String password;

    public LogindDTO(@Email String email, @NotEmpty String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean empty(){
        if(email.isEmpty() || password.isEmpty()){
            return true;
        }
        return false;
    }
}
