package miniProject;

import java.sql.SQLException;

public class MiniProjectMain {
	public static void main(String[] args) {
		int menuNum = 0;
		StudentDAO studentDAO = new StudentDAO();

		while (true) {
			System.out.println("메뉴선택:  1.관리자  2.학생   3.시스템종료");
			menuNum = ConnManager.getScanner().nextInt();
			switch (menuNum) {

			case 1: // 관리자
				System.out.println("관리자 메뉴 시작");
				System.out.println("메뉴선택: 1. 관리자 로그인  2. 관리자 가입  3.홈으로");
				menuNum = ConnManager.getScanner().nextInt();

				switch (menuNum) {
				case 1: // 관리자 로그인

					// TODO 기능이 완료된다면 변경해주세요.
					AdminVO vo = null;

					while (true) {
						if (vo == null) {
							System.out.println("관리자가 아닙니다.");
							break;
						}

						// TODO 관리자가 하는 기능들.

						break;
					}
					break;

				case 2: // 관리자 가입

					// TODO 관리자 가입 기능.

					break;

//				case 3: // 홈으로
//					break;
//				default:
				}
				break; // 관리자 종료

			case 2: // 학생
				System.out.println("학생 메뉴 시작");
				System.out.println("메뉴선택: 1.로그인  2.회원가입  3.홈으로");
				menuNum = ConnManager.getScanner().nextInt();

				switch (menuNum) {
				case 1: // 로그인
					// TODO 로그인 기능
					// 이후 학생 VO로 조작하는 기능
					StudentVO student = studentDAO.loginStudent();
					if (student == null) {
						System.out.println("등록된 정보가 없거나 일치하지 않습니다.");
						break;
					}

					System.out.println(student.getSnm() + "님 환영합니다.");

					student: while (true) {
						System.out.println("학생 메뉴 선택: 1.시험응시 2.점수확인  3.로그아웃");
						menuNum = ConnManager.getScanner().nextInt();

						switch (menuNum) {
						case 1: // 시험응시
							try {
								studentDAO.Test(student);
							} catch (SQLException e) {
//								e.printStackTrace(); // 오류시 확인용
								System.out.println("오류가 발생하여 시험을 중단합니다.");
							}
							break;
						case 2: // 점수확인
							// TODO 점수확인 기능을 넣어주세요.
							break;
						case 3:
						default:
							break student;
						}
					}

					break;

				case 2: // 회원가입
					// TODO 회원가입 기능
					break;

//				case 3: // 홈으로
//					break;
//				default:
				}

				break; // 학생 종료

			case 3: // 종료
				System.out.println("시스템을 종료합니다.");
				return;

			default:
				// TODO 추후 프로그램을 보고 출력문을 변경해주시길 바랍니다.
				System.out.println("허용되지 않은 접근입니다.");
				break;
			}
		}
	}
}