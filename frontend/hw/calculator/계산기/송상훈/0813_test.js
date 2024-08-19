class Calculator {
    constructor(displayElement) {
        this.displayElement = displayElement;
        this.displayContent = '';
        this.clear();
    }

    appendNumber(number) {
        this.displayContent += number;
    }

    appendOperator(operator) {
        this.displayContent += operator;
    }

    updateDisplay() {
        this.displayElement.value = this.formatNumber(this.displayContent);
    }

    clear() {
        this.displayContent = '';
        this.displayElement.value = 0;
    }

    compute() {
        try {
            this.displayContent = eval(this.displayContent
                .replace('\u00D7', '*')
                .replace('\u00F7', '/')
            ).toString();
        } catch (error) {
            this.displayContent = 'Error';
        }
        this.updateDisplay();
    }


    formatNumber(number) {
        if (isNaN(number)) return number;
        return parseFloat(number).toLocaleString('en');
    }
}

const buttons = document.querySelectorAll('button');
const displayElement = document.querySelector('input');
const calculator = new Calculator(displayElement);

buttons.forEach(button => {
    button.addEventListener('click', () => {
        switch (button.dataset.type) {
            case 'operator':
                calculator.appendOperator(button.innerText);
                calculator.updateDisplay();
                break;
            case 'ac':
                calculator.clear();
                break;
            case 'equals':
                calculator.compute();
                break;
            default:
                calculator.appendNumber(button.innerText);
                calculator.updateDisplay();
                break;
        }
    });
});
