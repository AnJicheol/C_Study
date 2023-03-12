

~~~~ java
import javax.sql.rowset.spi.SyncResolver;

  

public class one_week {

public static void main(String[] args){

Ramen bibimRamen = new Ramen();

bibimRamen.setRamen_type(new Bibim_ramen());

bibimRamen.ramen_pr();

bibimRamen.ramen_pr();

bibimRamen.set_spicy(3);

bibimRamen.get_spicy();

  

Ramen Raccoon_Ramen = new Ramen();

Raccoon_Ramen.setRamen_type(new Raccoon_Ramen());

Raccoon_Ramen.ramen_pr();

Raccoon_Ramen.set_spicy(5);

}

}

// 인터페이스

interface Ramen_type{

void print();

}

interface Dumpling{

void dumpling_add();

}

// 매인 클래스

class Ramen {

Ramen_type ramen_type;

private int spicy;

public Ramen(){

}

  

public void set_spicy (int sp){

this.spicy = sp;

}

public void get_spicy(){

System.out.println("라면의 맵기는 "+this.spicy+" 입니다");

}

public void setRamen_type (Ramen_type rt){

ramen_type = rt;

}

public void ramen_pr(){

ramen_type.print();

}

}

// 서브 클래스

class Bibim_ramen implements Ramen_type{

public void print(){

System.out.println("비빔면 입니다.");

}

}

  

class Shin_Ramen implements Ramen_type{

public void print(){

System.out.println("신라면 입니다.");

}

}

  

class Raccoon_Ramen implements Ramen_type ,Dumpling{

public void print(){

System.out.println("너구리라면 입니다.");

}

public void dumpling_add(){

System.out.println("만두추가.");

}

}
~~~~

왜 상위 형식에 맞추어 프로그래밍 해야하는지 알아오기

객체를 변수에 대입 할 때 상위형식을 구체적으로 구현한 형식이라면 어떤 객체든 넣을 수 있기 때문이다. 