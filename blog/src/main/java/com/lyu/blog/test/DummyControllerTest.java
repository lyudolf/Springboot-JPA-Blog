package com.lyu.blog.test;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lyu.blog.model.RoleType;
import com.lyu.blog.model.User;
import com.lyu.blog.repository.UserRepository;

@RestController //html파일이 아니라 data를 리턴해주는 controller=RestController
public class DummyControllerTest {

	@Autowired //의존성 주입
	private UserRepository userRepository;

	//save함수는 id를 전달하지 않으면 insert를 해주고
	//save함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 update를 해주고
	//save함수는 id를 전달하면 해당 id에 대한 데이터가 없으면 insert를 한다.
	//email,password

	@DeleteMapping("/dummy/user/{id}")
	public String deleteUser(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) { //Exception 을 걸어도 되지만 다른 Exception이 걸릴 수 있어 정확하게 잡아주는게 중요하다
			return "삭제에 실패하였습니다. 해당 id는 DB에 없습니다.";
		}
		
		return "삭제 되었습니다.id:"+ id;
		
	}
	
	@Transactional //함수 종료시에 자동 commit이 됨.
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {//json 데이터를 요청=> java object(MessageConverter의 Jackson 라이브러리가 변환해서 받아줌
		System.out.println("id:" + id);
		System.out.println("password:" + requestUser.getPassword());
		System.out.println("email:" + requestUser.getEmail());
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		
		// userRepository.save(user);
		
		// transactional 더티체킹
		return user;

	}
	
	//http://localhost:8000/blog/dummy/user
	@GetMapping("/dummy/users")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	//한 페이지당 2건의 데이터를 리턴받아보기
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
		Page<User> pagingUser = userRepository.findAll(pageable);
		/*if(pagingUser.isFirst()) {
			
		}
		*/
		List<User> users= pagingUser.getContent();
		return users;
	}
	
	//{id} 주소로 파라미터 전달 받을 수 있음
	//http://localhost:8000/blog/dummy/user/{id}
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		//없는 유저를 찾으면 데이터베이스에서 못찾아오게되므로 user가 null이 된다
		//return null 이되면 프로그램 문제
		//Optional로 User객체를 감싸서 가져오면 null인지 판단해서 return
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>(){

			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당 유저를 찾을수 없습니다. id: " + id);
			}//없으면 유저가 없다고 알려주는 페이지를 보여준다
		
		/* 람다식
		User user = userRepository.findById(id).orEseThrow(()->{
			return new IllegalArgumentException("해당 사용자는 없습니다.");
		});
		return user;
		 */
			
		/*
		User user = userRepository.findById(id).orElseGet(new Supplier<User>(){
			@Override
			public User get() {
				return new User();
		}//없으면 만들어서 user에넣는다
		*/

			
		});
		//요청:웹 브라우저
		//user 객체 = 자바 오브젝트
		//변환( 웹브라우저가 이해할 수 있는 데이터)->json(Gson 라이브러리)
		//스프링부트= MessageConverter 가 응답 시 자동 작동
		//만약 자바 오브젝트를 리턴하게 되면 Messageconverter가 Jackson 라이브러리를 호출해서
		//user 오브젝트를 json으로 변환해서 브라우저에 던져준다
		return user;
	}
	
	//http://localhost:8000/blog/dummy/join(요청)
	//http의 body에 username, password, email 데이터를 가지고(요청)
	@PostMapping("/dummy/join")
	public String join(User user) {//key=value(규칙)
		System.out.println("username:" + user.getUsername());
		System.out.println("password:" + user.getPassword());
		System.out.println("email:" + user.getEmail());
		System.out.println("role:" + user.getRole());
		System.out.println("createDate:" + user.getCreateDate() );
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
				
	}
}
