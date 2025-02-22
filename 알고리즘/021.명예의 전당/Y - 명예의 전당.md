## [바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/138477)

###### 문제 설명

"명예의 전당"이라는 TV 프로그램에서는 매일 1명의 가수가 노래를 부르고, 시청자들의 문자 투표수로 가수에게 점수를 부여합니다. 매일 출연한 가수의 점수가 지금까지 출연 가수들의 점수 중 상위 k번째 이내이면 해당 가수의 점수를 명예의 전당이라는 목록에 올려 기념합니다. 즉 프로그램 시작 이후 초기에 k일까지는 모든 출연 가수의 점수가 명예의 전당에 오르게 됩니다. k일 다음부터는 출연 가수의 점수가 기존의 명예의 전당 목록의 k번째 순위의 가수 점수보다 더 높으면, 출연 가수의 점수가 명예의 전당에 오르게 되고 기존의 k번째 순위의 점수는 명예의 전당에서 내려오게 됩니다.

이 프로그램에서는 매일 "명예의 전당"의 최하위 점수를 발표합니다. 예를 들어, `k` = 3이고, 7일 동안 진행된 가수의 점수가 [10, 100, 20, 150, 1, 100, 200]이라면, 명예의 전당에서 발표된 점수는 아래의 그림과 같이 [10, 10, 10, 20, 20, 100, 100]입니다.

![그림1.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/b0893853-7471-47c0-b7e5-1e8b46002810/%EA%B7%B8%EB%A6%BC1.png)

명예의 전당 목록의 점수의 개수 `k`, 1일부터 마지막 날까지 출연한 가수들의 점수인 `score`가 주어졌을 때, 매일 발표된 명예의 전당의 최하위 점수를 return하는 solution 함수를 완성해주세요.

##### 제한사항

-   3 ≤ `k` ≤ 100
-   7 ≤ `score`의 길이 ≤ 1,000
    -   0 ≤ `score[i]` ≤ 2,000



```
import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        LinkedList<Integer> box = new LinkedList<Integer>();
        boolean count = true;
        answer[0] = score[0];
        box.add(score[0]);
		
		
        for(int i = 1; i < score.length; i++){
            if(score[i] >= box.get(0)){ 
                for(int j = 0; j < box.size(); j++){ // 정렬
                    if(score[i] < box.get(j)){
                        box.add(j,score[i]);
                        count = false;
                        break;
                    }
                }
                if(count){box.add(score[i]);}
                count = true;
                
                if(i < k){answer[i] = box.get(0);}
                else{box.remove(0); answer[i] = box.get(0);}
            }
            else{
                if(i < k){box.add(0,score[i]); answer[i] = box.get(0);}
                else{answer[i] = box.get(0);}
            }
        }
        
        
        return answer;
    }
}

```




# 평가

--------------------------------------------------------------

안지철 - > 처음에 코드를 가볍게 살펴봤을 때는 LinkedList로 코드가 매우 비효율 적일 것이라고 생각했다
이유는 밑에 코드가 매우 비효율적일 것이라고 생각했기 때문이다 LinkedList에 get은 Log(n)에 시간 복잡도를
갖는다 따라서 배열이나 ArrayList보다 느릴 것이다 라고 생각하기 쉽지만 사실 해당 로직은 결과적으로 contains이기때문에 배열 또한 Log(n)을 갖는다 따라서 add() 와 remove() 에 시간복잡도가 Log(1)인 LinkedList 특징을 생각한다면 충분히 좋은 코드라고 생각한다

```java

for(int j = 0; j < box.size(); j++){ // 정렬
    if(score[i] < box.get(j)){
        box.add(j,score[i]);
        count = false;
        break;
    }
}

```

