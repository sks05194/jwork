/* 폐기
// 필수 정보 미입력 후 blur시 붉게 변함.
$(".essential").on("blur", function () {
	// TODO: id, pw, name, birth, phone, 약관 태그에 클래스 붙이기
	// TODO: 일단 틀만 잡고 나중에 하기
});
*/

// 이메일 형식 오류 후 도주 시 반드시 죽여버리겠다는 무언의 압박
// 참고로 비밀번호에 따라 안전 여부도 하는데 그건 생략할래요.
$(".div_i > input[password]").on("blur", function () {
	// TODO: 미래의 나야, 힘내!
});

// div 클릭하면 input 요소를 focus
$(".div_i").click(e => {
	$(e.target).children('input').focus();
});

// 버튼 클릭 시 비밀번호 공개/비공개
$("#pw_visible").click(e => {
	let pwInput = $("input[name=upass]");

	if (pwInput.attr('type') == "password") pwInput.attr('type', 'text');
	else pwInput.attr('type', 'password');
});

// 통신사 선택 클릭 시 테이블 활성화/비활성화
$("#uagency").on("click", function () {
	if ($("#uagency_div").is(':visible')) {
		$("#uagency_div").hide();
		$(this).css("border", "");
	} else {
		$("#uagency_div").show();
		$(this).css("border", "1px solid green");
	}
});

// TODO: 통신사 선택 시 주는 영향에 대해 서술하시오.(3점)
$("#uagency_div td").click(e => {
	let curTd = e.target;
	let valAgency = $(curTd).children('label').text();

	$(curTd).children('input').attr('checked', true);
	$("#uagency").text(valAgency);
	$("#uagency_div").hide();
});

// TODO: 휴대전화번호 blur시 형식 변환
// 형식 확인 먼저 하고 바꿔줄지 죽일지 선택.
// 아마 split(쪼개기)과 join(이어붙이기)을 사용하면 될거같다.
// 예: 01012345678 -> 010-1234-5678


// 필수 정보 미입력 후 blur시 테두리가 붉게 변함.
// 길어질거 같아서 아래로 뺌
$(".essential").each((i, e) => {
	let name = $(e).attr('name');

	let validFunc = undefined;

	switch (name) {
		case 'uid':
			validFunc = function () {
				// 유효성 검사
				if (/* 대충 유효성 검사하는 코드 */true) {
					// 테두리 붉어지게 만들어주는 마법의 코드
					$(e).parent().css('border', '2px solid red');

					$("#" + name + "-warning").show();
				} else {
					// TODO: 정상화
					$(e).parent().css('border', '2px solid green');
					$("#" + name + "-warning").hide();
				}
			};
			break;
		case 'upass':
			validFunc = function () {
				// 유효성 검사
			};
			break;
		case 'uname':
			validFunc = function () {
				// 유효성 검사
				// TODO: 조건에 맞을 경우 형식 바꿔주는 코드
			};
			break;
		case 'ubirth':
			validFunc = function () {
				// 유효성 검사
			};
			break;
		case 'uphone':
			validFunc = function () {
				// 유효성 검사
			};
			break;
	}
	e.addEventListener('blur', validFunc);
});