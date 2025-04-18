package com.example.response;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.Student;
import com.example.entity.Subject;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentResponse {

	private long id;

	@JsonProperty("first_name")
	private String firstName;

	private String lastName;

	private String email;

	private String street;

	private String city;

	private List<SubjectResponse> learSubjects;

	public StudentResponse (Student student) {
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		
		this.street = student.getAddress().getStreet();
		this.city = student.getAddress().getCity();

		if (student.getLearningSubjects() != null) {
			learSubjects = new ArrayList<SubjectResponse>();
			for(Subject subject: student.getLearningSubjects()){
				learSubjects.add(new SubjectResponse(subject));
			}
		}
	}

}
