package third;

public class StringEx {
	public static void main(String[] args) {
//		// 문자열 길이 : length()메소드
//		String s = null + " plus String";
//		int str_l = s.length();
//		System.out.println(str_l);
//		
//		String str = "안녕하세요, 반갑습니다.";
//		int str_length = str.length();
//		System.out.println("\"" + str + "\"의 문자열 갯수(문자 길이)는 " + str_length + "입니다.");

//		======================================================================

//		// equals() : 객체의 값 비교
//		Integer i = new Integer(7);
//		Integer e = 7;
//		System.out.println("i: " + i + ", e: " + e);
//		System.out.println("객체비교 => i == e : " + (i == e));
//		System.out.println("값 비교 => i.equals(e) : " + (i.equals(e)));
//
//		System.out.println("실제 해시코드값: " + System.identityHashCode(i));
//		System.out.println("실제 해시코드값: " + System.identityHashCode(e));
//		System.out.println("재정의된 해시코드값: " + i.hashCode());
//		System.out.println("재정의된 해시코드값: " + e.hashCode());
//		System.out.println("\n=============================\n");
//
//		String s = new String("한글");
//		String t = "한글";
//		System.out.println("s: " + s + ", t: " + t);
//		System.out.println("객체비교 => s == t : " + (s == t));
//		System.out.println("값 비교 => s.equals(t) : " + (s.equals(t)));
//
//		System.out.println("실제 해시코드값: " + System.identityHashCode(s));
//		System.out.println("실제 해시코드값: " + System.identityHashCode(t));
//		System.out.println("재정의된 해시코드값: " + s.hashCode());
//		System.out.println("재정의된 해시코드값: " + t.hashCode());

//		======================================================================

//		// 문자열 인덱스
//		String a = "Good Afternoon!!";
//		System.out.println("1번. " + a.indexOf("noon"));
//		System.out.println("2번. " + a.indexOf(" Af"));
//
//		String hello = "HelloWorld_MyWorld";
//		// indexOf(문자열) : 해당 문자열의 맨 앞글자를 왼쪽에서부터 찾아서 해당 인덱스를 반환함.
//		System.out.println("3번. " + hello.indexOf("World"));
//		// indexOf(문자열, 인덱스번호) : 해당 문자열의 맨 앞글자를 왼쪽에서부터 찾아서 해당 인덱스를 반환하는 것은 동일함.
//		// 단, 인덱스번호를 시작지점으로 인식하여, 그 지점부터 해당 문자열의 맨 앞글자를 왼쪽에서부터 찾아서 해당 인덱스를 반환함.
//		System.out.println("4번. " + hello.indexOf("World", 10));
//		// lastIndexOf(문자열) : 해당 문자열의 맨 앞글자를 오른쪽에서부터 찾아서 해당 인덱스를 왼쪽에서부터 세어 반환함.
//		System.out.println("5번. " + hello.lastIndexOf("World"));
//		// lastIndexOf(문자열, 인덱스번호) : 해당 문자열의 맨 앞글자를 오른쪽에서부터 찾는것은 동일함.
//		// 단, 인덱스 번호를 앞에서부터 세어 그 지점을 끝지점으로 인식하여,
//		// 그 지점부터 오른쪽에서 왼쪽으로 해당 문자열의 맨 앞글자를 찾아서 해당 인덱스를 앞에서부터 세어 반환함.
//		System.out.println("6-1번. " + hello.lastIndexOf("World", 13));
//		System.out.println("6-2번. " + hello.lastIndexOf("World", 12));
//
//		hello = "AaBbCc"; // 아스키코드 값으로 인덱스 찾기
//		// indexOf(아스키코드값) : 아스키코드 값에 해당하는 문자를 찾아 인덱스를 반환함.
//		System.out.println("7번. " + hello.indexOf(65));
//		System.out.println("8번. " + hello.indexOf(99));

//		======================================================================

//		// contains : 문자열 포함 여부
//		String str = "my java test";
//
//		System.out.println(str.contains("java")); // true
//		System.out.println(str.contains(" my")); // false
//		System.out.println(str.contains("JAVA")); // false
//		System.out.println(str.contains("java test")); // true

//		======================================================================

//		// 문자열 치환 : replace, replaceAll(정규표현식 사용가능)
//		String b = "Welcome to Java World ";
//		System.out.println(b.replace("Java", "Computer"));
//		System.out.println(b.replaceAll("Java", "Computer"));
//
//		String str = "abcdefghijk";
//		System.out.println("result ===> " + str.replaceAll("[abchij]", "굿"));
//		System.out.println("result ===> " + str.replaceAll("[^abchij]", "굿"));
//		// 캐럿 기호 : ^, < 같이 뾰족한 기호들
//		
//		// 체이닝 기법
//		System.out.println("result ===> " + str.replace("a", "굿").replace("b", "굿").replace("c", "굿").replace("h", "굿").replace("i", "굿").replace("j", "굿"));
//		System.out.println("result ===> " + str.replace("abc", "굿~").replace("hij", "럭키~"));

//		// 문자열 추출: substring(0,4) (시작인덱스번호) ~ (해당인덱스번호-1)까지
//		String a = "Welcome to Java World ";
//		System.out.println(a.substring(0, 4)); // 0 ~ 4 - 1 까지
//		System.out.println(a.substring(4)); // 4 ~ 끝까지
//		System.out.println(a.substring(1, 8)); // 1 ~ 8 - 1 까지

//		// 대소문자 변경 : toUpperCase(), toLowerCase()
//		String a = "Welcome to Java World ";
//		System.out.println("모두 대문자로: " + a.toUpperCase());
//		System.out.println("모두 소문자로: " + a.toLowerCase());

//		// 공백 제거: trim()
//		String str4 = "   공백  제거    공백  제거    ";
//		System.out.println("[" + str4 + "]");
//		System.out.println("[" + str4.trim() + "]");
//		System.out.println("[" + str4.replace(" ", "") + "]");

//		String s = "abCDEfgHi jkLmnOP";
//		System.out.println(s.indexOf("abC"));
//		System.out.println(s.indexOf("Lmn"));
//		System.out.println(s.indexOf("lmn"));

		// concat : 문자열 뒤로 추가
		String str = new String("Java");
		System.out.println("원본 문자열 : " + str);

		System.out.println(str.concat("수업"));
		System.out.println("concat() 메소드 호출 후 원본 문자열 : " + str);
	}
}

//
//
//
//
//
//
//
//
//
//
//
//