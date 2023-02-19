-   a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
-   a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
-   a와 b의 대소관계는 정해져있지 않습니다.
~~~~
function solution(a, b) {
    var answer = 0;
    
    if(a<b){
        for(var i=a; i<=b;i++){
            answer += i
        }
    }
    if(b<=a){
        for(var i=b; i<=a;i++){
            answer += i
        }
    }
    
    return answer;
}
~~~~