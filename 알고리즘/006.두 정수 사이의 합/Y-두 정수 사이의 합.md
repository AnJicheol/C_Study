```
class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int swap = 0;
        
        if(a > b){
            swap = b;
            b = a;
            a = swap;
        }
        else if(a==b){return a;}
        
        for(int i = a; i <= b; i++){
            answer += i;
        }
        return answer;
    }
}
```
##### 제한 조건
-   a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
-   a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
-   a와 b의 대소관계는 정해져있지 않습니다.