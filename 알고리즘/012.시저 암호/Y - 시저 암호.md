###### 문제 설명

어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

##### 제한 조건

-   공백은 아무리 밀어도 공백입니다.
-   s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
-   s의 길이는 8000이하입니다.
-   n은 1 이상, 25이하인 자연수입니다.


## [바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/12926)

```java

class Solution {
    public String solution(String s, int n) {
        StringBuilder str = new StringBuilder();
        int num = 0;
        
        for(int i = 0; i < s.length(); i++){
            num = s.charAt(i); // 글자의 아스키코드 값
            
            if(num >= 65 && num <= 90){ // 대문자
                if(num + n > 90){
                    str.append(String.valueOf((char)(num + n - 26))); 
                    continue;
                }
                str.append(String.valueOf((char)(num + n)));
            }
            else if(num >= 97 && num <= 122){ // 소문자
                if(num + n > 122){
                    str.append(String.valueOf((char)(num + n - 26))); 
                    continue;
                }
                str.append(String.valueOf((char)(s.charAt(i) + n)));
            }
            else{
                str.append(String.valueOf((char)num));
            }
        }
        //System.out.println(str);
        
        return String.valueOf(str);
    }
}
```