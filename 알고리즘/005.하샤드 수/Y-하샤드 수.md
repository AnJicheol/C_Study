```
class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int num1 = x;
        int num2 = 0;
        
        for(int i = 0; num1>0; i++){
            num2 += num1%10;
            num1 = num1 /10;
        }
        
        if(x % num2 == 0){answer = true;}
        else{answer = false;}
        //System.out.println(num);
        
        return answer;
    }
}
```
##### 제한 조건
-   `x`는 1 이상, 10000 이하인 정수입니다.