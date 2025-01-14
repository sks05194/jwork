$(document).ready(function(){ 
	$( window ).resize(function() {
		var windowWidth = $( window ).width();
		if(windowWidth >= 978) {
			$("#subNavMenu").hide();
		}
	});
	
	$("#clMenu").click(function(){
		$("#subNavMenu").toggle();
	});
	
	$("#conWrite").click(function(){
		location.href = "/insertBoard.do";
	});
	
	$("#conDel").click(function(){
		let con_test = confirm("정말로 삭제하시겠습니까?");
		if(con_test == true){
			let s = document.fm.seq.value;
			let w = document.fm.writer.value;
			location.href = "/deleteBoard.do?seq="+s+"&writer="+w;
		}
		else if(con_test == false){
		  	return false;
		}
	});
	
	
	/* 241017_추가 페이징처리와 목록, 검색 유지 기능 처리*/
	$("#conList").click(function(){
		document.hideFrm.action="/getBoardList.do";
		document.hideFrm.method="post";
		document.hideFrm.submit();
	});
});

/* 241017_추가 페이징처리와 목록, 검색 유지 기능 처리*/
function selTr(val, val2, val3, nowpage){
	location.href = "/getBoard.do?seq="+val+'&searchCondition='+val2+'&searchKeyword='+val3+'&nowPage='+nowpage;
}

function selUser(val){
	location.href = "/selUser.do?id="+val;
}

function delUser(val, url, msg){
	if(val == 'admin'){
		alert(msg);
	}else{
		if(confirm("정말로 탈퇴하시겠습니까?")) location.href=url+"?id="+val;
		else return;
	}
}

function chk(){
	if($("#id").val() == 'admin' && $("#role").val() =='User'){
		alert('관리자는 역할을 변경하실 수 없습니다.');
		return false;
	}else{
		return true;
	}
}
