package com.lyu.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HTTPControllerTest {

	private static final String TAG="HttpControllerTeset:";
	
	@GetMapping("http/lombok")
	public String lombokTest() {
		Member m = new Member(1,"lyu","1234","email");
		System.out.println(TAG+"getter:" +m.getId());
		m.setId(5000);
		System.out.println(TAG+"setter:" +m.getId());
		return "lombok test 완료";
	}
	
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get 요청:" + m.getId() +","+ m.getUsername()+ "," + m.getPassword() ;
	}
	@PostMapping("/http/post")
	public String postTest() {
		return "post 요청";
	}
	@PutMapping("/http/put")
	public String putTest() {
		return "put 요청";
	}
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
