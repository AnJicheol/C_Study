



```java


import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
		
        ArrayList<Integer> num  = new ArrayList<Integer>(privacies.length);
        HashMap<Character,Integer> map = new HashMap();
		
        int[] Today = Stream.of(today.split("\\.")).mapToInt(Integer :: parseInt).toArray();
        int month = 0;
		
        for(String str : terms) {
            map.put(str.charAt(0), Integer.parseInt(str.split(" ")[1]));
        }
		
        for(int i = 0; i < privacies.length; i++){
			
            String[] user_imp = privacies[i].split("\\.");
            int day = (Today[2] - Integer.parseInt(user_imp[2].substring(0,2)));
			
            month  = (Today[0] - Integer.parseInt(user_imp[0])) * 12;
            month += (Today[1] - Integer.parseInt(user_imp[1]));        
            month += (day < 0) ? -1 : 0;

            if(month >= map.get(user_imp[2].charAt(3))) num.add(i + 1);
			
        }
		
        int[] answer = num.stream().mapToInt(Integer :: intValue).toArray();
		
        return answer;
    }
}

```