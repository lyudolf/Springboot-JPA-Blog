package com.lyu.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity //User 클래스가 MySQL에 테이블이 생성된다
public class User {
	
	@Id //Primary key
	@GeneratedValue(strategy= GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다
	private int id; //시퀀스, auto_increment
	
	@Column(nullable = false, length = 30)
	private String username;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@ColumnDefault("'user'")
	private String role; //Enum을 쓰는게 좋다. /-권한설정-/ domain 설정가능
	
	@CreationTimestamp //시간 자동입력
	private Timestamp createDate;
}
