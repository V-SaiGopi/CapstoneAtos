package com.watch.rolex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.watch.rolex.model.Userregister;

@Repository
public interface UserregisterRepository extends JpaRepository<Userregister, Integer> {

	@Query("select user from Userregister user where user.uname = :uname and user.pword = :pword")
	List<Userregister> findByName(@Param("uname") String name, @Param("pword") String password);

}
