

# [바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/154539)


정수로 이루어진 배열 `numbers`가 있습니다. 배열 의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수라고 합니다.  
정수 배열 `numbers`가 매개변수로 주어질 때, 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return 하도록 solution 함수를 완성해주세요. 단, 뒷 큰수가 존재하지 않는 원소는 -1을 담습니다.

~~~~js
function solution(numbers) {
    var answer = [];
    var max = numbers.length-1 
    answer[max] = -1
    
    for(var i=numbers.length-2; i>=0; i--){
        if(numbers[max] < numbers[i]) max = i
        // i+1이 클 때
        if(numbers[i] < numbers[i+1]){
            answer[i] = numbers[i+1]
            continue
        }
        // 같을 때
        if(numbers[i] == numbers[i+1]){
            answer[i] = answer[i+1]
            continue
        }
        // 작을 때
        var count = 0;
        for(var j=i+1; j<=max; j++){
            if(numbers[i] < numbers[j]){
                answer[i] = numbers[j]
                count++
                break
            }
            if(numbers[i] == numbers[j]){
                answer[i] = answer[j]
                count++
                break
            }
        }
        if(count == 0) answer[i] = -1
    }
    
    return answer;
}
~~~~~