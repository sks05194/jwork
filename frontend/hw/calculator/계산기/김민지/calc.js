const displayElement =document.getElementById('display');
    let inputs = [];

    function updateDisplay() {
    let displayValue = inputs.join('');
    if (displayValue === '') {
        displayValue = '0'; // 입력이 없으면 0을 표시
    }
    displayElement.textContent = displayValue;
    }

    function appendNumber(number) {
        inputs.push(number);
        updateDisplay();
    }

    function appendOperator(operator){
        if(['+','-','*','/'].includes(inputs[inputs.length-1])){
            inputs.pop(); //마지막 입력이 연산자면 교체
        }
        inputs.push(operator);
        updateDisplay();
    }

    function calculate() {
        if(inputs.length>0){
            const result = eval(inputs.join('')); //입력된 식 계산
            inputs=[result];
            updateDisplay();
        }
    }

    function clearDisplay(){
        inputs=[];
        updateDisplay();
    }