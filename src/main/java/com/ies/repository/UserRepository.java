package com.ies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ies.entity.UsersEntity;

public interface UserRepository extends JpaRepository<UsersEntity,Integer> {

	 @Modifying
	 @Query("UPDATE UsersEntity u SET u.accountStatus = :status WHERE u.userId = :userId")
	public  Integer updateAccountStatus(Integer userId,String status);
	
	//findBy query
	public UsersEntity findByEmail(String email);
	
	public UsersEntity findByEmailAndPwd(String email,String pwd);
}
