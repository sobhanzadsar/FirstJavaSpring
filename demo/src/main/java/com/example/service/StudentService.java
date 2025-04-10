package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.entity.Student;
import com.example.repository.StudentRepository;
import com.example.request.CreateStudentRequest;
import com.example.request.InQueryRequest;
import com.example.request.UpdateStudentRequest;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getAllStudents () {
		return studentRepository.findAll();
	}
	
	public Student createStudent (CreateStudentRequest createStudentRequest) {
		Student student = new Student(createStudentRequest);
		
		student = studentRepository.save(student);
		return student;
	}

	public Student updateStudent (UpdateStudentRequest updateStudentRequest) {
		Student student = studentRepository.findById(updateStudentRequest.getId()).get();

		if (updateStudentRequest.getFirstName()!= null && !updateStudentRequest.getFirstName().isEmpty()){
			student.setFirstName(updateStudentRequest.getFirstName());
		} 

		student = studentRepository.save(student);
		
		return student;
	}

	public String deleteStudent (long id) {
		studentRepository.deleteById(id);
		return "Student has been delete successfully";
	}

	public List<Student> getByFirstName (String firstName){
		return studentRepository.findByFirstName(firstName);
	}

	public Student getByFirstNameAndLastName (String firstName, String lastName){
		// return studentRepository.findByFirstNameAndLastName(firstName,lastName);
		return studentRepository.getByFirstNameAndLastName(firstName,lastName);

	}

	public List<Student> getByFirstNameOrLastName (String firstName, String lastName){
		return studentRepository.findByFirstNameOrLastName(firstName, lastName);
	}
	public List<Student> getByFirstNameIn (InQueryRequest inQueryRequest){
		return studentRepository.findByFirstNameIn(inQueryRequest.getFirstNames());
	}
	public List<Student> getAllWithPagination (int pageNo, int pageSize){
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);

		return studentRepository.findAll(pageable).getContent();
	}
	public List<Student> getAllWithSorting (){
		Sort sort = Sort.by(Sort.Direction.ASC, "firstName");

		return studentRepository.findAll(sort);
	}
	public List<Student> like(String firstName){
		return studentRepository.findByFirstNameContains(firstName);
	}
	public List<Student> startWith(String firstName){
		return studentRepository.findByFirstNameStartingWith(firstName);
	}

}
