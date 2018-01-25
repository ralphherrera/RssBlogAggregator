package com.rpcherrera.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpcherrera.blogs.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
