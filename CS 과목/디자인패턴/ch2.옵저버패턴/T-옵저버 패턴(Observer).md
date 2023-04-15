

# 목차
-------------------------------------------------------
1. 정의
2. 사용 이유
3. 전체 코드


# 정의
---------------------------------------------------------

### 옵저버 패턴에서는 한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체들한테 연락이 가고 자동으로 내용이 갱신되는 방식으로 일대다 의존성을 정의한다.


# 장점
------------------------------------------------------
+ 실시간으로 객체의 변경사항을 다른 객체들에게 전파할 수 있다.
+ 느슨한 결합으로 시스템이 유연해지고 객체간의 의존성을 제거할 수 있다


# 단점
-------------------------------------------------------------------
+ 객체가  업데이트하는 값은  모든 옵저버들이 동일하게 사용되는 값이다
	+ 옵저버 들이 값을 받고 해당 값을 수정 또는 사용하는 과정에서 전체적으로 프로그램이 복잡해지고 문제가 생겼을때 추적 또한 어려울 수 있다.



# 사용 이유 & 예제
-----------------------------------------------------------------------

##  상황1. 

+ 간단한 가정을 해보자. 아래 코드에 변수는 각 품목에 가격을 저장하는 변수이다 이때 모든 변수를 같은 값으로 수정하기 위해서는 어떻게 해야할까?

```java

public class Candy_Factory {  

    int strawberry_candy;  
    int apple_candy;  
    int grape_candy;   
    
}

```


# 해결 : 메소드

+ 간단하게 Setter 같은 메소드를 이용해서 이를 해결할 수 있다

```java

public class Candy_Factory {  
    int strawberry_candy;  
    int apple_candy;  
    int grape_candy;  
    
    public Candy_Price(int price){  
        this.strawberry_candy = price;  
        this.apple_candy = price;  
        this.grape_candy = price;  
    }  
  
}

public class Main {  
    public static void main(String[] args) {  
        Candy_Factory candy_factory = new Candy_Factory();  
		candy_factory.Candy_Price(5)
    }  
}


```

------------------------------------------------------------------------
## 상황2. 

+ 사탕 공장이 다양한 마트와 계약을 맺는데 성공했다 이때 각마트가 공장에 품목을 참조할 수 있도록 하기 위해서는 어떻게 해야할까?


```java


public class A_Mart extends Candy_Factory{  
  
}

public class B_Mart extends Candy_Factory{  
  
}

public class Candy_Factory {  

    int strawberry_candy;  
    int apple_candy;  
    int grape_candy;  
    
    public Candy_Factory(int price){  
        this.strawberry_candy = price;  
        this.apple_candy = price;  
        this.grape_candy = price;  
    }  
}


```


# 해결 : 상속 

+ 먼저 상속이나 객체를 만드는 등으로 해결할 수 있을 것이다 


# 문제점

+ 사탕에 값이 바뀌거나 새로운 사탕이 추가 될 때마다 해당 클래스를 직접 수정 해야한다 이는 각 마트들은 사탕 공장을 참조하는 것이 아닌 인스턴스를 복사한 것이기 때문이다.

```java

public class Main {  
    public static void main(String[] args) {  
	    
        Candy_Factory candy_factory = new Candy_Factory();  
        candy_factory.Candy_Price(5);  
        A_Mart a = new A_Mart();  
        B_Mart b = new B_Mart();  
		  
       System.out.println("A 마트 딸기맛 사탕에 가격은?" + "  " + a.strawberry_candy);  
	   System.out.println("B 마트 딸기맛 사탕에 가격은?" + "  " + b.strawberry_candy);  
	   a.Candy_Price(5);  
	  
	   System.out.println("A 마트 딸기맛 사탕에 가격은?" + "  " + a.strawberry_candy);  
	   System.out.println("B 마트 딸기맛 사탕에 가격은?" + "  " + b.strawberry_candy);
    }  
}


```

# 출력

```java
A 마트 딸기맛 사탕에 가격은?  0
B 마트 딸기맛 사탕에 가격은?  0
A 마트 딸기맛 사탕에 가격은?  5
B 마트 딸기맛 사탕에 가격은?  0
```


### 이를 해결하기 위해 MART라는 클래스를 만들고 모든 마트를 관리한다고  가정 했을때 마트가 바뀐 사탕에 가격을 매번 감지하려면 스레드를 이용하여 메모리를 따로 분리해야 한다 그리고 이는 상당한 부담이다.

-----------------------------------------------------
# 사탕 공장에서 마트를 관리한다면 ?


## Mart  (옵저버)

```java

public interface Mart {  
	public void update_price(int price);
}

public class A_Mart  implements Mart{  
	int strawberry_candy;  
	int apple_candy;  
	int grape_candy;  
	  
	@Override  
	public void update_price(int price) {  
	    this.strawberry_candy = price;  
	    this.apple_candy = price;  
	    this.grape_candy = price;  
		 test();
	}
	
	public void test(){    //추 후 테스트를 위한 메소드
	    System.out.println("가격 갱신 완료  " + "strawberry_candy : " + strawberry_candy + "   "  
            + "apple_candy : " + apple_candy + "   " + "grape_candy : " + grape_candy  
	    );  
    }
}

public class B_Mart implements Mart{  
	int strawberry_candy;  
    int apple_candy;  
    int grape_candy;  
	
	int strawberry_candy;  
	int apple_candy;  
	int grape_candy;  
	  
	@Override  
	public void update_price(int price) {  
	    this.strawberry_candy = price;  
	    this.apple_candy = price;  
	    this.grape_candy = price;  
	    test();
	}
	
	public void test(){    //추 후 테스트를 위한 메소드
	    System.out.println("가격 갱신 완료  " + "strawberry_candy : " + strawberry_candy + "   "  
            + "apple_candy : " + apple_candy + "   " + "grape_candy : " + grape_candy  
	    );  
	}
}
```

## Candy_Factory

```java

public class Candy_Factory {  

    List<Mart> mart = new ArrayList<>();  
    int strawberry_candy;  
    int apple_candy;  
    int grape_candy;  
    
    public void Candy_Price(int price){  
        this.strawberry_candy = price;  
        this.apple_candy = price;  
        this.grape_candy = price;  
    }  
	  
    public void add_Mart(Mart m){  
        mart.add(m);  
    }  
	  
    public void remove_Mart(Mart m){  
        mart.remove(m);  
    } 
}

```

### 리스트로 마트 객체를 저장한다면 추후 마트가 늘어나거나 줄어들어도 문제가 없다 하지만 아직 바뀐 사탕에 값을 마트들에게 알려줄 수 없다.

-----------------------------------------------------------------------------
# 해결 - 옵저버 패턴


```java

public interface Subject {  // Subject 클래는 옵저버를 관리함
	
    public void add_Mart(Mart m);
    public void remove_Mart(Mart m);
    public void notify_mart(int price);
        
}

public class Candy_Factory implements Subject {  

    List<Mart> mart = new ArrayList<>();  
    int strawberry_candy;  
    int apple_candy;  
    int grape_candy;  
    
    public void Candy_Price(int price){  
        notify_mart(price);  
    }  
      
    public void notify_mart(int price){  
        for(Mart m : mart){  
            m.update_price(price);  
        }  
    }  
      
    public void add_Mart(Mart m){  
        mart.add(m);  
    }  
	  
    public void remove_Mart(Mart m){  
        mart.remove(m);  
    }  
}
```


## 사탕 공장에 사탕 가격이 변경되면 notify_mart 메소드가 호출되면서 자동으로 mart객체들에 값들이 갱신된다 


##  값이 정상적으로 갱신 되는 것을 확인할 수 있다.

```java

public class Main {  
    public static void main(String[] args) {  
        Candy_Factory candy_factory = new Candy_Factory();  
        candy_factory.Candy_Price(5);  
  
        A_Mart a_mart = new A_Mart();  
        B_Mart b_mart = new B_Mart();  
  
        candy_factory.add_Mart(a_mart);  
        candy_factory.add_Mart(b_mart);  
  
        candy_factory.Candy_Price(7);  
  
        candy_factory.Candy_Price(3);  
    }  
}

```

## 출력

```java
가격 갱신 완료  strawberry_candy : 7   apple_candy : 7   grape_candy : 7
가격 갱신 완료  strawberry_candy : 7   apple_candy : 7   grape_candy : 7
가격 갱신 완료  strawberry_candy : 3   apple_candy : 3   grape_candy : 3
가격 갱신 완료  strawberry_candy : 3   apple_candy : 3   grape_candy : 3
```



# 전체코드
---------------------------------------------------------------------------


```java
public class Main {  
    public static void main(String[] args) {  
        Candy_Factory candy_factory = new Candy_Factory();  
        candy_factory.Candy_Price(5);  
  
        A_Mart a_mart = new A_Mart();  
        B_Mart b_mart = new B_Mart();  
  
        candy_factory.add_Mart(a_mart);  
        candy_factory.add_Mart(b_mart);  
  
        candy_factory.Candy_Price(7);  
  
        candy_factory.Candy_Price(3);  
    }  
}
```

```java

public interface Subject {  // Subject 클래는 옵저버를 관리함
	
    public void add_Mart(Mart m);
    public void remove_Mart(Mart m);
    public void notify_mart(int price);
        
}
```

```java
public class Candy_Factory {  
    List<Mart> mart = new ArrayList<>();  
    int strawberry_candy;  
    int apple_candy;  
    int grape_candy;  
    public void Candy_Price(int price){  
        notify_mart(price);  
    }  
  
    public void notify_mart(int price){  
        for(Mart m : mart){  
            m.update_price(price);  
        }  
    }  
  
    public void add_Mart(Mart m){  
        mart.add(m);  
    }  
  
    public void remove_Mart(Mart m){  
        mart.remove(m);  
    }  
}
```

```java
public interface Mart {  
    public void update_price(int price);  
}
```


```java
public class A_Mart  implements Mart{  
    int strawberry_candy;  
    int apple_candy;  
    int grape_candy;  
  
    public void update_price(int price) {  
        this.strawberry_candy = price;  
        this.apple_candy = price;  
        this.grape_candy = price;  
        test();  
    }  
  
    public void test(){  
        System.out.println("가격 갱신 완료  " + "strawberry_candy : " + strawberry_candy + "   "  
                + "apple_candy : " + apple_candy + "   " + "grape_candy : " + grape_candy  
        );  
    }  
}
```

```java
public class B_Mart implements Mart{  
    int strawberry_candy;  
    int apple_candy;  
    int grape_candy;  
  
    @Override  
    public void update_price(int price) {  
        this.strawberry_candy = price;  
        this.apple_candy = price;  
        this.grape_candy = price;  
        test();  
    }  
  
    public void test(){  
        System.out.println("가격 갱신 완료  " + "strawberry_candy : " + strawberry_candy + "   "  
                + "apple_candy : " + apple_candy + "   " + "grape_candy : " + grape_candy  
        );  
    }  
}
```

