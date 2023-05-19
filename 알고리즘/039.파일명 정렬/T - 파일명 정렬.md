
```java
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] files) {
        
      
        Arrays.sort(files ,new Comparator<String> (){
            
            String str1 = "";
            String str2 = "";
            String num1 = "";
            String num2 = "";
            int num = 0;
            
            @Override
            public int compare(String o1, String o2){
                
                num1 = o1.replaceAll("^\\D*(\\d+).*", "$1");
                num2 = o2.replaceAll("^\\D*(\\d+).*", "$1");
                
                str1 = o1.split(num1)[0];
                str2 = o2.split(num2)[0];
                
                str1 = str1.toLowerCase();
                str2 = str2.toLowerCase();
                
                if(str1.compareTo(str2) != 0) return str1.compareTo(str2);
                
                if(num1.length() > 5) num1 = num1.substring(0, 6);
                if(num2.length() > 5) num2 = num2.substring(0, 6);
                
                return Integer.parseInt(num1) - Integer.parseInt(num2);
                
            } 
        });
          
        return files;
    }
}
```