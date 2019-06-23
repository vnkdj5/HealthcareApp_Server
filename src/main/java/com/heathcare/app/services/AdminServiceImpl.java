package com.heathcare.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heathcare.app.pojos.Admin;
import com.heathcare.app.pojos.Admin;
import com.heathcare.app.repos.AdminRepository;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository repository;
	@Override
	public Admin findById(Long id) {
Optional<Admin> admin=repository.findById(id);
		
		if(admin.isPresent()) {
			return admin.get();
		}
		else
		{
			return null;
		}
	}

	@Override
	public Admin findByUsernameAndPassword(String username, String password) {
Optional<Admin> admin=repository.findByUsernameAndPassword(username, password);
		
		if(admin.isPresent()) {
			return admin.get();
		}
		else
		{
			return null;
		}
	}

}
