package com.solides.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solides.blog.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
