package edu.sejong.ex.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
public class EmpUserDetailsVO implements UserDetails {
	
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	private EmpVO emp;
	
	
	 public EmpUserDetailsVO(EmpVO emp) {
		this.setUsername(emp.getEname());
		this.setPassword(String.valueOf(emp.getEmpno()));
		//this.setAuthorities("ROLE_USER");
		this.setEmp(emp);
	}
	
//	
//	public void setAuthorities(String authString) {
//		
//		this.authorities;
//	}
	  public EmpVO getEmp() {
		return emp;
	}
	   @Override
	   public Collection<? extends GrantedAuthority> getAuthorities() {
		   List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		   authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		   		
	      return authorities;
	   }

	   @Override
	   public String getPassword() {
	         return this.password;
	   }

	   @Override
	   public String getUsername() {   
	      return this.username;
	   }
	   // 계정이 만료 되지 않았는가?
	   @Override
	   public boolean isAccountNonExpired() {
	      // TODO Auto-generated method stub
	      return true;
	   }

	   // 계정이 잠기지 않았는가?
	   @Override
	   public boolean isAccountNonLocked() {
	      // TODO Auto-generated method stub
	      return true;
	   }
	   // 패스워드가 만료되지 않았는가?
	   @Override
	   public boolean isCredentialsNonExpired() {
	      // TODO Auto-generated method stub
	      return true;
	   }
	   // 계정이 활성화 되었는가?
	   @Override
	   public boolean isEnabled() {
	      // TODO Auto-generated method stub
	      return true;
	   }
	}