 -   n은 1이상, 50000000000000 이하인 양의 정수입니다.
~~~~
JS

function solution(n) {
    var answer = 0;

    answer = Math.sqrt(n)
    if(Number.isInteger(answer) == true){
        answer += 1
        answer *= answer
    }
    else{
        answer = -1
    }


    return answer;
}
~~~~~
