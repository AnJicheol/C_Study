

# 정의
-------------------------------------------------------------------
## 객체의 추가 요소를 동적으로 더할 수 있으며 유연하게 기능을 확장할 수 있다


# 장점
--------------------------------------------
+ 기존 코드를 변경하지 않고 기능을 추가할 수 있다  (OPC)


# 단점
------------------------------------------------------------------------
+ 코드가 복잡해 질 수 있다 -- > 많은 객체들이 많들어 지기 때문



# 사용 이유 & 예제
----------------------------------------------------------------------

# 상황1.

+ 아래 코드는 샌드위치에 대한 클래스이다. 샌드위치에 재료가 추가할 때마다 값을 추가하고 싶다 어떻게 해야할까?


```java
public class Sandwich {  
    int cost;  
}
```


# 방법1.

+ 모든 경우에 객체를 구현
	ㄴ 좋은 방법은 아니다 클래스가 매우 많아지기 때문에 관리가 어렵기 때문이다

```java
public class Sandwich_cheese{
	int cost;
}

public class Sandwich_ham{
	int cost;
}
```


# 방법2.

+ 재료를 관리하는 클래스를 만들고 상속
	ㄴ 확실히 클래스가 줄어든 것을 알 수 있다
	ㄴ 재료의 가격이 바뀌거나 추가 혹은 삭제 시 기존 코드를 수정해야 한다
	ㄴ 새로운 음식이 추가 될때 그 음식도 해당 클래스를 상속 받아야 하는데 이는 해당 음식에서 존재하   면 안되는 음식도 상속 받을 것이다
 

```java
public class Bread {  
    boolean cheese;
    boolean ham;  
    boolean Fried;  
    boolean cabbage;  
    int cost;  
    
    public int Cost(){  
        if(cheese) cost += 500;  
        if(ham)    cost += 1000;  
        if(Fried)  cost += 500;  
        if(cabbage)cost += 200;  
		  
        return cost;  
    }  
}
```

```java
public class Sandwich extends Bread{  
    public int Cost(){  
	    System.out.println(2000 + super.Cost());
        return 2000 + super.Cost();  
    }  
}
```

```java
public class Main {  
    public static void main(String[] args) {  
        Sandwich sn = new Sandwich();  
		  
        sn.Cost();  
        sn.Fried = true;  
        sn.Cost();  
    }  
}
```

## 출력 결과

```java
2000
2500
```


# 상황2.

+ 방법 2는 효과적으로 클래스 갯 수를 줄였다 하지만 재료 가격이 변하는듯 변동사항이 있으면 기존 코드를 수정해야한다  이때 기존 코드 변경 없이 기능을 확장할 수 있는 방법이 있을까?

# 해결 - 데코레이터 패턴

```java
abstract class Bread {  
    String br = " ";  
  
    public String getDescription(){  
        return br;  
    }  
    public abstract int Cost();  
}
```

```java
abstract class Decorator extends Bread {  
    Bread bread;  
    public abstract String getDescription();  
}
```

```java
class cheese extends Decorator {  
  
    public cheese(Bread bread){  
        this.bread = bread;  
    }  
  
    public String getDescription(){  
        return bread.getDescription() + "cheese";  
    }  
    @Override  
    public int Cost() {  
        return bread.Cost() + 500;  
    }  
}
```

```java
class ham extends Decorator {  
  
    public ham(Bread bread){  
        this.bread = bread;  
    }  
  
    public String getDescription(){  
        return bread.getDescription() + "ham";  
    }  
  
    @Override  
    public int Cost() {  
        return bread.Cost() + 1000;  
    }  
}
```

```java
class Fried extends Decorator {  
  
    public Fried(Bread bread){  
        this.bread = bread;  
    }  
	
    public String getDescription(){  
        return bread.getDescription() + "Fried";  
    }  
  
    @Override  
    public int Cost() {  
        return bread.Cost() + 500;  
    }  
}
```

```java
class cabbage extends Decorator {  
  
    public cabbage(Bread bread){  
        this.bread = bread;  
    }  
  
    public String getDescription(){  
        return bread.getDescription() + "cabbage";  
    }  
    @Override  
    public int Cost() {  
        return bread.Cost() + 1000;  
    }  
}
```

```java
class Sandwich extends Bread{  
  
    public  Sandwich(){  
        br = "샌드위치";  
    }  
    public int Cost(){  
  
        return 2000 ;  
    }  
}
```

```java
public class Main {  
    public static void main(String[] args) {  
        Bread sn = new Sandwich();  
		  
        System.out.println(sn.getDescription() + "   " + sn.Cost());  
		  
        sn = new cheese(sn);  
        sn = new cabbage(sn);  
		  
        System.out.println(sn.getDescription() + "   " + sn.Cost());  
		  
    }  
}
```

```java
샌드위치   2000
샌드위치cheesecabbage   3500
```
