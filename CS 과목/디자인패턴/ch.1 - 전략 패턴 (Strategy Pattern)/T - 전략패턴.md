


# 전략패턴 (Strategy Pattern)
------------------------------------------------------------------------


# 정의 
-------------------------------------------------------------------------
## 알고리즘을 별도 정의하고 각 알고리즘을 캡슐화해 각각의 알고리즘을 교환 밑 수정 해서 사용할 수 있는 패턴


# 사용 이유

--------------------------------------------------------
### 1. 중복코드 방지
### 2. SOLID - OCP 위반 방지    ! 스터디 목차상 다음에 설명 !
### 3.  확장성 보장 -- > 알고리즘 변경 및 추가


# 단점
------------------------------------------------------------------------------
### 1. 로직이 늘어남에 따라 클래스 또한 늘어남


# 예제 
--------------------------------------------------------------


```java
// item.java 

public interface item {  
    public void use();  
}

```

```java
//weapon.java

public class weapon implements item{  
    public void use() {  
        System.out.println("공격력이 증가했습니다 !");  
    }  
}
```

```java
//armor.java

public class armor implements item{  
    public void use() {  
        System.out.println("방어력이 증가했습니다 !");  
    }  
}

```

```java
//portion.java

public class portion  implements item{  
    public void use(){  
        System.out.println("체력이 증가했습니다 !");  
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
}
```

```java
//main.java

public class Main {  
    public static void main(String[] args) {  
  
        item inventory1 = new weapon();  
        item inventory2 = new armor();  
        item inventory3 = new portion();  
  
        inventory1.use();  
        inventory2.use();  
        inventory3.use();  
    }  
}
```

```
실행결과

공격력이 증가했습니다 !
방어력이 증가했습니다 !
체력이 증가했습니다 !

```
