package com.example.demo.restapi.usingmap.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.restapi.usingmap.dao.UserInfoMapper;


@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	UserInfoMapper userInfoMapper;

	@Override
	public List<Map<String, Object>> selectAll() {
		
		return userInfoMapper.selectAll();
	}

	@Override
	public int insertList(List<Map<String, Object>> params) {
		int cnt = 0;
		for (int i = 0; i < params.size(); i++) {
			cnt += userInfoMapper.insertList(params.get(i));
		}
		return cnt;
	}

	@Override
	public int updateList(List<Map<String, Object>> params) {
		int cnt = 0;
		for (int i = 0; i < params.size(); i++) {
			cnt += userInfoMapper.updateList(params.get(i));
		}
		return cnt;
	}

	@Override
	public int deleteList(List<Map<String, Object>> params) {
		int cnt = 0;
		for (int i = 0; i < params.size(); i++) {
			cnt += userInfoMapper.deleteList(params.get(i));
		}
		return cnt;
	}
	
}
