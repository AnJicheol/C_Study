


## [바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/67256)


###### 문제 설명

스마트폰 전화 키패드의 각 칸에 다음과 같이 숫자들이 적혀 있습니다.

![kakao_phone1.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/4b69a271-5f4a-4bf4-9ebf-6ebed5a02d8d/kakao_phone1.png)

이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.  
맨 처음 왼손 엄지손가락은 `*` 키패드에 오른손 엄지손가락은 `#` 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.

1.  엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
2.  왼쪽 열의 3개의 숫자 `1`, `4`, `7`을 입력할 때는 왼손 엄지손가락을 사용합니다.
3.  오른쪽 열의 3개의 숫자 `3`, `6`, `9`를 입력할 때는 오른손 엄지손가락을 사용합니다.
4.  가운데 열의 4개의 숫자 `2`, `5`, `8`, `0`을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.  
    4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.

순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.

##### **[제한사항]**

-   numbers 배열의 크기는 1 이상 1,000 이하입니다.
-   numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
-   hand는 `"left"` 또는 `"right"` 입니다.
    -   `"left"`는 왼손잡이, `"right"`는 오른손잡이를 의미합니다.
-   왼손 엄지손가락을 사용한 경우는 `L`, 오른손 엄지손가락을 사용한 경우는 `R`을 순서대로 이어붙여 문자열 형태로 return 해주세요.

```java
import java.util.*;
import java.util.Arrays;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuffer answer = new StringBuffer();
        int[] L_keypad = {3,0};
        int[] R_keypad = {3,2};
        int[] M_keypad = {3,1};
        int num = 0;
        
        for(int i = 0; i < numbers.length;i++){
            num = numbers[i]-1;
            // System.out.println(num);
            if(numbers[i] % 3 == 1){ // 1,4,7일 경우
                answer.append("L");
                L_keypad[0] = num/3;
                L_keypad[1] = num%3;
            }
            else if(numbers[i] != 0 && numbers[i] % 3 == 0){ // 0을 제외한 3,6,9일 경우
                answer.append("R");
                R_keypad[0] = num/3;
                R_keypad[1] = num%3;
            }
            else {
                // 0일 경우
                if(numbers[i] == 0){ M_keypad[0] = 3; M_keypad[1] = 1; }
                else{ // 2,5,8일 경우
                    M_keypad[0] = num/3;
                    M_keypad[1] = num%3;
                }
                // 거리계산
                int L_num = Math.abs(L_keypad[0] - M_keypad[0]) + Math.abs(L_keypad[1] - M_keypad[1]);
                int R_num = Math.abs(R_keypad[0] - M_keypad[0]) + Math.abs(R_keypad[1] - M_keypad[1]);
                
                // 왼손이 더 가까울 경우
                if(L_num < R_num){ answer.append("L"); }
                
                // 오른손이 더 가까울 경우
                else if(R_num < L_num){ answer.append("R"); }
                
                 // 거리가 같은 경우
                else{
                    if(hand.charAt(0) == 'r'){ answer.append("R"); }
                    else{ answer.append("L"); }
                }
                // 손 위치 설정
                if(answer.charAt(answer.length()-1) == 'L'){ L_keypad = M_keypad.clone(); }
                else{ R_keypad = M_keypad.clone(); }
            }
        }
        return answer.toString();
    }
}
```