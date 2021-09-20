
public class Person {
private String name;
int age;
boolean isHungry;
private int score;

public Person(){//생성자
	System.out.println("저는 기본 생성자입니다");
}



public void setScore(int score) {
	this.score=score;
}
public int getScore() {
	return this.score;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public boolean isHungry() {
	return isHungry;
}
public void setHungry(boolean isHungry) {
	this.isHungry = isHungry;
}
	//설정자(setter) : 반환유형void, 함수이름은 set변수명, 파라메터는 대상 변수의 타입
	public void setName(String name) {
		this.name=name;
		
		}
			
	}
	//접근자(getter) : 반환유형은 대상변수의타입, 함수이름은 get변수명, 파라메터는 없음
	public String getName() {
		return this.name;
	}

void eat() {
	System.out.println("냠냠");
	isHungry=false;
}
void work() {
	System.out.println("열심");
	isHungry=true;
}
}
