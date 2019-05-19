package ru.bellintegrator.singglerr.practice.view.filter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(value = "Фильтр, по которому формируется список организаций")
public class OrganizationFilterView {

    @NotEmpty
    @Size(max = 50)
    @ApiModelProperty(value = "Название организации")
    private String name;

    @Size(max = 12)
    @ApiModelProperty(value = "ИНН организации")
    private String inn;

    @ApiModelProperty(value = "Активна ли организация")
    private Boolean isActive;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
