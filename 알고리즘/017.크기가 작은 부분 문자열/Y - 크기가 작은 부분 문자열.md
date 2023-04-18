
# [바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/147355)

###### 문제 설명

숫자로 이루어진 문자열 `t`와 `p`가 주어질 때, `t`에서 `p`와 길이가 같은 부분문자열 중에서, 이 부분문자열이 나타내는 수가 `p`가 나타내는 수보다 작거나 같은 것이 나오는 횟수를 return하는 함수 solution을 완성하세요.

예를 들어, `t`="3141592"이고 `p`="271" 인 경우, `t`의 길이가 3인 부분 문자열은 314, 141, 415, 159, 592입니다. 이 문자열이 나타내는 수 중 271보다 작거나 같은 수는 141, 159 2개 입니다.

---

##### 제한사항

-   1 ≤ `p`의 길이 ≤ 18
-   `p`의 길이 ≤ `t`의 길이 ≤ 10,000
-   `t`와 `p`는 숫자로만 이루어진 문자열이며, 0으로 시작하지 않습니다.

```java
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        Long num;
        
        for(int i = 0; i < t.length() - p.length()+1 ; i++){
            num = Long.parseLong(t.substring(i,i+p.length()));
            //System.out.println(num);
            if(num <= Long.parseLong(p)){answer++;}
            //System.out.println(t.substring(i,i+p.length()));
        }
        
        return answer;
    }
}
```



# 피드백

----------------------------------------------------

안지철 - > 형변환은 성능에 악역향을 끼친다 실제로 comapre 를 활용한 알고리즘과 비교하면 성능면에서  유의미한 차이를 보인다 


```java

Y 코드 성능                                         T 코드 성능

테스트 1 〉통과 (3.38ms, 77.5MB)                    테스트 1 〉통과 (0.81ms, 79.6MB)

테스트 2 〉통과 (5.23ms, 75.1MB)                    테스트 2 〉통과 (1.30ms, 76.5MB)

테스트 3 〉통과 (3.35ms, 76.3MB)                    테스트 3 〉통과 (1.49ms, 80.6MB)

테스트 4 〉통과 (3.68ms, 81.1MB)                    테스트 4 〉통과 (0.84ms, 71.5MB)

테스트 5 〉통과 (3.63ms, 76.3MB)                    테스트 5 〉통과 (0.56ms, 77.3MB)





형변환을 사용하지 않고 구현하는 코드는 다음과 같다


String num = t.substring(i, i + p_len);
if(num.compareTo(p) <= 0 )answer++;


```