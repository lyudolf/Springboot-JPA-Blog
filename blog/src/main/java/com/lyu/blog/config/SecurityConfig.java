package com.lyu.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.lyu.blog.config.auth.PrincipalDetailService;
//블로그프로젝트 완성
//빈 등록: 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것
@Configuration //빈 등록(IoC관리)
@EnableWebSecurity //security필터등록
@EnableGlobalMethodSecurity(prePostEnabled =true) //특정주소를 접근하면 권한 및 인증 미리 체크
public class SecurityConfig {

	@Autowired
	private PrincipalDetailService principalDetailService;

	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

	@Bean// IoC가 됨
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	//시큐리티가 대신 로그인해줄때 password가로채기를 하는데
	//해당 password가 뭘로 해쉬가 되어 회원 가입이 되는지 알아야
	//같은 해쉬로 암호화 해서 DB에 있는 해쉬랑 비교 가능
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
		.csrf().disable()//csrf 토큰 비활성화(테스트 시 걸어두는게 좋음)
		.authorizeRequests()
			.antMatchers("/","/auth/**","/js/**", "/css/**","/image/**","/dummy/**")//auth로 들어오는건 누구나 가능
			.permitAll()
			.anyRequest() //1. antmatchers에서 permit 인증 되지 않은 요청은
			.authenticated()
		.and()
			.formLogin()
			.loginPage("/auth/loginForm") //2. loginForm으로 온다
			.loginProcessingUrl("/auth/loginProc")  //스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인 해준다.
			.defaultSuccessUrl("/"); //정상적으로 요청이 완료가 된다면 /으로 가고
			//.failureUrl("#") //실패시 url
		
		return http.build();
	}
	
}
