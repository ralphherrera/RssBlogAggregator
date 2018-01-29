package com.rpcherrera.blogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpcherrera.blogs.entity.Blog;
import com.rpcherrera.blogs.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

	List<Blog> findByUser(User user);

}
