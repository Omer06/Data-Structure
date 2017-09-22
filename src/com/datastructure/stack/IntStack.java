package com.datastructure.stack;

public class IntStack {

	private int[] stack;
	private int top;
	private int size;

	public IntStack(int size) {
		top = -1;
		this.size = size;
		stack = new int[this.size];
	}

	public IntStack() {
		top = -1;
		this.size = 50;
		stack = new int[50];
	}

	public boolean push(int item) {
		if (!isFull()) {
			stack[++top] = item;
			return true;
		}
		return false;
	}
	
	public int pop() {
		return !isEmpty() ? stack[top--] : null;
	}

	public boolean isFull() {
		return (top == (stack.length - 1));
	}

	public boolean isEmpty() {
		return (top == -1);
	}

}
