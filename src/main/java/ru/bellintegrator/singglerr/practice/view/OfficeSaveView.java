package ru.bellintegrator.singglerr.practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "Представление офиса для сохранения в БД")
public class OfficeSaveView {

    @NotNull(message = "orgId can't be null")
    @ApiModelProperty(value = "Уникальный идентификатор оргнанизации")
    private Long orgId;

    @NotEmpty(message = "name can't be null")
    @Size(max = 50)
    @ApiModelProperty(value = "Название офиса")
    private String name;

    @NotEmpty(message = "address can't be null")
    @Size(max = 80)
    @ApiModelProperty(value = "Адрес офиса")
    private String address;

    @ApiModelProperty(value = "Телефонный номер офиса")
    private String phone;

    @ApiModelProperty(value = "Активен ли офис")
    private Boolean isActive;

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "{orgId:" + orgId + ";name:" + name + ";address:" + address + ";phone:" + phone + ";isActive:" + isActive + "}";
    }
}
