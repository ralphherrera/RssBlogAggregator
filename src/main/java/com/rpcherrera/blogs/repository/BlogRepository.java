package com.rpcherrera.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpcherrera.blogs.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
