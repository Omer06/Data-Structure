package com.datastructure.queue;

import com.entity.Person;

public class PersonQueue {

	private Person[] queue;
	private int size = 50;
	private int front = -1;
	private int rear = -1;
	private int total = 0;

	public PersonQueue(int size) {
		this.size = size;
		queue = new Person[this.size];
	}

	public PersonQueue() {
		queue = new Person[this.size];
	}

	public boolean enqueue(Person item) {
		if(isFull()) return false;
		
		total++;
		queue[++rear % size] = item;
		return true;
	}

	public Person dequeue() {
		total--;
		return queue[++front % size];
	}

	public boolean isEmpty() {
		return (total == 0);
	}

	public boolean isFull() {
		return (total == size);
	}
	
	public int population() {
		return total;
	}
	
	public void printAll(){
		int f = front;
		
		for (int i = 0; i < total; i++) {
			System.out.println(queue[++f % size]);
		}
	}
}
