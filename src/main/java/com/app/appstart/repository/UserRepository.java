package com.app.appstart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.appstart.entity.Users;

public interface UserRepository extends JpaRepository<Users,Long>{

	@Query("SELECT u FROM Users u WHERE u.isactive = true")
	List<Users> findAllActiveUsers();
	
	
	@Query("SELECT u FROM Users u WHERE u.isactive = false")
	List<Users> findAllInActiveUsers();
	
	 @Query("SELECT u.email, COUNT(u) FROM Users u WHERE u.isactive = true and u.email = :email GROUP BY u.email HAVING COUNT(u) >= 1")
	    List<Object[]> findDuplicat(@Param("email") String email);
	    
	    @Query("SELECT u.mobile_number, COUNT(u) FROM Users u WHERE u.isactive = true and u.mobile_number = :mobile_number GROUP BY u.mobile_number HAVING COUNT(u) >= 1")
	    List<Object[]> findDuplicatMobile(@Param("mobile_number") String mobile_number);
}
