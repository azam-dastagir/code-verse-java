package com.codeverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeverse.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

	Users findByEmail(String email);

}
