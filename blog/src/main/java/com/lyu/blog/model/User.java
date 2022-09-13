package com.lyu.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//ORM=>Java Object->다른 테이블로 매핑해주는 기술
//@DynamicInsert insert시에 null인 필드를 제외시켜준다
@Entity //User 클래스가 MySQL에 테이블이 생성된다
public class User {
	
	@Id //Primary key
	@GeneratedValue(strategy= GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다
	private int id; //시퀀스, auto_increment
	
	@Column(nullable = false, length = 50)
	private String username;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	//@ColumnDefault("user")
	//DB는 RoleType이라는게 없다
	@Enumerated(EnumType.STRING)
	private RoleType role; //Enum을 쓰는게 좋다. //ADMIN,USER
	
	@CreationTimestamp //시간 자동입력
	private Timestamp createDate;
}
