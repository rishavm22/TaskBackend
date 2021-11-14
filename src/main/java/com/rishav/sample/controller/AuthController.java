package com.rishav.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishav.sample.model.MyUsers;
import com.rishav.sample.service.AuthService;


@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;

	@GetMapping("/all")
	public ResponseEntity<List<MyUsers>> getAll() {
		return new ResponseEntity<>(authService.findAllUser(), HttpStatus.OK);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<Boolean> getLogin(@RequestBody  MyUsers model) {
		return new ResponseEntity<>(authService.logUser(model), HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<MyUsers> getRegister(@RequestBody MyUsers model) {
		return new ResponseEntity<>(authService.registerUser(model), HttpStatus.OK);
	}
}
