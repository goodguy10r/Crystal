package com.example.demo.restapi.login.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.restapi.login.dto.LoginDto;
import com.example.demo.restapi.login.dto.UserInfoDto;

@Mapper
public interface LoginDao {
	public UserInfoDto login(LoginDto loginDto);
}
