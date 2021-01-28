package com.javalearn.studentmanager.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class ErrorDetails {
    public ErrorDetails(String message2) {
		// TODO Auto-generated constructor stub
	}

	private String message;
}