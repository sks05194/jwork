package com.springbook.biz.user;

import java.util.List;

public interface UserService {
	public UserVO login(UserVO vo);
	public List<UserVO> getuserList();
	public int userUpdate(UserVO vo);
	public int userInsert(UserVO vo);
	public int userDelete(UserVO vo);
}
