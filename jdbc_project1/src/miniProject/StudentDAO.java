package miniProject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * 구현 완료 및 예정인 기능 목록
 * 
 * ○ 로그인 기능
 * △ 시험 기능
 * x 점수 확인 기능
 * 
 * */
public class StudentDAO {
	/** 로그인 관련 메세지 출력 및 관련 메소드 호출 */
	public StudentVO loginStudent() {
		System.out.println("학생 로그인 메뉴");

		System.out.print("아이디 입력");
		String sid = ConnManager.getScanner().next();

		// TODO 아이디 제약조건. 추후 보충하거나 메소드로 뺄 것.
		if (sid == null || sid.length() == 0) {
			System.out.println("아이디 입력 오류");
			return null;
		}

		System.out.print("비번 입력>>");
		String spw = ConnManager.getScanner().next();

		// TODO 비밀번호 제약조건. 추후 보충하거나 메소드로 뺄 것.
		if (spw == null || spw.length() == 0) {
			System.out.println("비밀번호 입력 오류");
			return null;
		}

		try {
			return loginStudent(sid, spw);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/** 로그인 기능 */
	private StudentVO loginStudent(String sid, String spw) throws SQLException {
		String sql = "SELECT * FROM student WHERE sid = ? AND spw = ?";

		PreparedStatement ps = ConnManager.getConnection().prepareStatement(sql);
		ps.setString(1, sid);
		ps.setString(2, spw);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			int sno = rs.getInt("sid");
			String snm = rs.getString("snm");
			String sdate = rs.getString("sdate");
			// TODO sdate에서 오류난다면 Date형 컬럼을 받아오는 과정에서 생긴 오류일 확률이 높습니다.
			// 오류가 발생한다면 쿼리문에서 컬럼을 받아오는 줄을 변경하거나 자료형을 변경해주세요.
			boolean slms = rs.getString("slms") == "Y";

			rs.close();
			ps.close();
			return new StudentVO(sno, snm, sid, spw, sdate, slms);
		} else
			return null;
	}

	/**
	 * 학생 시험
	 * 
	 * @throws main 함수 실행 중 이 메소드에서 오류 발생 시 catch문에서 시험 중단이라고 알려줄거에요.
	 */
	public void Test(StudentVO student) throws SQLException {
		System.out.println("시험응시 시작");
		System.out.println("2024년 1학기 JAVA 초급 시험시작"); // 이후 변경 예정

		// 이미 응시한 시험은 다시 보실 수 없습니다. 나가세요.
		if (!checkTestPoint(student)) {
			System.out.println("응시한 시험입니다.");
			return;
		}

		// TODO 일시적으로 2024년 1학기로 설정하였습니다.
		// 추후 년도나 학기는 변경해주세요.
		ArrayList<TestVO> testList = testList(2024, 1); // 2024년도 1학기 시험 문제 리스트
		int[] correctArr = new int[testList.size()]; // 문제에 따른 답을 담는 배열

		// 문제 풀기
		// TODO 이 부분 메소드로 만들지 고민해볼것.
		for (int testNo = 0; testNo < testList.size(); testNo++) {
			// 문제 출력
			int no = testList.get(testNo).getTn();
			String question = testList.get(testNo).getTq();

			System.out.println(no + question);

			// 문제 번호에 따라 점수 correctArr에 반영
			System.out.print("답안 입력(번호로 입력해주세요)>> ");
			correctArr[testNo] = ConnManager.getScanner().nextInt();
		}

		// TODO 문제 번호 변경하고 싶은 경우 (미구현)
		

		// 시험 점수 테이블에 반영하는 메소드 호출 예정
		for (int testNo = 0; testNo < testList.size(); testNo++) {
			reflecting(student.getSno(), testList.get(testNo), correctArr[testNo]);
		}
	}

	/** 시험을 치뤘는지 확인하는 메소드 */
	private boolean checkTestPoint(StudentVO student) throws SQLException {
		String sql = "Select * FROM answer WHERE sno = ? AND ty = ? AND ts = ?";

		PreparedStatement ps = ConnManager.getConnection().prepareStatement(sql);
		ps.setString(1, student.getSid());
		ps.setInt(2, 2024); // 추후 변경 가능성 높음

		ResultSet rs = ps.executeQuery();

		if (rs.next())
			return true;

		rs.close();
		return false;
	}

	/**
	 * 년도, 학기별 시험 문제 리스트를 반환하는 메소드
	 * 
	 * @param ty 시험년도
	 * @param ts 시험학기
	 */
	private ArrayList<TestVO> testList(int ty, int ts) throws SQLException {
		ArrayList<TestVO> list = new ArrayList<>();

		String sql = "SELECT * FROM test WHERE ty = ? AND ts = ?";

		PreparedStatement ps = ConnManager.getConnection().prepareStatement(sql);
		ps.setInt(1, ty);
		ps.setInt(2, ts);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			int tn = rs.getInt("tn");
			String tq = rs.getString("tq");
			int ta = rs.getInt("ta");

			list.add(new TestVO(ty, ts, tn, tq, ta));
		}

		rs.close();
		ps.close();
		return list;
	}

	/**
	 * 점수를 sql 쿼리문을 사용하여 반영합니다.
	 * 
	 * @param sno  학번
	 * @param test 본 시험 정보
	 * @param ans  정답여부
	 */
	private void reflecting(int sno, TestVO test, int ans) throws SQLException {
		String sql = "INSERT INTO answer VALUES ( ?, ?, ?, ?, ? )";

		PreparedStatement ps = ConnManager.getConnection().prepareStatement(sql);
		ps.setInt(1, sno);
		ps.setInt(2, test.getTy());
		ps.setInt(3, test.getTs());
		ps.setInt(4, test.getTn());
		ps.setString(5, test.getTa() == ans ? "O" : "X");
		
		int rowCount = ps.executeUpdate();
		
		ps.close();
		// 여기 아래는 확인 후 지워줘요.
		if(rowCount > 0) System.out.println("반영완료");
	}
}