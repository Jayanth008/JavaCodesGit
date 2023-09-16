package com.bookauthor.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookauthor.entity.UserInfo;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo, Integer> {

	Optional<UserInfo> findByUserName(String username);

//	boolean userExists(String userName);
	boolean existsByUserName(String username);

}
