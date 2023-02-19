
-   `n`은 1이상 8000000000 이하인 자연수입니다.

~~~~
JS
function solution(n) {
    var answer = 0;
    var test = ""
    test += n
    var arr = test.split("")
    // 정렬
    arr.sort(function(a, b){
        return b - a;
    });
    // 배열 담은 후 큰 수 부터 더함
    test = ""
    for(var i=0; i<arr.length; i++){
        test += arr[i]
    }
    answer = test
    answer *=1
    
    return answer;
}
~~~~
