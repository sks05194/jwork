
const screen = document.getElementById("calc-op-screen");
let op = undefined;
let firstValue = undefined;
let inputting = false;

// 초기화
function ac() {
    screen.innerText = 0;
    op = undefined;
    firstValue = undefined;
    inputting = false;
}

// 계산
function enter() {
    if (op == undefined) return;

    switch (op) {
        case '+': firstValue += Number(screen.innerText); break;
        case '-': firstValue -= Number(screen.innerText); break;
        case '*': firstValue *= Number(screen.innerText); break;
        case '/': firstValue /= Number(screen.innerText); break;
    }

    inputting = false;
    op = undefined;

    screen.innerText = firstValue;
}

// 반영: 버튼 클릭 시 호출되는 메소드
function reflect(value) {
    if (value == '.') {
        if (!screen.innerText.includes(value)) {
            screen.innerText += value;
            inputting = true;
        }
    }
    else if (isNaN(Number(value))) {
        if (op != undefined) {
            enter();
        }
        op = value;
        firstValue = Number(screen.innerText);
        inputting = false;
    }
    else {
        if (!inputting) {
            screen.innerText = value;
        }
        else {
            screen.innerText += value;
        }
        
        if (value != 0) {
            inputting = true;
        }
    }
}