package ru.bellintegrator.singglerr.practice.view.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(value = "Представление человека для сохранения в БД")
public class SaveUserView {

    @NotNull(message = "officeId can't be null")
    @ApiModelProperty(value = "Уникальный идентификатор офиса")
    private Long officeId;

    @NotEmpty(message = "firstName can't be null")
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
    @NotEmpty(message = "position can't be null")
    @ApiModelProperty(value = "Занимаемая должность")
    private String position;

    @Size(max = 20)
    @ApiModelProperty(value = "Телефонный номер")
    private String phone;

    @Size(max = 2)
    @ApiModelProperty(value = "Код вида документа")
    private String docCode;

    @Size(max = 128)
    @ApiModelProperty(value = "Название документа")
    private String docName;

    @Size(max = 50)
    @ApiModelProperty(value = "Номер документа")
    private String docNumber;

    @ApiModelProperty(value = "Дата выдачи документа")
    private Date docDate;

    @Size(max = 3)
    @ApiModelProperty(value = "Код страны")
    private String citizenshipCode;

    @ApiModelProperty(value = "Подтверждён ли документ")
    private Boolean isIdentified;

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(String citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }
}
