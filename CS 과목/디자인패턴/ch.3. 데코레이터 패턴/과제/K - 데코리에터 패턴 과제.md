~~~~ java
public class two_week {

public static void main(String[] args){

Ramen sinRamen = new Sin_Ramen();

sinRamen = new mandu(sinRamen);

sinRamen = new Rice_cake(sinRamen);

System.out.println(sinRamen.getRamen()+" : "+" 가격 "+sinRamen.cost()+"원 맵기는 "+sinRamen.spicy()+ "입니다.");

  

Ramen jinRamen = new Jin_Ramen();

jinRamen = new Rice_cake(jinRamen);

jinRamen = new egg(jinRamen);

System.out.println(jinRamen.getRamen()+" : "+" 가격 "+jinRamen.cost()+"원 맵기는 "+jinRamen.spicy()+ "입니다.");

}

}

// 라면

abstract class Ramen{

String main = "라면";

public String getRamen(){

return main;

}

  

public abstract int cost();

public abstract int spicy();

}

// 신라면

class Sin_Ramen extends Ramen {

public Sin_Ramen() { super.main = "신라면";}

  

public int cost() { return 700; }

public int spicy(){return 5;}

}

// 진라면

class Jin_Ramen extends Ramen {

public Jin_Ramen() { super.main = "진라면"; }

public int cost() { return 750; }

public int spicy(){return 6;}

}

  
  

// 사이드

abstract class Side extends Ramen{

Ramen ramen;

public abstract String getRamen();

}

// 만두추가

class mandu extends Side{

public mandu(Ramen main){

this.ramen = main;

}

public String getRamen(){

return "만두" + ramen.getRamen();

}

public int cost(){

return ramen.cost()+1000;

}

public int spicy(){

return ramen.spicy();

}

}

// 떡추가

class Rice_cake extends Side{

public Rice_cake(Ramen main){

this.ramen = main;

}

  

public String getRamen(){

return "떡" + ramen.getRamen();

}

  

public int cost(){

return ramen.cost()+500;

}

public int spicy(){

return ramen.spicy();

}

}

//계란

class egg extends Side{

public egg(Ramen main){

this.ramen = main;

}

  

public String getRamen(){

return "계란" + ramen.getRamen();

}

  

public int cost(){

return ramen.cost()+500;

}

public int spicy(){

return ramen.spicy()-1;

}

}
~~~~
## 추상화와 캡슐화의 차이점
추상화 : 공통되는 성격 변수 특징을 묶어서 상위 클래스로 만드는 것
캡슐화 : 변수나 함수를 클래스로 묶어서 외부로 부터 보호하는 것.

## 왜 불필요한 메서드까지 상속하면 안되는지
상위 클래스에 맞춰서 해야 되기 때문에  불필요한 코드나 중복되는 코드가 많아질 수 있다.

## 새로운 예제 만들어오기

