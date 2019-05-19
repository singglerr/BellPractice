package ru.bellintegrator.singglerr.practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "Упрощённое представление организации")
public class SimpleOrganizationView {

    @NotNull(message = "id can't be null")
    @ApiModelProperty(value = "Уникальный идентификатор")
    private Long id;

    @NotEmpty(message = "name can't be null")
    @Size(max = 50)
    @ApiModelProperty(value = "Название организации")
    private String name;

    @ApiModelProperty(value = "Активна ли организация")
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";isActive:" + isActive + "}";
    }
}
