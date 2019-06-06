package com.example.demo.restapi.login.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.restapi.login.dto.LoginDto;
import com.example.demo.restapi.login.dto.UserInfoDto;
import com.example.demo.restapi.login.service.LoginService;
import com.example.demo.util.PasswordEncrypt;
import com.example.demo.util.SessionUtil;
import com.google.gson.Gson;


@RestController
public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login/users/{id}")
	public boolean checkForLogin(HttpServletRequest req, 
			@PathVariable String id, @RequestBody LoginDto loginDto) throws Exception {
		loginDto.setId(id);
		loginDto.setPassword(PasswordEncrypt.ecryptMD5((String) loginDto.getPassword()));
		
		UserInfoDto userInfoDto = loginService.login(loginDto);
		if (userInfoDto != null && !"".equals(userInfoDto.getId())) {
			Gson gson = new Gson();
			String json = gson.toJson((Object) userInfoDto);
			SessionUtil.setAttribute((String) "member", (Object) json);
			return true;
		}
		throw new Exception();
	}
}
