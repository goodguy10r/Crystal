package com.example.demo.restapi.usingmap.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {

	public List<Map<String, Object>> selectAll();
	
	int insertList(Map<String, Object> param);
	
	int updateList(Map<String, Object> param);
	
	int deleteList(Map<String, Object> param);
}
