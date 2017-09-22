package com.datastructure.binarysearch;

import java.lang.reflect.InvocationTargetException;

public class BinarySearchTree<V extends Comparable<V>> {

	private Node root = null;

	public class Node {

		private Node lc = null; // küçük
		private V data;
		private Node rc = null; // büyük

		public Node(V data) {
			this.data = data;
		}

		public Node() {
		}
	}

	public void add(V item) {
		Node node = new Node(item);

		if (root == null) {
			root = node;
			return;
		}

		Node p, c = root;
		do {
			p = c;
			c = item.compareTo(c.data) < 0 ? c.lc : c.rc;
		} while (c != null);

		if (item.compareTo(p.data) < 0)
			p.lc = node;
		else
			p.rc = node;
	}

	public Node findBy(Object key) {
		Node c = root;

		V instance = getInstance(key, c.data.getClass());

		do {
			if (instance.compareTo(c.data) == 0) {
				break;
			}
			c = instance.compareTo(c.data) < 0 ? c.lc : c.rc;
		} while (c != null);

		return c;
	}

	public Node findParentBy(Object key) {

		Node c = root;
		Node p = root;

		Comparable<V> instance = getInstance(key, c.data.getClass());

		do {
			if (instance.compareTo(c.data) == 0) {
				break;
			}
			p = c;
			c = (instance.compareTo(c.data) < 0) ? c.lc : c.rc;
		} while (c != null);

		return c != null ? p : null;
	}

	public V getData(Node node) {
		return node.data;
	}

	public void printAll(Node node) {
		Node p = node;
		if (p != null) {
			System.out.println(p.data);
			printAll(p.lc);
			printAll(p.rc);
		}
	}

	@SuppressWarnings("unchecked")
	private V getInstance(Object key, Class<?> class1) {
		try {
			return (V) class1.getConstructor(key.getClass()).newInstance(key);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
