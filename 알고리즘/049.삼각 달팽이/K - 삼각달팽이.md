


## [바로가기](https://school.programmers.co.kr/learn/courses/30/lessons/68645)

###### 문제 설명

정수 n이 매개변수로 주어집니다. 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후, 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.

![examples.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/e1e53b93-dcdf-446f-b47f-e8ec1292a5e0/examples.png)

---

##### 제한사항

- n은 1 이상 1,000 이하입니다.

---

##### 입출력 예

|n|result|
|---|---|
|4|`[1,2,9,3,10,8,4,5,6,7]`|
|5|`[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]`|
|6|`[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]`|

---

##### 입출력 예 설명

입출력 예 #1

- 문제 예시와 같습니다.

입출력 예 #2

- 문제 예시와 같습니다.

입출력 예 #3

- 문제 예시와 같습니다.
~~~~js
function solution(n) {
    var answer = [];
    var a = n;
    const arr = Array.from(new Array(n), () => new Array(n).fill(0));
    var test1 = 0;
    var test2 = 0;
    var test3 = 1;
    var count = 1
    while(a>=1){  
        for (var i = test2; i < n-test1; i++) { // 아래
            arr[i][test1] = count
            count++
        }
        for (var i = test1+1; i < n-1-test2; i++) { // 오른쪽
            arr[n-1-test1][i] = count
            count++
        }
        for (var i = 0; i < n-test3; i++) { // 대각선
            arr[n-1-i-test1][n-1-i-test2] = count
            count++    
        }
        test1+=1;
        test2+=2;
        test3+=3
        a-=3
    }
    count = 0;
    for(var i=0; i<n; i++){
        for(var j=0; j<n; j++){
            if(arr[i][j] != 0){
                answer[count] = arr[i][j]
                count++
            }
        }
    }
    return answer;
}
~~~~