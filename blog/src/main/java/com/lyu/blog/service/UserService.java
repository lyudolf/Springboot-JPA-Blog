package com.lyu.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyu.blog.model.User;
import com.lyu.blog.repository.UserRepository;


//spring이 컴포넌트 스캔을 토애서 Bean에 등록을 해줌. IoC를 해준다
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void 회원가입(User user) {
		userRepository.save(user);
	}
//	@Transactional(readOnly = true) //select할 때 트랜잭션 시작, 서비스 종료시 트랜잭션 종료(정합성 유지)
//	public User 로그인(User user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
//	}

}
