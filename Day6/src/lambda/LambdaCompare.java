package lambda;

import java.util.ArrayList;
import java.util.Collections;

class Employee	{

	private int id;
	private String name;
	private int age;
	
	public Employee(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}

public class LambdaCompare {

	public static void main(String[] args) {
		ArrayList<Employee> emps = new ArrayList<>();
		
		emps.add(new Employee(1, "Mark", 34));
		emps.add(new Employee(4, "Sandy", 24));
		emps.add(new Employee(2, "Karl", 30));
		emps.add(new Employee(3, "Chris", 40));
		
		System.out.println("Before Sorting: ");
		for(Employee e : emps) {
			System.out.println(e);
		}
		System.out.println("-----------------------");
		Collections.sort(emps, (o1, o2) -> {
			return o1.getName().compareTo(o2.getName());
		});
		System.out.println("After sorting");
		for(Employee e : emps) {
			System.out.println(e);
		}

	}

}
