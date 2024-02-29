package com.watch.rolex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watch.rolex.model.Userregister;
import com.watch.rolex.repository.UserregisterRepository;

@Service
public class UserregisterService {

	@Autowired
	UserregisterRepository userregisterRepository;

	public List<Userregister> findByName(String uname, String pword) {
		return userregisterRepository.findByName(uname, pword);
	}

	public Userregister insertData(Userregister userregister) {
		return userregisterRepository.save(userregister);
	}
}
