package com.datastructure.hashmap;

import com.entity.Person;

public class HashMapMain {
	
	public static void main(String[] args) {
		
		HashMapCustom<String, Person> personMap = new HashMapCustom<>();
		
		personMap.add("Omer", new Person("Omer", "Bayrak"));
		personMap.add("Ali", new Person("Ali", "Akar"));
		personMap.add("Murat", new Person("Murat", "Küçük"));
		personMap.add("Can", new Person("Can", "Korkmaz"));
		
		System.out.println("- keys");
		personMap.keys().forEach(x -> System.out.println(x));
		
		System.out.println("- values");
		personMap.values().forEach(x -> System.out.println(x));
		
		System.out.println("- source person");
		System.out.println(personMap.get("Omer"));
		
		System.out.println("- count");
		System.out.println(personMap.count());
		
		personMap.clear();
		
		System.out.println("- count");
		System.out.println(personMap.count());
		
		
	}

}
