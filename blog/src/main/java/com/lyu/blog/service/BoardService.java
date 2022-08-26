package com.lyu.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyu.blog.model.Board;
import com.lyu.blog.model.RoleType;
import com.lyu.blog.model.User;
import com.lyu.blog.repository.BoardRepository;
import com.lyu.blog.repository.UserRepository;


//spring이 컴포넌트 스캔을 토애서 Bean에 등록을 해줌. IoC를 해준다
@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	public void 글쓰기(Board board, User user) {//title, content
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
	
	public List<Board> 글목록(){
		return boardRepository.findAll();
	}


}
