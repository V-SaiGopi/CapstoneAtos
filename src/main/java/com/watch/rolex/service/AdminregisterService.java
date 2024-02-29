package com.watch.rolex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watch.rolex.model.Adminregister;
import com.watch.rolex.repository.AdminregisterRepository;

@Service
public class AdminregisterService {
	
	@Autowired
	AdminregisterRepository adminregisterRepository;
	
	public List<Adminregister> findByName(String uname, String pword) {
		return adminregisterRepository.findByName(uname, pword);
	}

	public Adminregister insertData(Adminregister adminregister) {
		return adminregisterRepository.save(adminregister);
	}
}

