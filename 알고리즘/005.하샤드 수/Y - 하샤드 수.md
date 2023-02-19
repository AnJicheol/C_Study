###### 문제 설명

양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.

##### 제한 조건

-   `x`는 1 이상, 10000 이하인 정수입니다.

```
class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int num1 = x;
        int num2 = 0;
        
        for(int i = 0; num1>0; i++){
            num2 += num1 % 10;
            num1 = num1 / 10;
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
------------------------------------------------

```
안지철 피드백 

1) 조건문을 줄일 수 있을 거 같다

 -- > return (x % sum == 0);

 if(x % num2 == 0){answer = true;}
 else{answer = false;}      
 return answer;


```