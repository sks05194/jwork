package com.springbook.biz.user;

import java.util.List;

public interface UserService {
	public List<UserVO> getUserList(String keyword);
	public UserVO selUser(UserVO vo);
	
	public UserVO login(UserVO vo);
	public int userUpdate(UserVO vo);
	public int userInsert(UserVO vo);
	public int userDelete(UserVO vo);
}
