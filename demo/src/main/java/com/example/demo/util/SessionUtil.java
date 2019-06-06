package com.example.demo.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.example.demo.restapi.login.dto.UserInfoDto;
import com.google.gson.Gson;

public class SessionUtil {

	//http://dveamer.github.io/backend/SpringRequestContextHolder.html 참고 사이트 
	public static final String sessionKey = "member";
	
	public static Object getAttribute(String name) throws Exception {
		return RequestContextHolder.getRequestAttributes().getAttribute(name, RequestAttributes.SCOPE_SESSION);
	}
	
	public static void setAttribute(String name, Object object) throws Exception {
		RequestContextHolder.getRequestAttributes().setAttribute(name, object, RequestAttributes.SCOPE_SESSION);
	}
	
	public static void removeAtttribute(String name) throws Exception {
		RequestContextHolder.getRequestAttributes().removeAttribute(name, RequestAttributes.SCOPE_SESSION);
	}
	
	public static String getSessionID() {
		return RequestContextHolder.getRequestAttributes().getSessionId();
	}
	
	public static UserInfoDto userInfoDto() {
		Gson gson = new Gson();
		String json = (String) RequestContextHolder.getRequestAttributes().getAttribute(sessionKey, RequestAttributes.SCOPE_REQUEST);
		UserInfoDto userInfoDto = gson.fromJson(json, UserInfoDto.class);
		if(userInfoDto == null) {
			return new UserInfoDto();
		}
		return userInfoDto;
	}
	
	public static String getUserId() {
		return SessionUtil.userInfoDto().getId();
	}
}
