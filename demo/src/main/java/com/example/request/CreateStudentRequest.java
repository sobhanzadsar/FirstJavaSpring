package com.example.request;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateStudentRequest {
	
	@JsonProperty("first_name")
	@NotBlank(message = "First name is requierd")
	private String firstName;

	private String lastName;

	private String email;

	private String street;

	private String city;

	private List<CreateSubjectRequest> subjectsLearning;

	public Double getMarksObtained() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getMarksObtained'");
	}

	
}
