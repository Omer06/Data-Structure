package com.datastructure.hashmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LinkedListCustom<T> {

	private Node head; // the node of first added value
	private Node foot; // the node of last added value

	private class Node {
		private T value;
		private int key;
		private Node child;
		private Node parent;
		private boolean isAccesible = true; // head and foot node is not
											// accesible..!

		public Node(T value, boolean accesible) {
			this.isAccesible = accesible;
			this.value = value;
		}

		public Node(T value) {
			this.value = value;
		}
	}

	public LinkedListCustom() {
		head = new Node(null, false);
		foot = new Node(null, false);
		head.child = foot;
	}

	public void firstAdd(T item) {
		Node n = new Node(item);
		n.child = head.child;
		n.parent = head;
		head.child = n;
	}

	public void lastAdd(int key, T item) {
		foot.value = item;
		foot.isAccesible = true;
		foot.key = key;
		foot.child = new Node(null, false);
		foot.child.parent = foot;
		foot = foot.child;
	}

	public void add(int key, T item) {
		lastAdd(key, item);
	}

	public T getFirst() {
		return head.child.isAccesible ? head.child.value : null;
	}

	public T getLast() {
		return foot.parent.isAccesible ? foot.parent.value : null;
	}

	public T getBy(int key) {
		Node h = head.child;

		while (h.isAccesible) {
			if (h.key == key)
				return h.value;
			h = h.child;
		}

		return null;
	}

	public boolean remove(int key) {
		Node pNode = head;
		Node cNode = head.child;
		boolean result = false;
		while (cNode.isAccesible) {
			if (cNode.key == key) {
				pNode.child = cNode.child;
				result = true;
				break;
			}
			pNode = cNode;
			cNode = cNode.child;
		}

		return result;
	}

	public boolean has(int key) {
		Node node = head.child;
		while (node.isAccesible) {
			if (node.key == key)
				return true;
			node = node.child;
		}
		return false;
	}

	public void override(int key, T value) {
		Node node = head.child;
		while (node.isAccesible) {
			if (node.key == key) {
				node.value = value;
			}
			node = node.child;
		}
	}

	public void removeIf(Predicate<T> predicate) {
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

	public void sort(Comparator<T> comparable) {
		Node pNode = head.child;
		while (pNode.isAccesible) {
			Node cNode = pNode.child;
			while (cNode.isAccesible) {
				if (comparable.compare(pNode.value, cNode.value) > 0) {
					T pValue = pNode.value;
					pNode.value = cNode.value;
					cNode.value = pValue;
				}
				cNode = cNode.child;
			}
			pNode = pNode.child;
		}
	}

	public void printAll() {
		iterateBy(t -> {
			System.out.println(t);
		});
	}

	public Stream<T> stream() {
		return toList().stream();
	}

	public List<T> toList() {
		List<T> list = new ArrayList<>();
		iterateBy(value -> list.add(value));
		return list;
	}

	public void iterateBy(Consumer<T> consumer) {
		Node node = head.child;
		while (node.isAccesible) {
			consumer.accept(node.value);
			node = node.child;
		}
	}

}
