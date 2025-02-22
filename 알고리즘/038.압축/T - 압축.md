# [바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/17684)


###### 문제 설명

## 압축

신입사원 어피치는 카카오톡으로 전송되는 메시지를 압축하여 전송 효율을 높이는 업무를 맡게 되었다. 메시지를 압축하더라도 전달되는 정보가 바뀌어서는 안 되므로, 압축 전의 정보를 완벽하게 복원 가능한 무손실 압축 알고리즘을 구현하기로 했다.

어피치는 여러 압축 알고리즘 중에서 성능이 좋고 구현이 간단한 **LZW**(Lempel–Ziv–Welch) 압축을 구현하기로 했다. LZW 압축은 1983년 발표된 알고리즘으로, 이미지 파일 포맷인 GIF 등 다양한 응용에서 사용되었다.

LZW 압축은 다음 과정을 거친다.

1.  길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
2.  사전에서 현재 입력과 일치하는 가장 긴 문자열 `w`를 찾는다.
3.  `w`에 해당하는 사전의 색인 번호를 출력하고, 입력에서 `w`를 제거한다.
4.  입력에서 처리되지 않은 다음 글자가 남아있다면(`c`), `w+c`에 해당하는 단어를 사전에 등록한다.
5.  단계 2로 돌아간다.

```java
import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        StringBuffer sb = new StringBuffer();
        String init = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<String> word = new ArrayList<>();
        String str = "";
        int top = 0;
        
        for(int i = 0; i < 26; i++){
            word.add(String.valueOf(init.charAt(i)));
        }
        
        for(int j = 0; j < msg.length(); j++){
                
            sb.append(msg.charAt(j));
            str = sb.toString();

            if(word.indexOf(str) == -1){
                
                word.add(str);
                sb.setLength(0);
                j--;
                num.add(top);
                continue;
            }
            top = word.indexOf(str) + 1;
        }
        num.add(top);
        return num.stream().mapToInt(i -> i).toArray();
    }
}

```

