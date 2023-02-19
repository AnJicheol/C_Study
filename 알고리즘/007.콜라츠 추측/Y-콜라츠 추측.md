```
class Solution {
    public int solution(int num) {
        int answer = 0;
        long num2 = (long)num;
        
        if(num2 == 1){return 0;}
        
        for(int i = 0; num2 > 1; i++){
            if(num2%2 == 0){num2 = num2 / 2;}
            else{num2 = num2 * 3 + 1;}
            answer++;
            
            if(answer >=500){return -1;}
        }
        
        return answer;
    }
}
```
##### 제한 사항
-   입력된 수, `num`은 1 이상 8,000,000 미만인 정수입니다.