package com.lyu.blog.test;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//사용자가 요청-> 응답(HTML 파일)
//@Controller
//사용자가 요청 -> 응답(Data)
@RestController
public class BlogController {

	@GetMapping("/test/hello")
	public String hello() {
		return "<h1>hello springboot</h1>";
	}
}
