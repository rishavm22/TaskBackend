package com.rishav.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishav.sample.model.MyUsers;
import com.rishav.sample.repo.AuthRepository;

@Service
public class AuthService {
	
	@Autowired
	private AuthRepository authRepo;
	
	public MyUsers registerUser(MyUsers user) {
		return authRepo.save(user);
	}
	
	public List<MyUsers> findAllUser() {
		return authRepo.findAll();
	}
	
	public Boolean logUser(MyUsers user) {
		MyUsers loggedUser = authRepo.findByUname(user.getUname()).orElse(null);
		if(loggedUser!=null) {
			if(loggedUser.getPassword().equals(user.getPassword())) return true;
			else return false;
			
		}
		return false;
	}
	

}
