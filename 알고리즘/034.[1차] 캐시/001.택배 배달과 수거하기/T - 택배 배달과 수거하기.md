
###### 문제 설명

![재할용 택배 상자.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/7ce63a07-3abd-40a1-87cc-c1f664393aa0/%E1%84%8C%E1%85%A2%E1%84%92%E1%85%A1%E1%86%AF%E1%84%8B%E1%85%AD%E1%86%BC%20%E1%84%90%E1%85%A2%E1%86%A8%E1%84%87%E1%85%A2%20%E1%84%89%E1%85%A1%E1%86%BC%E1%84%8C%E1%85%A1.png)

당신은 일렬로 나열된 `n`개의 집에 택배를 배달하려 합니다. 배달할 물건은 모두 크기가 같은 재활용 택배 상자에 담아 배달하며, 배달을 다니면서 빈 재활용 택배 상자들을 수거하려 합니다.  
배달할 택배들은 모두 재활용 택배 상자에 담겨서 물류창고에 보관되어 있고, `i`번째 집은 물류창고에서 거리 `i`만큼 떨어져 있습니다. 또한 `i`번째 집은 `j`번째 집과 거리 `j - i`만큼 떨어져 있습니다. (1 ≤ `i` ≤ `j` ≤ `n`)  
트럭에는 재활용 택배 상자를 최대 `cap`개 실을 수 있습니다. 트럭은 배달할 재활용 택배 상자들을 실어 물류창고에서 출발해 각 집에 배달하면서, 빈 재활용 택배 상자들을 수거해 물류창고에 내립니다. 각 집마다 배달할 재활용 택배 상자의 개수와 수거할 빈 재활용 택배 상자의 개수를 알고 있을 때, 트럭 하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리를 구하려 합니다. **각 집에 배달 및 수거할 때, 원하는 개수만큼 택배를 배달 및 수거할 수 있습니다.**

트럭에 실을 수 있는 재활용 택배 상자의 최대 개수를 나타내는 정수 `cap`, 배달할 집의 개수를 나타내는 정수 `n`, 각 집에 배달할 재활용 택배 상자의 개수를 담은 1차원 정수 배열 `deliveries`와 각 집에서 수거할 빈 재활용 택배 상자의 개수를 담은 1차원 정수 배열 `pickups`가 매개변수로 주어집니다. 이때, 트럭 하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리를 return 하도록 solution 함수를 완성해 주세요.


```java
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int drop = 0;
        int get  = 0;
        int num  = 0;

        for(int i = n - 1; i >= 0; i--){
            drop -= deliveries[i];  
            get  -= pickups[i];     
			
            if(drop < 0 || get < 0){
				
                num = (drop < get) ? drop : get;
                num = num * -1;
	             
                num = ((num % cap) == 0) ? num / cap : num / cap + 1;   
                drop += cap * num;
                get  += cap * num;
				
                answer += ((i + 1) * 2) * num;
            }
        }
		
        return answer;
    }
}
```