function selTr(val) {
	location.href = "getBoard.do?seq=" + val;
}

$(document).ready(function () {
	$(window).resize(function () {
		var windowWidth = $(window).width();
		if (windowWidth >= 978) {
			$("#subNavMenu").hide();
		}
	});

	$("#clMenu").click(function () {
		$("#subNavMenu").toggle();
	});

	$("#conWrite").click(function () {
		location.href = "insertBoard.jsp";
	});

	$("#conDel").click(function () {
		if (confirm("정말 삭제하시겠습니까?")) {
			let v = document.fm.seq.value;
			location.href = "deleteBoard.do?seq=" + v;
		} else {

		}
	});

	$("#conList").click(function () {
		location.href = "getBoardList.do";
	});
});

function selUser(val) {
	location.href = "selUser.do?id=" + val;
}

function delUser(val, url, msg) {
	if (val == 'admin') {
		alert(msg);
	} else {
		if (confirm("정말로 삭제하시겠습니까?")) {
			let password = prompt("비밀번호를 입력해주세요.");
			if (password != null) {
				location.href = url + "?id=" + val + "&password=" + password;
			} else return;
		}
		else return;
	}
}

function chk() {
	if ($("#id").val() == 'admin' && $("#role").val() != 'Admin') {
		alert('관리자는 역할을 변경하실 수 없습니다.');
		return false;
	} else {
		return true;
	}
}