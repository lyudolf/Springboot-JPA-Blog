package com.lyu.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lyu.blog.dto.ResponseDto;
import com.lyu.blog.model.RoleType;
import com.lyu.blog.model.User;
import com.lyu.blog.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) { //sername, password, email
		System.out.println("UserApiController: save호출됨");
		//실제로 DB에 insert하고 리턴이 되면 됨
		user.setRole(RoleType.USER);
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);//자바오브젝트를 json으로 변환해서 리턴(jackson)
	}

}
