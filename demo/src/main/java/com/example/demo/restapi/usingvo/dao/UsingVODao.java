package com.example.demo.restapi.usingvo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.restapi.usingvo.vo.UsingVO;

@Mapper
public interface UsingVODao {

	public List<UsingVO> selectAll();
	
	public List<UsingVO> selectFromId(String id);
	
	public List<UsingVO> selectFromId1(Map<String, Object> map);
	
	int insertList(UsingVO param);
	
	int updateList(UsingVO param);
	
	int deleteList(UsingVO param);
}
