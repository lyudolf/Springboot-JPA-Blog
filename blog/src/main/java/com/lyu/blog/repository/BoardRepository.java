package com.lyu.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lyu.blog.model.Board;
import com.lyu.blog.model.User;

public interface BoardRepository extends JpaRepository<Board,Integer>{
	
}
