package com.example.demo.restapi;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.restapi.usingmap.service.UserInfoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceTest {
	
	@Autowired
	UserInfoService userInfoService;
	
	public List<Map<String, Object>> paramSet(){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		
		map1.put("id", "aaa12345");
		map1.put("phone", "01012345678");
		map1.put("email", "xxxxx@naver.com");
		map1.put("name", "홍길동");
		map1.put("password", "qwer1234");
		
		map2.put("id", "bbb12345");
		map2.put("phone", "01087654321");
		map2.put("email", "xxxxx@daum.net");
		map2.put("name", "조개껍질");
		map2.put("password", "!init12345");
		
		list.add(map1);
		list.add(map2);
		
		return list;
	}
	
	@Before
	public void insertAllTest() {
		List<Map<String, Object>> list = paramSet();
		
		int cnt = userInfoService.insertList(list);
		assertThat(cnt, is(2));
		System.out.println("insert Count : " + cnt);
	}
	
	@Test
	@Transactional
	public void selectAllTest() {
		List<Map<String, Object>> requestList = paramSet();
		List<Map<String, Object>> list = userInfoService.selectAll();
		for (Map<String, Object> map : list) {
			if(map.get("id").equals("aaa12345")) {
				assertThat(map.get("phone"),  is(requestList.get(0).get("phone")));
				assertThat(map.get("email"),  is(requestList.get(0).get("email")));
				assertThat(map.get("name"),  is(requestList.get(0).get("name")));
			}
		}
		System.out.println("Select LIST : " + list);
	}
	
	@Test
	@Transactional
	public void updateAllTest() {
		List<Map<String, Object>> list = paramSet();
		list.get(0).replace("name", "jeonwoochi");
		list.get(1).replace("phone", "01099999999");
		
		int cnt = userInfoService.updateList(list);
		assertThat(cnt, is(2));
		System.out.println("Update Count  : " + cnt );
	}
	
	@Test
	@Transactional
	public void deleteAllTest() {
		List<Map<String, Object>> list = paramSet();
		
		int cnt = userInfoService.deleteList(list);
		assertThat(cnt, is(2));
		System.out.println("Delete count   : " + cnt);
	}
}
