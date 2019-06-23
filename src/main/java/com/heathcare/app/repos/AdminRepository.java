package com.heathcare.app.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heathcare.app.pojos.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	Optional<Admin> findByUsernameAndPassword(String username, String password);
}
