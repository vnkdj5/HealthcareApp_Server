package com.heathcare.app.services;

import java.util.List;

import com.heathcare.app.pojos.Admin;

public interface AdminService {
/*Admin create(Admin Admin);
	
	Admin delete(Long id);
	
	Admin update(Admin Admin);
	List<Admin> findAll();*/
	Admin findById(Long id);
	
	Admin findByUsernameAndPassword(String username, String password);
	
	
}
