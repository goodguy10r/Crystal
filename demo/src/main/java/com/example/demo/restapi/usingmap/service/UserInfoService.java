package com.example.demo.restapi.usingmap.service;

import java.util.List;
import java.util.Map;

public interface UserInfoService {

	List<Map<String, Object>> selectAll();
	
	int insertList(List<Map<String, Object>> params);
	
	int updateList(List<Map<String, Object>> params);
	
	int deleteList(List<Map<String, Object>> params);
}
