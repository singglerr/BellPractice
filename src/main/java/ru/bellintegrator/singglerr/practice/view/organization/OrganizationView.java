package ru.bellintegrator.singglerr.practice.view.organization;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(value = "Организация")
public class OrganizationView {

    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    private Long id;

    @Size(max = 50)
    @NotEmpty(message = "name can't be null")
    @ApiModelProperty(value = "Название организации")
    private String name;

    @Size(max = 255)
    @NotEmpty(message = "fullName can't be null")
    @ApiModelProperty(value = "Полное название оргранизации")
    private String fullName;

    @Size(max = 12)
    @NotEmpty(message = "inn can't be null")
    @ApiModelProperty(value = "ИНН организации")
    private String inn;

    @Size(max = 9)
    @NotEmpty(message = "kpp can't be null")
    @ApiModelProperty(value = "КПП организации")
    private String kpp;

    @Size(max = 80)
    @NotEmpty(message = "address can't be null")
    @ApiModelProperty(value = "Адрес регистрации организации")
    private String address;

    @Size(max = 20)
    @ApiModelProperty(value = "Телефон организации")
    private String phone;

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";fullName:" + fullName + ";inn:" + inn + ";kpp:" + kpp + ";address:"
                + address + ";phone:" + phone + ";isActive:" + isActive + "}";
    }
}
