###### 문제 설명

함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.

##### 제한 조건

-   `n`은 1이상 8000000000 이하인 자연수입니다.


```
JAVA

import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String num = String.valueOf(n);
        //System.out.println(num);
        
        char[] num2 = new char[num.length()];
        for(int i = 0; i < num2.length; i++){
            num2[i] = num.charAt(i);
        }
        
        Arrays.sort(num2);
        System.out.println(num2);
        num = "";
        for(int i = num2.length-1; i >= 0; i--){
            num += num2[i];
        }
        //System.out.println(num);
        
        answer = Long.parseLong(num);
        return answer;
    }
}
```

-----------------------------------------------------

```
안지철 피드백

1 ) split 함수를 사용하면 코드를 상당 수 줄일 수 있을 거 같다

	String[] list = String.valueOf(n).split("");

	char[] num2 = new char[num.length()];
	
	for(int i = 0; i < num2.length; i++){
	    num2[i] = num.charAt(i);
	}


2) 자바에서 문자열 + 는 성능이 너무 낮다 StringBuilder사용 권장

```