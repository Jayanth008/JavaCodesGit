package com.bookauthor.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bookauthor.entity.UserInfo;
import com.bookauthor.repo.UserInfoRepo;

public class UserInfoUserDetailsService implements UserDetailsService {
	@Autowired
	private UserInfoRepo Repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo = Repo.findByUserName(username);
		userInfo.get().setRoles("ROLE_"+userInfo.get().getRoles().toUpperCase());
		System.err.println(userInfo);
		return userInfo.map(t -> new UserInfoUserDetails(t)).get();

//		return null;
	}

}
