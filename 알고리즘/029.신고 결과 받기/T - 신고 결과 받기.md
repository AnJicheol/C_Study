


```java


import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        Map<String, HashSet<String>> map1 = new HashMap<>(id_list.length);
        Map<String, Integer> map2 = new HashMap<>(id_list.length);
        int[] answer = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++){
            
            map1.put(id_list[i], new HashSet<>());
            map2.put(id_list[i], i);
        }
        
        for(String str : report){    
            
            String[] rp = str.split(" ");
            map1.get(rp[1]).add(rp[0]);         
        }
        
        for(String key :map1.keySet()){
            if(map1.get(key).size() >= k){
                for(String key2 : map1.get(key)){
                    answer[map2.get(key2)]++;
                }  
            }
        }
        
        return answer;
    }
}

```