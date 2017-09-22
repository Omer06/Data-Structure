package com.datastructure.queue;

import com.entity.Person;

public class QueueMain {
	
	public static void main(String[] args) {
		
		/*IntQueue q = new IntQueue(4);
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		
		q.dequeue();
		
		q.enqueue(1);
		
		q.printAll();*/
		
		PersonQueue q  = new PersonQueue(4);
		
		q.enqueue(new Person("Ömer", "Bayrak"));
		q.enqueue(new Person("Ali", "Akar"));
		q.enqueue(new Person("Mahmut", "Akar"));
		q.enqueue(new Person("Abdurrahman", "Bayrak"));
		q.dequeue();
		q.enqueue(new Person("F", "Bayrak"));
		q.printAll();
		
		
		
		
		
		

		
		
	}

}
