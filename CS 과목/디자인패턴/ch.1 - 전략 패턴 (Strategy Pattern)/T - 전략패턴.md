


# 전략패턴 (Strategy Pattern)
------------------------------------------------------------------------


# 정의 
-------------------------------------------------------------------------
## 알고리즘을 별도 정의하고 각 알고리즘을 캡슐화해 각각의 알고리즘을 교환 밑 수정 해서 사용할 수 있는 패턴


# 사용 이유

--------------------------------------------------------

* 중복 코드 방지
* SOLID - OCP 위반 방지    ! 스터디 목차상 다음에 설명 !
* 확장성 보장 -- > 알고리즘 변경 및 추가


## 예제

```java

public class weapon{
	public void use(){
		System.out.println("공격력이 증가했습니다!");
	}
}

public class armor{  
    public void use() {  
        System.out.println("방어력이 증가했습니다 !");  
    }  
}

public class portion{  
    public void use(){  
        System.out.println("체력이 증가했습니다 !");  
    }  
}


해당 코드는 같은 메서드가 중복되는 것을 알 수 있는데 이것을 상속으로 해결할 수 있다.

public abstract class item {
	public abstract void use();
}

public class weapon extends item {
	@Override
	public void use(){
		System.out.println("공격력이 증가했습니다!");
	}
}

public class armor extends item {  
	@Override
    public void use() {  
        System.out.println("방어력이 증가했습니다 !");  
    }  
}

public class portion extends item {  
	@Override
    public void use(){  
        System.out.println("체력이 증가했습니다 !");  
    }  
}

하지만 상속을 하면 크게 2가지 문제가 있다

1. 기능 추가에 따른 문제점 
	1. 각 클래스를 전부 오버라이드로 구현

2. 메소드 수정 어려움
	1. 메소드 변경 시 의도치 안은 결과 초래 가능성 있음
	2. SOLID - OCP 위반
```
``` 

```


# 전략 패턴 사용 후

```java

public interface item {  
    public void use();  
}

public class weapon extends inventory {}      
public class armor extends inventory {}
public class portion  extends inventory {}

public class sword implements item{  
    public void use() {  
        System.out.println("공격력이 증가했습니다 !");  
    }  
}

public class health implements item{  
    public void use() {  
        System.out.println("체력이 증가했습니다 !");  
    }  
}

public class shield implements item{  
    public void use() {  
        System.out.println("방어력이 증가했습니다 !");  
    }  
}

public abstract class inventory {  
    item Item;  
	  
    public inventory(){}  
    public void use_item(){  
        Item.use();  
    }  
	
	public void setItem(item it){
		Item = it;
	}
	
}

public class Main {  
    public static void main(String[] args) {  
	  
        inventory item1 = new weapon();  
		inventory item2 = new armor();  
		inventory item3 = new portion();  
		  
		item1.setItem(new sword());  
		item2.setItem(new shield());  
		item3.setItem(new health());  
		
		item1.use_item();  
		item2.use_item();  
		item3.use_item();
    }  
}

중복 코드를 캡슐화를 통해 분리하였으며 
메소드 수정 또한 간결하다 

ex)

public class health implements item{  
    public void use() {  
        //System.out.println("체력이 증가했습니다 !");  변경전
        System.out.println("마나가 증가했습니다 !");  //변경후
    }  
}

또 기능 추가 및 확장성도 보장한다

public class bow implements item{  
    public void use() {  
        System.out.println("공격력이 증가했습니다 !");  
    }  
}

```



# 단점
------------------------------------------------------------------------------
### 1. 로직이 늘어남에 따라 클래스 또한 늘어남




# 전체 코드
--------------------------------------------------------------


```java
// item.java 

public interface item {  
    public void use();  
}

```

```java
//weapon.java

public class weapon extends inventory {}
```

```java
//armor.java

public class armor extends inventory {}

```

```java
//portion.java

public class portion  extends inventory {}

```

```java
//sword.java

public class sword implements item{  
    public void use() {  
        System.out.println("공격력이 증가했습니다 !");  
    }  
}

```

```java
//health.java

public class health implements item{  
    public void use() {  
        System.out.println("체력이 증가했습니다 !");  
    }  
}

```

```java
//shield.java

public class shield implements item{  
    public void use() {  
        System.out.println("방어력이 증가했습니다 !");  
    }  
}

```


```java
//inventory

public abstract class inventory {  
    item Item;  
	  
    public inventory(){}  
    public void use_item(){  
        Item.use();  
    }  
	
	public void setItem(item it){
		Item = it;
	}
	
}
```

```java
//main.java

public class Main {  
    public static void main(String[] args) {  
	  
        inventory item1 = new weapon();  
		inventory item2 = new armor();  
		inventory item3 = new portion();  
		  
		item1.setItem(new sword());  
		item2.setItem(new shield());  
		item3.setItem(new health());  
		
		item1.use_item();  
		item2.use_item();  
		item3.use_item();
    }  
}
```

```
실행결과

공격력이 증가했습니다 !
방어력이 증가했습니다 !
체력이 증가했습니다 !

```


# 과제
--------------------------------------------------------------------

1. 전략 패턴 예제 만들어 오기
2. 해당 전체 코드에서 캡슐화를 통해 고려해 볼 수 있는 사항을 준비해 오기
3. 왜 상위 형식에 맞추어 프로그래밍 해야하는지 알아오기

# 보충
--------------------------------------------------------------
