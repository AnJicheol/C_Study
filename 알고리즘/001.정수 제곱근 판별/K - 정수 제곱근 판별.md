###### 문제 설명

임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.  
n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.

##### 제한 사항

-   n은 1이상, 50000000000000 이하인 양의 정수입니다.

~~~~ Js
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
~~~~

-----------------------------------------------------

~~~~
JS

T - 분기문을 줄일 수 있을 거 같다 하지만 else 나쁘다는 것은 아님.

ex)
function solution(n) {
    var answer = 0;

    answer = Math.sqrt(n)
    if(Number.isInteger(answer) == true){
        answer += 1
        return answer *= answer
    }
    
    return answer = -1
    
}
~~~~~

