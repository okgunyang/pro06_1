package com.shop2.myapp.service;

import java.util.List;
import com.shop2.myapp.dto.UserDTO;

public interface AjaxService {
	public List<UserDTO> userList() throws Exception;
	public UserDTO getUser(String id) throws Exception;
	public UserDTO getLogin(String id, String pw) throws Exception;
	public void addUser(UserDTO user) throws Exception;
}
