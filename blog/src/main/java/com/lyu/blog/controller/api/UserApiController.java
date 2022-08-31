package com.lyu.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lyu.blog.dto.ResponseDto;
import com.lyu.blog.model.User;
import com.lyu.blog.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) { // sername, password, email
		System.out.println("UserApiController: save호출됨");
		// 실제로 DB에 insert하고 리턴이 되면 됨
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);// 자바오브젝트를 json으로 변환해서 리턴(jackson)
	}

	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user) { // key=value,x-www-form-urlencoded
		userService.회원수정(user);
		// 여기서는 트랜잭션이 종료되기 때문에 DB에 값은 변경이 됐음.
		// 하지만 세션값은 변경되지 않은 상태기 때문에 직접 세션값을 변경해줘야함.
//		Authentication authentication = 
//				new UsernamePasswordAuthenticationToken(principal, null,principal.getAuthorities());
//		SecurityContext securityContext = SecurityContextHolder.getContext();//강제로 세션값 바꿔주기
//		securityContext.setAuthentication(authentication);
//		session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
		// service 단에서 manager를 통해 구현

		// 세션 등록
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
