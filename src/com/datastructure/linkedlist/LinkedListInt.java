package com.datastructure.linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LinkedListInt {

	private Node head; // en öndeki deðer
	private Node foot; // sondaki deðeri

	private class Node {
		private int value;
		private Node child;
		private Node parent;
		private boolean isAccesible = true; // head and foot node is not
											// accesible..!

		public Node() {
		}

		public Node(int value, boolean accesible) {
			this.isAccesible = accesible;
			this.value = value;
		}

		public Node(int value) {
			this.value = value;
		}
	}

	public LinkedListInt() {
		head = new Node(0, false);
		foot = new Node(0, false);
		head.child = foot;
	}

	public void firstAdd(int item) {
		Node n = new Node(item);
		n.child = head.child;
		n.parent = head;
		head.child = n;
	}

	public void lastAdd(int item) {
		foot.value = item;
		foot.isAccesible = true;
		foot.child = new Node(0, false);
		foot.child.parent = foot;
		foot = foot.child;
	}

	public void add(int item) {
		lastAdd(item);
	}

	public int getFirst() {
		return head.child.isAccesible ? head.child.value : null;
	}

	public int getLast() {
		return foot.parent.isAccesible ? foot.parent.value : null;
	}

	public void remove(int item) {
		Node pNode = head;
		Node cNode = head.child;
		while (cNode.isAccesible) {
			if (cNode.value == item) {
				pNode.child = cNode.child;
				break;
			}
			pNode = cNode;
			cNode = cNode.child;
		}
	}

	public void removeIf(Predicate<Integer> predicate) {
		Node pNode = head;
		Node cNode = head.child;
		while (cNode.isAccesible) {
			if (predicate.test(cNode.value)) {
				pNode.child = cNode.child;
				break;
			}
			pNode = cNode;
			cNode = cNode.child;
		}
	}

	public void sort() {
		Node pNode = head.child;
		while (pNode.isAccesible) {
			Node cNode = pNode.child;
			while (cNode.isAccesible) {
				if (pNode.value < cNode.value) {
					int pValue = pNode.value;
					pNode.value = cNode.value;
					cNode.value = pValue;
				}
				cNode = cNode.child;
			}
			pNode = pNode.child;
		}
	}
	
	public void sort(Comparator<Integer> comparable) {
		Node pNode = head.child;
		while (pNode.isAccesible) {
			Node cNode = pNode.child;
			while (cNode.isAccesible) {
				if (comparable.compare(pNode.value, cNode.value) == 1) {
					int pValue = pNode.value;
					pNode.value = cNode.value;
					cNode.value = pValue;
				}
				cNode = cNode.child;
			}
			pNode = pNode.child;
		}
	}

	public void printAll() {
		iterateBy(value -> { System.out.println(value); });
	}
	
	public Stream<Integer> stream(){
		return toList().stream();
	}
	
	public List<Integer> toList() {
		List<Integer> list = new ArrayList<>();
		iterateBy(value -> list.add(value));
		return list;
	}
	
	public void iterateBy(Consumer<Integer	> consumer) {
		Node node = head.child; 
		while (node.isAccesible) {
			consumer.accept(node.value);
			node = node.child;
		}
	}

}
