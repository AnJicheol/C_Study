
###### 문제 설명

함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.

##### 제한 조건

-   `n`은 1이상 8000000000 이하인 자연수입니다.

```java
import java.util.*;

class Solution {
  public long solution(long n) {
        String[] list = String.valueOf(n).split("");
        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        for (String aList : list) sb.append(aList);

        return Long.parseLong(sb.reverse().toString());
  }
}
```

```java
 V - 2 정수로만 처리

import java.util.Arrays;

class Solution {
    public long solution(long n) {
        int[] num = new int[(int)(Math.log10(n)+1)];
        long answer = 0;
        long  value = 1;

        for(int i = 0; i < num.length; i++){
            num[i] = (int)(n % 10);
            n = n / 10;
        }
        Arrays.sort(num);

        for(int Num : num){
            answer += Num * value;
            value   = value * 10;
        }
        return answer;
    }
}

```

~~~
김성민 피드백 

1번 같은 경우 함수 사용 많을 수록 주석이 더 필요하다고 생각한다.
~~~