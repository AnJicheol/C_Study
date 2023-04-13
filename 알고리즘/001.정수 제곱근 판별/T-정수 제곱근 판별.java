class Solution {
    public long solution(long n) {
        
        Double num = Math.sqrt(n);
        
        if(num % 1 != 0.0) return (long)-1;
        
        return (long)((num + 1) * (num + 1));
    }
}
