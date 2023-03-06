
# 삽입정렬 : 크기가 작은 정렬에 효율적인 알고리즘
-----------------------
## 자신보다 큰 수를 만날 때 까지 앞으로 인덱스를 이동하면서 검사한다.
## 만약 자신보다 큰 수를 만났다면 그 수의 앞 인덱스에 삽입하고 뒤에 수를 한 칸씩 뒤로 이동시킨다.

```java

public class insertionSort {  
    public static void main(String[] args) {  
        int[] box = {5,2,4,6,1,3};  
  
        int n = box.length;  
        for (int i = 1; i < n; i++) {  
            int key = box[i]; // j보다 인덱스 한칸 뒤
            int j = i - 1; // 0부터 시작
            while (j >= 0 && box[j] > key) { 
            // 자신보다 큰 수를 만나면 종료
                box[j + 1] = box[j];
                j--;
            }  
            box[j + 1] = key; 
        }
  
        System.out.println(Arrays.toString(box));  
    }  
}

```

# 연습문제
---------------------
* 수열 A = {31,41,59,26,41,58}이 입력 수열로 주어질 때 삽입정렬의 동작을 설명하라
```
index = 1부터 시작 자신보다 큰수를 만나거나 index가 0이 될 때까지 값을 찾는다.

만약 자신보다 큰수를 만났으면 그 수 앞 인덱스에 삽입하고 뒤의 값을 뒤로 이동시킨다.

이 작업을 배열의 길이만큼 반복한다.
```
* 오름차순 대신 내림차순으로 정렬하게 변경하여라
``` java
while (j >= 0 && box[j] < key) { 
```
* 입력 : n개 수들의 수열 A = {a1, a2 ...}과 어떤 값 v
* 출력 : v = A[i]를 만족하는 인덱스 i, v가 배열 A에 존재하지 않으면 특수값 NIL
```
int[] A = {a1,a2,a3 ...}

int v = 랜덤한 값

for I=0 to A.length

if(v == A[i]){return i;}

일치하는 값이 없으면 return “NIL”
```

* 원소가 n개인 두 배열 A,B에 저장된 두 개의 n비트 이진수를 더하는 문제를 고려해 보자 두 이진수의 합은 원소라 n+1인 배열 C에 이진수의 형태로 저장되어야 한다. 이 문제를 엄밀하게 서술하고, 두 정수의 합을 수하는 의사코드를 작성하라.
```
A = 이진수 n개의 배열 {a1,a2...n}
B = 이진수 n개의 배열 {a1,a2...n}

C = {n+1};

for I=0 to A.length

C[i] = A[i] + B[i];
```

# 알고리즘 분석
--------------
알고리즘의 분석은 그 알고리즘을 실행하는 데 필요한 자원을 예측하는 것을 의미한다.
알고리즘이 여러개라면 분석을 통하여 가장 효율적인 알고리즘을 구분할 수 있다.

# 삽입정렬의 분석
--------------
삽입정렬은 입력되는 데이터의 양인 입력크기와, 수열이 얼마나 정렬되어 있는지에 따라 수행시간이 변화한다.
입력크기가 정해져있더라고 수열이 얼마나 정렬되어있는가에 따라 수행시간이 변한다.

# 최악의 경우와 평균적인 경우의 분석
------------
## 최악의 경우 분석의 이유

1. 최악의 경우를 알게되면, 다른 경우에 대한 추측이 필요없으며, 더 이상 나빠지지않기를 바랄 이유도 없다.
2. 어떤 알고리즘은 최악의 경우가 빈번하게 발생될 수 있다. 예를들어 특정 정보가 데이터베이스에 없는 경우 등이 있다.
3. 평균적인 경우가 최악의 경우만큼 좋지 못한 상활일 때가 있다.

# 증가차수
-------------
차수가 가장 높은 항만 고려한다. 그리고 차수가 가장 높은 항의 상수도 무시한다. 이것은 큰 입력의 효율성을 계산할 때, 증가비율에 비해 덜 중요하기 때문이다. n3 + n2 + n

# 분할정복 접근법
------------
주어진 문제를 풀기위해서 자기 자신을 재귀적으로 여러 번 호출한다. 이런 알고리즘들은 전형적으로 분할정복 접근법을 따른다.

분할 : 현재문제를 같은 문제를 다루는 다수의 부분 문제로 분할한다.
정복 : 부분 문제를 재귀적으로 풀어서 정복한다. 부분 문제의 크기가 충분히 작으면 직접적인 방법으로 푼다.
결합 : 부분 문제의 해를 결합하여 원래 문제의 해가 되도록 만든다.

# 병합정렬의 분할 정복 기법
-------------
분할 : 정렬할 n개의 원소의 배열을 n/2개씩 부분 수열 두 개로 분할한다.
정복 : 병합 정렬을 이용해 두 부분 배열을 재귀적으로 정렬한다.
결합 : 정렬된 두 개의 부분 배열을 병합해 정렬된 배열 하나로 만든다.

# 병합정렬
----------
```java
public class MergeSort {  
  
    public static void main(String[] args) {  
        int[] box = {8,2,6,4,7,3,9,5};  
  
        mergeSort(box, 0, box.length - 1);  
    }  
    public static void mergeSort(int[] box, int left, int right) {  
        if (left < right) { // 조건이 false일때까지 계속 재귀  
            int mid = (left + right) / 2;  
            mergeSort(box, left, mid); // 왼쪽  
            mergeSort(box, mid + 1, right); // 오른쪽  
            merge(box, left, mid, right); // 병합  
        }  
    }  
  
    public static void merge(int[] box, int left, int mid, int right) {  
//        System.out.println(left + " " + right);  
        int[] box2 = new int[right - left + 1]; 
        // 임시 배열 2        int i = left; 
        // 왼쪽 배열 인덱스 0        int j = mid + 1; 
        // 오른쪽 배열 인덱스 1        int k = 0; // 임시 배열 인덱스  
  
        // 정렬  
        while (i <= mid && j <= right) { // right = 1  
            if (box[i] <= box[j]) {  
                box2[k] = box[i];  
                k++; i++;  
            } else {  
                box2[k] = box[j];  
                k++; j++;  
            }  
        }
        // 남은 원소들을 임시 배열에 넣어줌 마지막 1개  
        while (i <= mid) {  
            box2[k] = box[i];  
            k++; i++;  
        }  
        while (j <= right) {  
            box2[k] = box[j];  
            k++; j++;  
        }  
        System.out.println("box2 = " + Arrays.toString(box2));  
        // 원래 배열에 복사함  
        for (int x = 0; x < box2.length; x++) {  
            box[left + x] = box2[x];  
        }  
        System.out.println("box = " + Arrays.toString(box));  
    }  
}

출력결과
box2 = [2, 8]
box = [2, 8, 6, 4, 7, 3, 9, 5]
box2 = [4, 6]
box = [2, 8, 4, 6, 7, 3, 9, 5]
box2 = [2, 4, 6, 8]
box = [2, 4, 6, 8, 7, 3, 9, 5]
box2 = [3, 7]
box = [2, 4, 6, 8, 3, 7, 9, 5]
box2 = [5, 9]
box = [2, 4, 6, 8, 3, 7, 5, 9]
box2 = [3, 5, 7, 9]
box = [2, 4, 6, 8, 3, 5, 7, 9]
box2 = [2, 3, 4, 5, 6, 7, 8, 9]
box = [2, 3, 4, 5, 6, 7, 8, 9]
```

