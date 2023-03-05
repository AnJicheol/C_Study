
# 데코레이터 패턴(Dacorator Pattern)
--------------------------------------------------------------------------

# 정의
-----------------------------------------------------
## 객체의 결합 을 통해 기능을 동적으로 유연하게 확장 할 수 있게 해주는 패턴

# abstract
------------------------------------------------------------------------------
##  공통된 행동, 필드를 묶어 하나의 클래스를 만드는 것(추상화)  

추상 클래스는 하나의 추상 메서드만 포함하면 추상클래스가 됩니다.  
함수 선언만 되어있고 구현부가 없는 아래와 같은 메서드를  추상 메서드라고 합니다.  
public abstract class 클래스명();

## 예제
--------------------------------------------------
```java
public class Beverage {  
  
    String description = "제목 없음";  
  
    public double cost(){  
  
        double condimentCost = 0.0;  
  
        if(hasMilk()){  
            double milkCost = 0.1;  
            condimentCost += milkCost;  
        }  
        if(hasSoy()){  
            double soyCost = 0.1;;  
            condimentCost += soyCost;  
        }  
        if(hasMocha()){  
            double soyMocha = 0.1;;  
            condimentCost += soyMocha;  
        }  
        if(hasWhip()){  
            double soyWhip = 0.1;;  
            System.out.println(1);  
            condimentCost += soyWhip;  
        }  
        return condimentCost;  
    }
	public boolean hasWhip() {  
	    return false;  
	}  
  
	public boolean hasMocha() {  
	    return false;  
	}  
}

public class DarkRoast extends Beverage{  
    public DarkRoast(){  
        description = "최고의 다크 로스트 커피";  
    }  
  
    public double cost(){  
        return 1.99 + super.cost();  
    }  
}

// 모든 자식 클래스에게 필요하지 않은 것 까지 상속해버린다.
// ex) 아이스티에 휘핑 토핑이 상속
// 첨가물이 늘어나면 새로운 매서드 생성 및 기존 코드 변경

// 디자인 원칙 OCP : 클래스 확장에는 열려있어야하지만 변경에는 닫혀있어야한다.
```

# 데코레이터패턴 사용 후
```java
public abstract class Beverage {  
    String description = "제목 없음";  
  
    public String getDescription(){  
        return description;  
    }  
  
    public abstract double cost(); // 기능을 설정하지 않은 추상 메서드
}

public abstract class CondimentDecorator extends Beverage{ // 첨가물을 나타내는 추상 클래스  
    Beverage beverage;  
    public abstract String getDescription();  
}

public class DarkRoast extends Beverage{  
    public DarkRoast(){  
        description = "다크로스트";  
    }  
  
    public double cost(){  
        return 1.99;  
    }  
}

public class Mocha extends CondimentDecorator{  
  
    public Mocha(Beverage beverage){ // 감싸고자 하는 음료를 저장하는 인스턴스 변수  
        this.beverage = beverage;  
    }  
  
    public String getDescription(){  
        return beverage.getDescription() + ", 모카";  
    }  
  
    public double cost(){  
        return beverage.cost() + 0.20;  
    }  
}

public class Whip extends CondimentDecorator{  
    public Whip(Beverage beverage){  
        this.beverage = beverage;  
    }  
  
    public String getDescription(){  
        return beverage.getDescription() + ", 휘핑";  
    }  
  
    public double cost(){  
        return beverage.cost() + 0.20;  
    }  
}

public class StartbuzzCoffee {  
    public static void main(String[] args) {  
        Beverage beverage2 = new DarkRoast();  
        // DarkRoast의 생성자로 인하여 String description = "다크로스트"; 로 설정  
        // cost() = 1.99;로 설정  
        beverage2 = new Mocha(beverage2);  
        // Mocha의 생성자로인하여 CondimentDecorator의 
        // Beverage객체는 DarkRoast()가 설정된 객체로 설정
        
        // Mocha의 getDescription()에 의해서 "모카" 문자열 추가  
        // Mocha의 cost()에 의해서 가격 이 더해짐  
        beverage2 = new Mocha(beverage2);  
        // 위 작업과 동일
        beverage2 = new Whip(beverage2);
        // 위 작업과 동일
  
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());  
        // getDescription()이 호출되는 순간 
        //Whip의 getDescription()는 Mocha의 getDescription()를 호출  
        
        // Mocha의 getDescription()는 다른 Mocha의 getDescription()를 호출  
        // Mocha의 getDescription()는 DarkRoast()의 getDescription()를 호출  
        // cost()도 동일  
  
        //DarkRoast()부터 차례대로 리턴된다.  
    }
}

// 123p 참고
```

# 장단점
----------------------------------------------------------------------
## 장점 : 객체에 추가 요소를 동적으로 더할 수 있습니다.  
ex) 메서드에 추가하고 싶은 기능이 있는 객체를 감싸면 된다.(확장성)  

## 단점 : 자잘한 객체가 너무 많이 추가될 가능성이있으며, 필요이상으로 사용시에 코드가 너무 복잡해진다.


# 과제
-----------------------
## 추상화와 캡슐화의 차이점
## 왜 불필요한 메서드까지 상속하면 안되는지
## 새로운 예제 만들어오기