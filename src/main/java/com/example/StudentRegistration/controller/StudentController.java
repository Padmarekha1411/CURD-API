package com.example.StudentRegistration.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.StudentRegistration.bean.StudentDetails;
import com.example.StudentRegistration.dao.StudentRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

	@RequestMapping("/registration")
	public String register(){
		return "registration";
	}
	
	
	@Autowired
	StudentRepo sr;
	
	
	@PostMapping("/create")
	public String create(@ModelAttribute StudentDetails std,HttpSession session) {
		
		try {
		StudentDetails s=sr.save(std);
		
		if(s!=null) {
			
			System.out.println("insert");
			session.setAttribute("reg-success","Registration Successfully");
			return "redirect:index";
		}
		}catch(DataIntegrityViolationException e){
			System.out.println("wrong!");
			session.setAttribute("failed-msg","Email Id already exists!!");
			return "registration";
		}
		
		
		return "redirect:/index"; 
		
		
		
	}
	
	
	@GetMapping("/update")
	public String update(StudentDetails s,HttpSession session) {
		
		
		session.setAttribute("students",s);
		
		return "update";
	}
	
	
	
	@PostMapping("/update")
	public String updateData(StudentDetails s,HttpSession session) {
		
		System.out.println(s.getID());
		Optional<StudentDetails> op=sr.findById(s.getID());
		StudentDetails s1=op.get();
		System.out.println(s.getFirst_name());
		s1.setID(s.getID());
		s1.setFirst_name(s.getFirst_name());
		s1.setLast_name(s.getLast_name());
		s1.setPhone_no(s.getPhone_no());
		s1.setEmail(s.getEmail());
		s1.setAddress(s.getAddress());
		
		sr.save(s1);
		
		return "redirect:/index";
		
	}
	
	@RequestMapping("/index")
	public List<StudentDetails> show(HttpServletRequest req,HttpServletResponse res){
		
		List<StudentDetails> list=new ArrayList<>();
		for(StudentDetails std:sr.findAll()) {
			list.add(std); 
		}
		HttpSession session=req.getSession();
		session.setAttribute("students",list);
		
		
		return list;
		
	}
	
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute StudentDetails s,HttpServletRequest req,HttpServletResponse res) {
		
		sr.deleteById(s.getID());
		List<StudentDetails> list=new ArrayList<>();
		
		for(StudentDetails std:sr.findAll()) {
			list.add(std);
		}
		
		HttpSession session=req.getSession();
		session.setAttribute("students",list);
		
		return "redirect:/index";
	}
}
