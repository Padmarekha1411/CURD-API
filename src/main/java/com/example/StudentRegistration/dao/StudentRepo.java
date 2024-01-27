package com.example.StudentRegistration.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.StudentRegistration.bean.StudentDetails;

public interface StudentRepo extends CrudRepository<StudentDetails, Integer>{

}
