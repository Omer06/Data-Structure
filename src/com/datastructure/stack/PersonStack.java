package com.datastructure.stack;

import com.entity.Person;

public class PersonStack {

	private Person[] stack;
	private int top = -1;
	private int size;
	
	public PersonStack() {
		this.size = 50;
		stack = new Person[50];
	}
	
	public PersonStack(int size) {
		this.size = size;
		stack = new Person[size];
	}
	
	public boolean push(Person item){
		if(!isFull()){
			stack[++top] = item;
			return true;
		}
		return false;
	}
	
	public Person pop() {
		return !isEmpty() ? stack[top--] : new Person("undefined", "undefined");
	}
	
	
	public boolean isFull() {
		return (top == stack.length - 1);
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	
	
}
