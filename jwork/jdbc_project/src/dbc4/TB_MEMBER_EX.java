package dbc4;

import java.util.ArrayList;
import java.util.Scanner;

public class TB_MEMBER_EX {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TB_MEMBER_DAO dao = new TB_MEMBER_DAO();

		// 회원가입
		while (true) {
			System.out.println("회원가입 시작");
			System.out.println("아이디입력>>");
			String mid = sc.next();

			System.out.println("비밀번호 입력>>");
			String mpw = sc.next();

			System.out.println("이메일 입력 선택 1.예 2.아니오");
			int yn = sc.nextInt();
			String mml = null;
			if (yn == 1) {
				System.out.println("이메일 입력>>");
				mml = sc.next();
			}

			System.out.println("핸드폰번호 입력 선택 1.예 2.아니오");
			yn = sc.nextInt();
			String mph = null;
			if (yn == 1) {
				System.out.println("전화번호 입력>>");
				mph = sc.next();
			}

			if (mid == null || mid.equals("") || mpw == null || mpw.equals("")) {
				continue;
			} else {
				int cnt = dao.join(mid, mpw, mml, mph);
				if (cnt > 0) {
					System.out.println("회원가입 성공");
				} else {
					System.out.println("회원가입 실패");
				}
				break;
			}
		}

		boolean tf = false;
		// 로그인
		while (true) {
			System.out.println("로그인메뉴");
			System.out.println("아이디 입력>> ");
			String id = sc.next();

			System.out.println("비밀번호 입력>> ");
			String pw = sc.next();

			TB_MEMBER_VO vo = dao.login(id, pw);

			if (vo != null) {
				System.out.println("로그인 성공");
				tf = true;
				break;
			} else {
				System.out.println("정보가 일치하는 회원이 없습니다.");
			}
		}
		// 전체회원 목록 조회
		System.out.println("전체회원 목록 조회");
		if (tf) {
			ArrayList<TB_MEMBER_VO> mList = dao.memberList();
			if (mList.size() > 0) {
				for (TB_MEMBER_VO mvo : mList) {
					System.out.printf("아이디: %s, 비밀번호: %s, 이메일: %s \n", mvo.getM_userid(), mvo.getM_pwd(),
							mvo.getM_email());
				}
			} else {
				System.out.println("회원 목록이 없습니다.");
			}
		}

		// 회원 탈퇴
		System.out.println("회원을 탈퇴하시겠습니까? 1.예 2.아니오");
		int yn = sc.nextInt();
		if (yn == 1) {
			System.out.println("탈퇴할 아이디 입력>>");
			String m_userid = sc.next();

			System.out.println("탈퇴할 비밀번호입력>>");
			String m_pwd = sc.next();
			int cnt = dao.notUse(m_userid, m_pwd);
			if (cnt > 0)
				System.out.println("회원 탈퇴가 되었습니다.");
			else
				System.out.println("탈퇴실패 \n 사유 : 아이디 또는 비밀번호가 일치하지 않습니다.");
		}

		sc.close();
	}
}
