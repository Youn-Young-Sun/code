
public class PersonTest {

	public static void main(String[] args) {
		Person p1=new Person(); //기본 생성자 호출
		p1.name="홍길동";
		p1.isHungry=true;
		System.out.println(p1.name+" : "+p1.isHungry);
		p1.eat();
		System.out.println(p1.name+" : "+p1.isHungry);
		
		Person p2=new Person();
		p2.name="임꺽정";
		p2.isHungry=true;
		System.out.println(p2.name+" : "+p2.isHungry);
		System.out.println(p1.name+" : "+p1.isHungry);
	}

}
