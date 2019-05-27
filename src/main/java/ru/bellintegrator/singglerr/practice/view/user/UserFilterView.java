package ru.bellintegrator.singglerr.practice.view.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "Фильтр, по которому формируется список сотрудников")
public class UserFilterView {

    @NotNull(message = "officeId can't be null")
    private Integer officeId;

    @Size(max = 50)
    @ApiModelProperty(value = "Имя")
    private String firstName;

    @Size(max = 50)
    @ApiModelProperty(value = "Фамилия")
    private String secondName;

    @Size(max = 50)
    @ApiModelProperty(value = "Отчество")
    private String middleName;

    @Size(max = 100)
    @ApiModelProperty(value = "Занимаемая должность")
    private String position;

    @Size(max = 2)
    @ApiModelProperty(value = "Код вида документа")
    private String docCode;

    @Size(max = 3)
    @ApiModelProperty(value = "Код страны")
    private String citizenshipCode;

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(String citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }
}
