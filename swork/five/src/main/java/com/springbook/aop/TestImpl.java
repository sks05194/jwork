package com.springbook.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestImpl {
	@Autowired
	private TestDAO td;

	public int getNum() {
		return td.getNum();
	}

	public void intNum(int no) {
		td.intNum(no);
	}

	public void setNum(String str, int no) {
		td.setNum(str, no);
	}
}