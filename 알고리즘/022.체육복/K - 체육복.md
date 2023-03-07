
~~~~ js
function solution(n, lost, reserve) {
    var answer = n-lost.length;
    var l = lost.length
    var r = reserve.length
    lost.sort((a,b)=>a-b)
    reserve.sort((a,b)=>a-b)
    
     for(var i=0; i<l; i++){
        for(var j=0; j<r; j++){
            if(lost[i] == reserve[j]){
                reserve[j] = 32
                lost[i] = 32
                answer++ // 둘 이 같으면 잃어버린 사람이 없기 때문에 더해줌
                break
            }
        }
    }    
    
    for(var i=0; i<l; i++){
        for(var j=0; j<r; j++){
            var num = lost[i] - reserve[j] 
            if(Math.abs(num) == 1){ // 절대값 1이면 빌려 줌
                answer++
                reserve[j] = 32 // 빌려준 사람은 쓰레기 값으로 변경
                break;
            }
        }
    }
    
    return answer;
}
~~~~