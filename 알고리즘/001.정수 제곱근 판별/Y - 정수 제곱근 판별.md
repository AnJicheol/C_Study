###### 문제 설명

임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.  
n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.

##### 제한 사항

-   n은 1이상, 50000000000000 이하인 양의 정수입니다.

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


------------------------------------------------------------------

```
	T - long 타입캐스팅 필요없다 즉 메모리 낭비
	제곱근 체대값 7.07196 x 10^6 따라서 int로 처리 가능 
	
	return (long)(num+1) * (long)(num+1);
	
```