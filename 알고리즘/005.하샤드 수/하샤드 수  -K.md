   `x`는 1 이상, 10000 이하인 정수입니다.
~~~~
function solution(x) {
    var answer = true;
    var x_str = ""
    var num = 0;
    x_str += x
    x_str = x_str.split("")
    
    for(var i=0; i<x_str.length; i++){
        num += x_str[i]*1
    }
    
    if(x%num != 0) return false
    
    return answer;
}
~~~~