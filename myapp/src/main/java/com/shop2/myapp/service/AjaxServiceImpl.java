package com.shop2.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop2.myapp.dto.UserDTO;
import com.shop2.myapp.model.AjaxMapper;

@Service
public class AjaxServiceImpl implements AjaxService {
	
	@Autowired
	AjaxMapper ajaxMapper;
	
	@Override
	public List<UserDTO> userList() throws Exception {
		return ajaxMapper.userList();
	}

	@Override
	public UserDTO getUser(String id) throws Exception {
		return ajaxMapper.getUser(id);
	}

	@Override
	public UserDTO getLogin(String id, String pw) throws Exception {
		return ajaxMapper.getLogin(id, pw);
	}

	@Override
	public void addUser(UserDTO user) throws Exception {
		ajaxMapper.addUser(user);
	}	
	
	
}
