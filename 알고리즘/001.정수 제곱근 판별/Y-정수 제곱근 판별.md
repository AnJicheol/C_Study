```
class Solution {
    public long solution(long n) {
        long answer = -1;
        
        double num = Math.sqrt(n);
        //System.out.println(num);
        if(num - (long)num == 0){
            return (long)(num+1) * (long)(num+1);
        }
        
        return answer;
    }
}
```
##### 제한 사항

-   n은 1이상, 50000000000000 이하인 양의 정수입니다.