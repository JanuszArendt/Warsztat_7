package pl.coderslab.demo.domain.dto;

import javax.validation.constraints.NotNull;

public class LoginDto {
    @NotNull
    private String login;

    @NotNull
    private String password;
}
