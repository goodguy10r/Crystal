package com.example.demo.restapi.login.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.restapi.login.dao.LoginDao;
import com.example.demo.restapi.login.dto.LoginDto;
import com.example.demo.restapi.login.dto.UserInfoDto;

@Service
public class LoginService {

	@Autowired
	private LoginDao loginDao;
	
	public UserInfoDto login(LoginDto loginDto) {
		return loginDao.login(loginDto);
	}
}
