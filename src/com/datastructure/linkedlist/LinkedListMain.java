package com.datastructure.linkedlist;

import java.util.stream.Collectors;

import com.entity.Person;

public class LinkedListMain {
	
	public static void main(String[] args) {
		
		/*LinkedListInt list = new LinkedListInt();
		
		list.lastAdd(5);
		list.lastAdd(9);
		list.lastAdd(1);
		list.lastAdd(22);
		list.lastAdd(13);
		list.lastAdd(6);
		list.lastAdd(554);
		list.lastAdd(21);
		list.lastAdd(34);
		list.printAll();
		list.sort((x,y) -> y.compareTo(x));
		System.out.println();
		list.printAll();*/
		
		
		LinkedListCustom<Person> personList = new LinkedListCustom<>();
		
		personList.add(new Person("Ömer", "Bayrak"));
		personList.firstAdd(new Person("Özcan", "Acar"));
		personList.lastAdd(new Person("Levent", "Ergüder"));
		
		personList.sort((person1,person2) -> person1.getName().compareTo(person2.getName()));
		personList.removeIf(person -> personList.getFirst().equals(person));
		
		Person person = personList.stream().filter(p -> p.getName().startsWith("Le")).findFirst().orElse(new Person("undefined", "undefined"));
		
		System.out.println(person.getName());
		
		
		
		
	}

}
