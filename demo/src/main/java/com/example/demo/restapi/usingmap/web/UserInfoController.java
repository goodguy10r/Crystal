package com.example.demo.restapi.usingmap.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.restapi.usingmap.service.UserInfoService;


@RestController
@RequestMapping(value="/userinfo")
public class UserInfoController {

	@Autowired
	UserInfoService userInfoService;
	
	@GetMapping("/all")
	public List<Map<String, Object>> selectAll(){
		return userInfoService.selectAll();
	}
	
	@PostMapping("/all")
	public Map<String, Object> insertAll(@RequestBody List<Map<String, Object>> params){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", userInfoService.insertList(params));
		return map;
	}
	
	@PutMapping("/all")
	public Map<String, Object> updateAll(@RequestBody List<Map<String, Object>> params){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", userInfoService.updateList(params));
		return map;
	}
	
	@DeleteMapping("/all")
	public Map<String, Object> deleteAll(@RequestBody List<Map<String, Object>> params){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", userInfoService.deleteList(params));
		return map;
	}
}
