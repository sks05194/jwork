package kr.co.biz.svc;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public int calculateAge(int birthYear) {
        return 2024 - birthYear;  // 현재 년도인 2024에서 출생 연도를 빼서 나이를 계산
    }

    public String greetUser(String name) {
        return "Hello, " + name + "!";
    }
}