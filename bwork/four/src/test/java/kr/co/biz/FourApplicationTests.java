package kr.co.biz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.biz.svc.UserService;

@SpringBootTest
class FourApplicationTests {

	@Autowired
	private UserService userService; // 실제 UserService	

	@Test
	void contextLoads() {
		 // 테스트 메소드 실행
        int age = userService.calculateAge(1990);
        
        System.out.println("age결과값: "+age);

        // junit에서 제공하는 결과 검증 로직
        assertEquals(32, age);  // 예상 결과
	}

}
