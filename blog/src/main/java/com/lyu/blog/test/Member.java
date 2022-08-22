package com.lyu.blog.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
//@RequiredArgsConstructor final 변수 생성자
@NoArgsConstructor //bean 생성자 
public class Member {
	private int id;
	private String username;
	private String password;
	private String email;
}