package objectOrientedProgram;

public class Person {
	private int age;
	private String name;
	
	public Person(String name) {
		setName(name);
	}
	
//	public void setAge(int age) {
//		if(age>=0 && age<=130) {
//			this.age = age;	
//		}
//		this.age = 0;
//	}
	
	public void setName(String name) {
		this.name = "Mr. " + name;
	}
	
//	public int getAge() {
//		if(age<=1 || age>=120) {
//			return -1;
//		}
//		return age;
//	}
	
	public String getName() {
		if(name == null) {
			return "Name is empty";
		}
		return name;
	}

}
