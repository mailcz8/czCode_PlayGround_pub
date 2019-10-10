package objectOrientedProgram;

public class PersonTest1 {

	public static void main(String[] args) {
//		Person p1 = new Person();
//		p1.setAge(10);
//		p1.setName("King kong");
//		System.out.println(p1.getName() + p1.getAge());
		
		String[] names = { "Thomas", "Chang", "Savio" };
		buildPeople(names);
	}
	
	static Person[] buildPeople(String[] names){
		for(String n:names) {
			Person p = new Person(n);
			p.getName();
		}
		return null;
	}

}
