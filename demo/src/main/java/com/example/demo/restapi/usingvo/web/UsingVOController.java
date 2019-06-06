package com.example.demo.restapi.usingvo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.restapi.usingmap.service.UserInfoService;
import com.example.demo.restapi.usingvo.service.UsingVOService;
import com.example.demo.restapi.usingvo.vo.UsingVO;

@RestController
@RequestMapping(value="/usevo")
public class UsingVOController {
	
	@Autowired
	UsingVOService usingVOService;
	
	@GetMapping("/all")
	public List<UsingVO> selectAll(){
		return usingVOService.selectAll();
	}
	
//	@GetMapping("/all/{id}")
//	public List<UsingVO> selectFromId(@PathVariable(value = "id") String id){
//		return usingVOService.selectFromId(id);
//	}
	
	@GetMapping("/all/{id}")
	public List<UsingVO> selectFromId1(@PathVariable(value = "id") String id,
			@RequestParam(name="type", required=false) String type){
		return usingVOService.selectFromId1(id, type);
	}
	
	
	@PostMapping("/all")
	public int insertAll(@RequestBody List<UsingVO> params){
		return usingVOService.insertList(params);
	}
	
	@PutMapping("/all")
	public int updateAll(@RequestBody List<UsingVO> params){
		return usingVOService.updateList(params);
	}
	
	@DeleteMapping("/all")
	public int deleteAll(@RequestBody List<UsingVO> params){
		return usingVOService.deleteList(params);
	}

}
