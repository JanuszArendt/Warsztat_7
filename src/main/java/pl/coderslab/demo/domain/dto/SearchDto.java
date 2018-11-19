package pl.coderslab.demo.domain.dto;

import javax.validation.constraints.NotNull;

public class SearchDto {
    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
