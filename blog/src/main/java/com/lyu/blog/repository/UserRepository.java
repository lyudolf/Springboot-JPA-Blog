package com.lyu.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lyu.blog.model.User;

//DAO
//자동으로 bean등록이 된다
//@Repository //생략가능
public interface UserRepository extends JpaRepository<User,Integer>{

	
}


//JPA Naming 쿼리
	//1번 방법
	//select * from user where username = ?1 and passowrd = ?2
	//User findByUsernameAndPassword(String username, String password);
	
	//2번 방법
	//@Query(value="SELECT * From user WHERE username=?1 AND passowrd = ?2", nativeQuery = true)
	//User login(String username, String password);
