package com.example.demo.restapi.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.restapi.service.UserInfoService;

@Controller
@RequestMapping(value="/userinfo")
public class UserInfoController {

	@Autowired
	UserInfoService userInfoService;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> selectAll(){
		return userInfoService.selectAll();
	}
	
	@RequestMapping(value="/all", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertAll(@RequestBody List<Map<String, Object>> params){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", userInfoService.insertList(params));
		return map;
	}
	
	@RequestMapping(value="/all", method=RequestMethod.PUT)
	@ResponseBody
	public Map<String, Object> updateAll(@RequestBody List<Map<String, Object>> params){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", userInfoService.updateList(params));
		return map;
	}
	
	@RequestMapping(value="/all", method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> deleteAll(@RequestBody List<Map<String, Object>> params){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", userInfoService.deleteList(params));
		return map;
	}
}
