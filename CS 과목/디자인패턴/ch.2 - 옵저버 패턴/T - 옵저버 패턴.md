

# 옵저버 패턴 (observer pattern)
------------------------------------------------------------------------


# 정의 
-------------------------------------------------------------------------
## 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체에게 연락이 가고 자동으로 갱신되는 방식, 일대다 의존성을 정의



# 사용 이유

--------------------------------------------------------

* 실시간으로 객체의 상태 변화를 다른 객체에게 전파할 수 있다
* 즉 다시말해 주기적으로 감지하지 않더라도 데이터 받아옴
* 느슨한 결합으로 시스템이 유연해지고 객체간 의존성 주입 및 제거할 수 있음


## 예제 and 전체코드


```java
옵저버 패턴을 사용하지 않고 객체의 상태 변화를 알기 위해서는 주기적으로 변화를 체크해야함

ex)

class test extends Thread {

    public void run() {

        for (int i = 0; i < 10; i++) {

            if( 대충 객체 비교){
	            실행 코드
            }
            try {
            
                Thread.sleep(10);          
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


```

```java

//Main.java

public class Main {  
    public static void main(String[] args) {  
		  
        pickup pick = new pickup();  
		  
        bread_basket bb = new bread_basket(pick);  
        fruit_basket fb = new fruit_basket(pick);  
		
        pick.pickup_food("apple");  
        pick.pickup_food("baguette");  
		  
    }  
}```



```java
//Subject.java

public interface Subject {  
    public void add_basket(basket b);  
    public void remove_basket(basket b);  
    public void notifyBasket();  
    
}

```

```java

//pickup.java

import java.util.*;  
  
public class pickup implements Subject{  
    private List<basket> basket_list = new ArrayList<basket>();  
    private String food;  
  
    public void pickup_food(String food){  
        this.food = food;  
        notifyBasket();  
    }  
  
    public void add_basket(basket b){  
        basket_list.add(b);  
    }  
    
    public void remove_basket(basket b){  
        basket_list.remove(b);  
    }  
  
    public void notifyBasket(){  
        for(basket bs : basket_list) {  
            bs.update(food);  
        }  
    }  
  
}

```

```java

//basket.java
public interface basket {  
    public void update(String Food);  
}


```

```java
//basketElement.java
public interface basketElement {  
    public void get();  
}

```

```java

//bread_basket
public class bread_basket implements basket, basketElement{  
  
    private String food;  
    private pickup pick;  
  
    public bread_basket(pickup pick){  
        this.pick = pick;  
        pick.add_basket(this);  
    }  
  
    @Override  
    public void update(String Food) {  
        this.food = Food;  
        get();  
    }  
  
    public void get(){  
        if(food.equals("apple")){  
            System.out.println("빵 바구니 담기 완료");  
        }  
    }  
}


```

```java

//fruit_basket
public class fruit_basket implements basket, basketElement{  
    private String food;  
    private pickup pick;  
  
    public fruit_basket(pickup pick){  
        this.pick = pick;  
        pick.add_basket(this);  
    }  
    @Override  
    public void update(String Food) {  
        this.food = Food;  
        get();  
    }  
  
    public void get(){  
        if(food.equals("apple")){  
            System.out.println("과일 바구니 담기 완료");  
        }  
    }  
	
}
```

```java 
실행 결과

빵 바구니 담기 완료
과일 바구니 담기 완료

```

# 단점
---------------------------------------------------------------
+ Thread safe 하지 않다
+ 옵저버를 방치하면 메모리 누수가 발생할 수 있다
+ 코드가 복잡해지고 규모가 커지면 상태 관리 어려움


# 과제
--------------------------------------------------------------------
1. 의존성이 무엇인지 정의하고 예제 코드 준비
2. 90p 참조하여 느슨한 결합 예제 한개 만들어 오기
3. 104p 참조하여 pull 방식과 push 방식 옵저버 패턴 예제 각각 한개씩 만들어 오기



# 보충
--------------------------------------------------------------

