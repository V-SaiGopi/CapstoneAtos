package com.watch.rolex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.watch.rolex.model.Adminregister;

@Repository
public interface AdminregisterRepository extends JpaRepository<Adminregister, Integer> {
	
	@Query("select user from Adminregister user where user.uname = :uname and user.pword = :pword")
	List<Adminregister> findByName(@Param("uname") String name, @Param("pword") String password);

}
