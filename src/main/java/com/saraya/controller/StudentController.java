package com.saraya.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.saraya.dao.StudentDAO;

@Controller
public class StudentController {
	@Autowired
	StudentDAO studentdao;
	@GetMapping("/")
	public String showStudent(ModelMap model) throws SQLException {
		model.addAttribute("names",studentdao.getMonRegime("prenom_nom") );
		return "welcome";
	}
	
}
