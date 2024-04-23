package edu.sejong.ex.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됨
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		// .ignoring() <---- 이에 해당하는 것들은 스프링 시큐리티로 막지 말라는 설정
		web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
		// 5개 정도의 정해진 default정적 리소스 파일들은 무시하게 되는 설정

		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
		// 무시할 정적 리소스의 파일들을 지정하여 무시하도록 설정
	}

	// 테스토용 유저 만들기(인메모리 방식)
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// {noop}는 암호화를 거치지 않는다.
		// .roles()는 권한
		auth.inMemoryAuthentication().withUser("member").password("{noop}member").roles("USER").and().withUser("admin")
				.password("{noop}admin").roles("ADMIN");

	}

	
	  @Override 
	  public void configure(HttpSecurity http) throws Exception {
	  
	  //우선 csrf설정을 해제 //초기 개발 시만 해주는게 좋다. 
		  http.csrf().disable();
		  http.authorizeRequests()
	  .antMatchers("/user/**").hasAnyRole("USER")
	  .antMatchers("/board/**").hasAnyRole("ADMIN")
	  .antMatchers("/**").permitAll();
	  http
	  .formLogin()
	  			.loginPage("/login")
	  			.usernameParameter("id")
	  			.passwordParameter("pw")
	  			.defaultSuccessUrl("/")
	  			.permitAll();
	  //모든 유저가 로그인 화면은 엑세스가 가능하다.
	  }
	 
	/*
	 * @Override public void configure(HttpSecurity http) throws Exception {
	 * 
	 * //ADMIN만 /mapper/empList에 엑세스할 수 있도록 권한 설정 http.csrf().disable();
	 * 
	 * 
	 * http.authorizeRequests()
	 * .antMatchers("/mapper/empList").hasAnyRole("ADMIN");
	 * 
	 * http.formLogin(); }
	 */

}