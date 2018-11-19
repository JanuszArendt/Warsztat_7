package pl.coderslab.demo.domain.dto;

import javax.validation.constraints.NotNull;

public class SetingDto {
    @NotNull
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
