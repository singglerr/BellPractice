package ru.bellintegrator.singglerr.practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "Страна")
public class CountryView {

	@Size(min = 3, max = 3)
	@NotEmpty(message = "code can't be null")
	@ApiModelProperty(value = "Код страны", example = "643")
	private String code;

	@Size(max = 60)
	@NotEmpty(message = "name can't be null")
	@ApiModelProperty(value = "Название", example = "Россия")
	private String name;

	@Override
	public String toString() {
		return "{code:" + code + ";name:" + name + "}";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
