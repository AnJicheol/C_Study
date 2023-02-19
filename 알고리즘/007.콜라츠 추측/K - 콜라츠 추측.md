-   입력된 수, `num`은 1 이상 8,000,000 미만인 정수입니다.
~~~~
function solution(num) {
    var answer = 0;
    while(num != 1){
        answer++
        num = (num%2 == 0) ? num/2 : num*3+1
        if(answer == 500) return -1
    }
    return answer;
}
~~~~