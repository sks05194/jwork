var styleSheet = document.createElement("link");
styleSheet.setAttribute("rel", "styleSheet");
styleSheet.setAttribute("href", document.currentScript.src.replace("js", "css"));
document.head.appendChild(styleSheet);

// 클릭 이벤트 리스너 추가
document.addEventListener('mousedown', function (event) {
	// 클릭한 위치에 효과를 추가할 요소 생성
	const effect = document.createElement('div');

	if (event.button === 0) {
		effect.className = 'click-effect-left';
	} else if (event.button === 1) {
		effect.className = 'click-effect-middle';
	} else {
		effect.className = 'click-effect-right';
	}

	// 클릭한 위치에 요소 위치 지정
	effect.style.left = `${event.pageX - 10}px`;
	effect.style.top = `${event.pageY - 10}px`;

	// 문서에 효과 요소 추가
	document.body.appendChild(effect);

	// 애니메이션이 끝난 후 효과 요소 제거
	effect.addEventListener('animationend', function () {
		effect.remove();
	});
});

// 기본적인 오른쪽 클릭 메뉴를 비활성화
document.addEventListener('contextmenu', function (event) {
	event.preventDefault(); // 오른쪽 클릭 메뉴가 나타나지 않도록 방지
});