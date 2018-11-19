package pl.coderslab.demo.domain.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RegisterDto { //obiekt DTO czyli Data Transfer Object, wykorzystywany do mapowania formularzy html na obiekt javy
                           //  some DTO from browser
                           //
                           //            v
                           //
                           //Spring @Controller method
                           //
                           //            v
                           //
                           //  Spring @Service method
                           // mozliwa walidacja w DTO

    @NotNull
    private String name;
    @NotNull
    private String username;

    private String password;

    private String confirm_password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

}
