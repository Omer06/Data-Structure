package com.datastructure.stack;

import com.entity.Person;

public class StackMain {
	
	public static void main(String[] args) {
		/*IntStack intStack = new IntStack(3);
		
		System.out.println(intStack.push(1));
		System.out.println(intStack.push(2));
		System.out.println(intStack.push(3));
		
		System.out.println(intStack.pop());
		System.out.println(intStack.pop());
		System.out.println(intStack.pop());
		System.out.println(intStack.pop());*/
		
		PersonStack personStack = new PersonStack(4);
		
		personStack.push(new Person("�mer", "Bayrak"));
		personStack.push(new Person("Ali", "Akar"));
		personStack.push(new Person("�mer", "Akar"));
		personStack.push(new Person("�evval Nur", "Bayrak"));
		
		System.err.println(personStack.pop());
		System.err.println(personStack.pop());
		System.err.println(personStack.pop());
		System.err.println(personStack.pop());
	}

}
