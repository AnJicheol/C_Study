




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