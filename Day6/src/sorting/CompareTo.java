package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Employee	implements Comparable<Employee>{
	public int id;
	public String name;
	public int age;
	
	public Employee(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Employee e) {
		if(this.id > e.id)	{
			return 1;
		}
		else if (this.id < e.id)	{
			return -1;
		}
		return 0;
	}
	
}

class CompareByAge implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.age > o2.age) {
			return 1;
		}
		else if(o1.age < o2.age) {
			return -1;
		}
		return 0;
	}
	
}

public class CompareTo {

	public static void main(String[] args) {
		ArrayList<Employee> emp = new ArrayList<>();
		emp.add(new Employee(1, "Mark", 32));
		emp.add(new Employee(4, "Paul", 22));
		emp.add(new Employee(3, "Chris", 45));
		emp.add(new Employee(2, "Debby", 29));
		
		System.out.println("Before Sorting(Comparable)");
		for(Employee e : emp) {
			System.out.println(e);
		}
		
		Collections.sort(emp);
		
		System.out.println("After Sorting(Comparable)");
		for(Employee e : emp) {
			System.out.println(e);
		}
		
		System.out.println("------------------------");
		
		System.out.println("Before Sorting(Comparator)");
		for(Employee e : emp) {
			System.out.println(e);
		}
//		CompareByAge ageCompare = new CompareByAge();
//		Collections.sort(emp, ageCompare);
		Collections.sort(emp, new CompareByAge());
		
		System.out.println("After Sorting(Comparator)");
		for(Employee e : emp) {
			System.out.println(e);
		}
	}

}
