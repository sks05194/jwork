package dbc4_1;

import java.util.ArrayList;
import java.util.Scanner;

public class TB_MEMBER_EX {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TB_MEMBER_DAO dao = new TB_MEMBER_DAO();
		boolean tf = false;
		while(true) {
			//회원가입 String m_userid,String  m_pwd,String  m_email,String  m_hp
			System.out.println("회원가입 메뉴");
			System.out.print("아이디 입력>>");
			String mid = sc.next();
			
			System.out.print("비밀번호 입력>>");
			String mpw = sc.next();
			
			System.out.println("이메일 입력 선택  1.예  2.아니오");
			int yn = sc.nextInt();
			String mml =null;
			if(yn == 1) {
				System.out.println("이메일입력>>");
				mml = sc.next();
			}
			
			System.out.println("핸드폰번호 입력 선택  1.예  2.아니오");
			yn = sc.nextInt();
			String mph =null;
			if(yn == 1) {
				System.out.print("핸드폰번호입력>>");
				mph = sc.next();
			}
			
			if(mid == null || mid.equals("") || mpw == null || mpw.equals("") ) {
				continue;
			}else {
				int cnt = dao.join(mid,mpw,mml,mph);
				
				if(cnt>0) {
					System.out.println("회원가입 성공");
					break;
				}else {
					System.out.println("회원가입 실패");
					continue;
				}
			}
		}
		
		//로그인 
		while(true) {
			System.out.println("로그인 메뉴");
			System.out.print("아이디 입력>> ");
			String id = sc.next(); //"abc"
			
			System.out.print("비밀번호 입력>> ");
			String pw = sc.next(); //"1111"
			
			TB_MEMBER_VO vo = dao.login(id, pw);
			
			if(vo != null) {
				System.out.println("로그인 성공");
				tf = true;
				break;
			}else {
				System.out.println("정보가 일치하는 회원이 없습니다.");
			}
		}
		
		//회원 수정하기
		
		System.out.println("회원수정 하기");
		String n_m_pwd = "", o_m_pwd = "", m_email = "", m_hp = "", m_userid = "";
		System.out.print("아이디 입력>>");
		m_userid = sc.next();
		
		System.out.print("비밀번호 입력>>");
		o_m_pwd = sc.next();
		
		modi:
		while(true) {
			System.out.println("변경할 메뉴를 선택해주세요.");
			System.out.println("1. 이메일 변경  2. 전화번호 변경  3. 비밀번호 변경   4. 수정하기  5.완료");
			int yn = sc.nextInt();
			switch(yn) {
				case 1 : 
					System.out.print("변경할 이메일 입력>>");
					m_email = sc.next();
					break;
				case 2 : 
					System.out.println("변경할 전화번호 입력");
					m_hp = sc.next();
					break;
				case 3 :
					System.out.println("변경할 비밀번호 입력");
					n_m_pwd = sc.next();
					break;
				case 4 : 
					int cnt = dao.myUpdate(n_m_pwd, o_m_pwd, m_email, m_hp, m_userid);
					if(cnt > 0) System.out.println("수정완료");
					else System.out.println("수정실패");
					break;
				default : 
					System.out.println("수정 메뉴를 종료하겠습니다. ");
					break modi;
			}
		}
		
		//전체회원 목록 조회
		System.out.println("전체회원 목록 조회");
		if(tf) {
			ArrayList<TB_MEMBER_VO> mList = dao.memberList();
			if(mList.size() > 0) {
				for(TB_MEMBER_VO mvo  : mList) {
					System.out.printf(
							"아이디: %s, 비밀번호: %s, 이메일: %s \n",
							mvo.getM_userid(), mvo.getM_pwd(), mvo.getM_email()
					);
				}
			}else {
				System.out.println("회원 목록이 없습니다.");
			}
			
		}
		
		//회원 탈퇴
		System.out.println("회원을 탈퇴하시겠습니까? 1.예  2.아니오");
		int yn = sc.nextInt();
		if(yn == 1) {
			System.out.print("탈퇴할 아이디 입력>>");
			String mid = sc.next(); 
			
			System.out.print("탈퇴할 비밀번호 입력>>");
			String m_pwd = sc.next();
			int cnt = dao.notUse(mid, m_pwd);
			if(cnt > 0) System.out.println("회원 탈퇴가 되었습니다.");
			else System.out.println("탈퇴실패 \n사유: 입력하신 정보가 일치하지 않습니다. ");
		}
		
		
		
		
	}

}
