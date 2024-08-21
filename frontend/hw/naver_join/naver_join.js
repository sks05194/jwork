// 필수 정보 미입력 후 blur시 붉게 변함.
$(".essential").on("blur", function () {
	// TODO: id, pw, name, birth, phone, 약관 태그에 클래스 붙이기
	// TODO: 일단 틀만 잡고 나중에 하기
});

// 이메일 형식 오류 후 도주 시 반드시 죽여버리겠다는 무언의 압박
// 참고로 비밀번호에 따라 안전 여부도 하는데 그건 생략할래요.
$(".div_i > input[password]").on("blur", function () {
	// TODO: 미래의 나야, 힘내!
});

// TODO: 생년월일 blur시 형식 확인 후
// 살릴지 죽일까 생각할지 생각하겠다는 코드 작성 예정

// 통신사 선택 버?튼 클릭 시 테이블 활성화/비활성화
$("#uagency").on("click", function () {
	if ($("#uagency_div").is(':visible')) {
		$("#uagency_div").hide();
		$(this).css("border", "");
	} else {
		$("#uagency_div").show();
		$(this).css("border", "1px solid green");
	}
});

// TODO: 여기에 jquery문을 사용해서 통신사 선택 시
// label의 border에 영행이 가도록 코드를 작성해주세요.

// 성별, 국적 input:radio에 따라 label의 border 변경
$("#rd_gr_div > .radio_group > input[type=radio]").on("change", function () {
	// TODO: 졸리다. 위에 설명대로 잘 하세요.
});

// TODO: 휴대전화번호 blur시 형식 변환
// 형식 확인 먼저 하고 바꿔줄지 죽일지 선택.
// 아마 split(쪼개기)과 join(이어붙이기)을 사용하면 될거같다.
// 예: 01012345678 -> 010-1234-5678