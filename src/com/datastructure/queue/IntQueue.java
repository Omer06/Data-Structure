package com.datastructure.queue;

public class IntQueue {

	private int[] queue;
	private int size = 50;
	private int front = -1;
	private int rear = -1;
	private int total = 0;
	
	public IntQueue(int size){
		this.size = size;
		queue = new int[this.size];
	}
	
	public IntQueue(){
		queue = new int[this.size];
	}
	
	
	public boolean enqueue(int item) {
		if(isFull())
			return false;
		
		total++;
		rear = (rear + 1) % size;
		queue[rear] = item;
		return true;
	}
	
	public int dequeue(){
		total--;
		front = (front + 1) % size;
		return queue[front];
	}
	
	public boolean isFull(){
		return (total == size);
	}
	
	public boolean isEmpty(){
		return (rear == -1);
	}
	
	public void printAll(){
		int f = front;
		
		for (int i = 0; i < total; i++) {
			f = (f + 1) % size;
			System.out.println("Item : " + queue[f]);
		}
	}
	
}
