package com.example.demo.restapi.usingvo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.restapi.usingvo.dao.UsingVODao;
import com.example.demo.restapi.usingvo.vo.UsingVO;

@Service
public class UsingVOService {

	@Autowired
	UsingVODao usingVODao;

	public List<UsingVO> selectAll() {
		return usingVODao.selectAll();
	}
	
	public List<UsingVO> selectFromId(String id){
		return usingVODao.selectFromId(id);
	}
	
	public List<UsingVO> selectFromId1(String id, String type){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("type", type);
		return usingVODao.selectFromId1(map);
	}

	public int insertList(List<UsingVO> params) {
		int cnt = 0;
		for (int i = 0; i < params.size(); i++) {
			cnt += usingVODao.insertList(params.get(i));
		}
		return cnt;
	}

	public int updateList(List<UsingVO> params) {
		int cnt = 0;
		for (int i = 0; i < params.size(); i++) {
			cnt += usingVODao.updateList(params.get(i));
		}
		return cnt;
	}

	public int deleteList(List<UsingVO> params) {
		int cnt = 0;
		for (int i = 0; i < params.size(); i++) {
			cnt += usingVODao.deleteList(params.get(i));
		}
		return cnt;
	}
}
