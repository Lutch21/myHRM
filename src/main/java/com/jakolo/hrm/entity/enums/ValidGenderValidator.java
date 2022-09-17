package com.jakolo.hrm.entity.enums;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidGenderValidator implements ConstraintValidator<ValidGender1, String> {


	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		log.info("value of "+value);
		boolean isValid = false;
		for (Gender gender : Gender.values()) {
		   if(gender.toString().equals(value.toUpperCase()))
			   isValid = true;
		}
		
		return isValid;
	}

}
