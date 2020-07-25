package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Student;

public class StreamApiLessons {
	
	/*
	 * Lessons :
	 * 
	 * 	#1 Filter -> Map, in this task, the flow goes by w.r.t each item in the list as it is picked 
	 * 		and goes through till the end unless it gets filtered out, later which we pick the next item.
	 * 		Meaning, if we had something like 'findFirst' or 'isExists', we would move out of the streaming 
	 * 		as soon as we find the first eligible element.   
	 */
	public static void main(String[] args) {
		final List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Dhvanan", null));
		students.add(new Student(2, "Kishan", null));
		students.add(new Student(3, "Shyam", null));
		students.add(new Student(4, "Dev", null));
		students.add(new Student(5, "John", null));

		System.out.println("Finding students with even ids");

		final List<Student> evenStudents = students.stream().filter(student -> {
			System.out.println("Checking for -> " + student);
			return student.getId() % 2 == 0;
		}).map(student -> {
			System.out.println("Adding the suffix 'Even' to -> " + student);
			student.setName(student.getName() + " Even");
			return student;
		}).collect(Collectors.toList());

		System.out.print("Even students are => " + evenStudents);

	}
}
