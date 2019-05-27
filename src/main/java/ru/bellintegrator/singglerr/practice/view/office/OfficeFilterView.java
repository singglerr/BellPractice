package ru.bellintegrator.singglerr.practice.view.office;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "Фильтр, по которому формируется список офисов")
public class OfficeFilterView {

    @NotNull
    @ApiModelProperty(value = "Уникальный идентификатор организации")
    private Long orgId;

    @Size(max = 50)
    @ApiModelProperty(value = "Название офиса")
    private String name;

    @Size(max = 20)
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
        return "{orgId:" + orgId + ";name:" + name + ";phone:" + phone + ";isActive:" + isActive + "}";
    }
}
