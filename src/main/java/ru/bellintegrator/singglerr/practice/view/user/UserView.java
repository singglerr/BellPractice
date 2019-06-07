package ru.bellintegrator.singglerr.practice.view.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(value = "Сотрудник")
public class UserView {

    @NotNull(message = "id can't be null")
    @ApiModelProperty(value = "Уникальный идентификатор человека")
    private Long id;

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

    public UserView() {
    }

    public UserView(@NotNull(message = "id can't be null") Long id,
                    @NotEmpty(message = "firstName can't be null") @Size(max = 50) String firstName,
                    @Size(max = 50) String secondName,
                    @Size(max = 50) String middleName,
                    @Size(max = 100) @NotEmpty(message = "position can't be null") String position,
                    @Size(max = 20) String phone,
                    @Size(max = 128) String docName,
                    @Size(max = 50) String docNumber,
                    Date docDate,
                    @Size(max = 3) String citizenshipCode,
                    Boolean isIdentified) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.citizenshipCode = citizenshipCode;
        this.isIdentified = isIdentified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
