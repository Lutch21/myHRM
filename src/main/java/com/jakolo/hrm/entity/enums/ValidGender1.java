package com.jakolo.hrm.entity.enums;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
	ElementType.PARAMETER, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidGenderValidator.class)
public @interface ValidGender1 {
	
	//public Class String regexp();

	public String message() default "Invalid value for gender {Gender.class}";

	public Class<?>[] groups() default {};

	public Class<? extends Payload>[] payload() default {};

}
