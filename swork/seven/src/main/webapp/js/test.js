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