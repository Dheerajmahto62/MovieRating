package com.Dhiru.watchlist.entity.validations;

import org.springframework.validation.annotation.Validated;

@Validated
public @interface NotBlank {
	String message();
}
