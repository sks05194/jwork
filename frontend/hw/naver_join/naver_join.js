// 네이버 회원가입 주소: 다음 누르면 나오는 폼을 재현하시오.
// https://nid.naver.com/user2/join/agree

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
	} else {
		$("#uagency_div").show();
	}
});

// 통신사를 선택할 경우
$("#uagency_div td").click(e => {
	let curTd = e.target;
	let valAgency = $(curTd).children('label').text();

	$(curTd).children('input').attr('checked', true);
	$("#uagency").text(valAgency);
	$("#uagency_div").hide();
	jud_agency($('#uagency'), true);
});

// 성별 선택 시
$('input[name="ugender"]+label').click(e => {
	jud_ugender(true);
});

// 인증요청 버튼을 눌렀을 경우 발생하는 이벤트
document.getElementById("join_form").addEventListener('submit', (event) => {
	let canMove = true;

	$(".essential").each((i, e) => {
		if (!blurFuncs[$(e).attr('name')]()) {
			canMove = false;
		}
	});

	// 통신사 확인
	let hasagencyValue = $('input[name="uagency"]:checked').val() == undefined;
	if (hasagencyValue) canMove = false;
	jud_agency(!hasagencyValue);

	// 성별 확인
	let hasGenderValue = $('input[name="ugender"]:checked').val() == undefined;
	if (hasGenderValue) canMove = false;
	jud_ugender(!hasGenderValue);

	if (!canMove) {
		event.preventDefault();
	}
});

// 필수요소 등을 확인 후 테두리 등에 영향
function judgment(e, b) {
	let name = $(e).attr('name');
	if (b) {
		$(e).parent().css('border', '');
		$(e).css('color', 'black');
		$(e).css('text-decoration', 'none');
		$("#" + name + "-warning").hide();
	} else {
		$(e).parent().css('border', '2px solid red');
		$(e).addClass("redplaceholder");
		$(e).css('color', 'red');
		$(e).css('text-decoration', 'underline');
		$("#" + name + "-warning").show();
	}
}

// 통신사 확인시 테두리 등에 영향
function jud_agency(b) {
	let e = document.getElementById("uagency");

	if (b) {
		$(e).css('border', '');
		$(e).css('color', 'black');
		$(e).css('text-decoration', 'none');
		$("#uagency-warning").hide();
	} else {
		$(e).css('border', '2px solid red');
		$(e).css('color', 'red');
		$(e).css('text-decoration', 'underline');
		$("#uagency-warning").show();
	}
}

// 성별 확인시 테두리 등에 영향
function jud_ugender(b) {
	let label = $('input[name="ugender"]+label');
	let parent = $($($('input[name="ugender"]').parent()[0]).parent());

	if (b) {
		parent.css('border', '');
		label.css('border', '');
		label.css('color', 'black');
		label.css('text-decoration', 'none');
		$("#ugender-warning").hide();
	} else {
		parent.css('border', '2px solid red');
		label.css('border', '2px solid red');
		label.css('color', 'red');
		label.css('text-decoration', 'underline');
		$("#ugender-warning").show();
	}
}

// submit 클릭 시 활용하기 위한 메소드를 담는 배열 객체
var blurFuncs = [];

// 유효성 검사 선언 및 blur 이벤트에 할당
$(".essential").each((i, e) => {
	let name = $(e).attr('name');
	let validFunc = undefined;
	let reg = undefined;

	switch (name) {
		case 'uid':
			reg = /^(\w){5,20}$/;

			validFunc = function () {
				// 유효성 검사
				if (!reg.test($(e).val())) {
					judgment(e, false);

					$("#" + name + "-warning").text(($(e).val() == "")
						? "아이디: 필수 정보입니다."
						: "아이디: 5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
					return false;
				}

				judgment(e, true);
				return true;
			};
			break;

		case 'upass':
			reg = /^(\w|\W){8,16}$/;

			validFunc = function () {
				if (reg.test($(e).val())) {
					judgment(e, true);
					return true;
				} else {
					judgment(e, false);

					$("#" + name + "-warning").text(($(e).val() == "")
						? "비밀번호: 필수 정보입니다."
						: "비밀번호: 8~16자의 영문 대/소문자, 숫자, 특수문자를 사용해 주세요.");
					return false;
				}
			};
			break;

		case 'uemail':
			reg = /^[a-zA-Z0-9._-]+@[a-zA-Z]{3,20}[.][a-zA-Z]{1,20}([.][a-zA-Z])*$/;

			validFunc = function () {
				if ((reg.test($(e).val())) || ($(e).val() == "")) {
					judgment(e, true);
					return true;
				} else {
					judgment(e, false);
					return false;
				}
			};
			break;

		case 'uname':
			validFunc = function () {
				if ($(e).val() == "") {
					judgment(e, false);
					return false;
				}

				judgment(e, true);
				return true;
			};
			break;

		case 'ubirth':
			reg = /^\d{8}$/;

			validFunc = function () {
				let value = $(e).val().split('.').join('');

				if (Number(value) == NaN || !reg.test($(e).val())) {
					judgment(e, false);
					$("#" + name + "-children").hide();

					$("#" + name + "-warning").text(($(e).val() == "")
						? "생년월일: 필수 정보입니다."
						: "생년월일: 생년월일은 8자리 숫자로 입력해 주세요.");
					return false;
				}

				judgment(e, true);

				let dotTypeDateStr = value.slice(0, 4) + '.' + value.slice(4, 6) + '.' + value.slice(6);

				let inputDate = new Date(dotTypeDateStr);
				let today = new Date();

				let todayStr = "" + today.getFullYear() + String(today.getMonth() + 1).padStart(2, '0') + String(today.getDate()).padStart(2, '0');

				if (Number(value) < Number(todayStr) - 1000000 || Number(value) > Number(todayStr)) {
					$(e).parent().css('border', '2px solid red');
					$(e).addClass("redplaceholder");
					$("#" + name + "-warning").show();
					$("#" + name + "-warning").text("생년월일: 생년월일이 정확한지 확인해 주세요.");
					return false;
				}

				$(e).val(dotTypeDateStr);
				$(e).parent().css('border', '');

				today = new Date();
				if (inputDate > today.setFullYear(today.getFullYear() - 14)) {
					$("#" + name + "-children").show();
				} else {
					$("#" + name + "-children").hide();
				}
				return true;
			};
			break;

		case 'uphone':
			reg = /^(010)\d{8}$/; // 010 이외의 번호는 생략.

			validFunc = function () {
				let value = $(e).val().split('-').join('');

				// 유효성 검사
				if (!reg.test(value)) {
					judgment(e, false);

					$("#" + name + "-warning").text(($(e).val() == "")
						? "휴대전화번호: 필수 정보입니다."
						: "휴대전화번호: 휴대전화번호가 정확한지 확인해 주세요.");
					return false;
				}

				let dashTypePhoneStr = value.slice(0, 3) + '-' + value.slice(3, 7) + '-' + value.slice(7);
				$(e).val(dashTypePhoneStr);

				judgment(e, true);
				return true;
			};
			break;
	}
	blurFuncs[name] = validFunc;
	e.addEventListener('blur', validFunc);
});