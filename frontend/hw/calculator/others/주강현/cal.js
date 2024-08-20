
    var num = [];
    var firstNum = '';
    var b = 0;
    var dotuse = true;
    var cal = 0;
    var tf = true;
    
function calnum(a){
        if(tf){
        firstNum += a;
        if(firstNum.slice(0,2)=='00'){
            firstNum='';
            document.getElementById('number').innerHTML=0;
        }else{
        document.getElementById('number').innerHTML=firstNum;
            }
        }
        if(!tf){
            AC();
            firstNum += a;
            document.getElementById('number').innerHTML=firstNum;
            tf = true;
        }
        
    };

    
function calculator(c){
        if(firstNum != ''){
            num[b] = firstNum;
            b +=1;
            num[b] = c;
            b +=1;
            firstNum = '';
        }else{num[b-1]=c;}
        if(num[0]==undefined && c =='-'){
            firstNum += c;
            document.getElementById('number').innerHTML=firstNum;
        }
        dotuse=true;
        tf=true;
    };

    
function result(){
        num[b] = firstNum;
        let finalNum =0;
        // let arr = num.join('');
        if(firstNum !=''){
            cal = Number(num[0]);
            for(let i = 1;i<num.length-1;i++){
            switch(num[i]){
                case '+' : cal += (Number(num[i+1]));break;
                case '-' : cal -= (Number(num[i+1]));break;
                case '*' : cal *= (Number(num[i+1]));break;
                case '/' : cal /= (Number(num[i+1]));break;
                default :continue;
            }
            document.getElementById('number').innerHTML= Math.round(cal*100000)/100000;
        }
        
    }else{
        document.getElementById('number').innerText = '0'; 
    }
    tf = false;
};
    
function AC(){
        firstNum= '';
        b = 0;
        dotuse = true;
        num = [];
        cal = 0;
        // tf = true;
        document.getElementById('number').innerText = '0';
    };

    
function dot(){
       if(dotuse){
        if(firstNum==''){
            firstNum +='0.';
            document.getElementById('number').innerHTML=firstNum;
            dotuse = false;
        }else{
            firstNum += '.';
            document.getElementById('number').innerHTML=firstNum;
            dotuse = false;
        }
    }
};
//결과값은 못지웁니다 ㅠ 입력하던 숫자들만 지울수있습니다 ㅠ
function del(){
    firstNum = firstNum.slice(0,firstNum.length-1);
    document.getElementById('number').innerHTML=firstNum;
    if(firstNum=='')document.getElementById('number').innerHTML=0;
   
}

        
    
   