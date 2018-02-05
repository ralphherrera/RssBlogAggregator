package com.rpcherrera.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpcherrera.blogs.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
}
