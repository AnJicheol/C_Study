

문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.

##### 제한 사항

-   `s`는 길이 1 이상, 길이 8 이하인 문자열입니다.
-   `s`는 영문 알파벳 대소문자 또는 0부터 9까지 숫자로 이루어져 있습니다.


```java

해당 코드는 try catch 문  스터디 목적으로 작성된 코드임 


class Solution {
    public boolean solution(String s) {
    int len = s.length();
        
    if(len != 4 && len != 6) return false;
        
    try {
	      Integer.parseInt(s);
	      return true;
        
    } catch (NumberFormatException ex) {return false;}
    
}

```





