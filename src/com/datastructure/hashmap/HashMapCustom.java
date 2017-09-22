package com.datastructure.hashmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashMapCustom<K, V> {

	private int size = 20;
	private int total = 0;
	private LinkedListCustom<V>[] valueListArray;
	private Set<K> keys = null;
	private Set<Integer> indexs = null;

	@SuppressWarnings("unchecked")
	public HashMapCustom() {
		valueListArray = new LinkedListCustom[size];
		keys = new HashSet<>();
		indexs = new HashSet<>();
	}

	public void add(K key, V value) {

		int actualKey = convertToActualKey(key);
		int index = convertToIndex(key);

		if (valueListArray[index] == null) {
			valueListArray[index] = new LinkedListCustom<>();
		} else if (valueListArray[index].has(actualKey)) {
			valueListArray[index].override(actualKey, value);
			return;
		}

		valueListArray[index].add(actualKey, value);
		keys.add(key);
		indexs.add(index);
		total++;
	}

	public V get(K key) {

		int index = convertToIndex(key);
		int actualKey = convertToActualKey(key);

		return valueListArray[index] == null ? null : valueListArray[index].getBy(actualKey);
	}

	public boolean remove(K key) {

		int index = convertToIndex(key);
		int actualKey = convertToActualKey(key);

		if (valueListArray[index] != null && valueListArray[index].remove(actualKey)) {
			total--;
			keys.remove(key);
			indexs.remove(indexs);
			return true;
		}

		return false;
	}

	public List<V> values() {
		List<V> values = new ArrayList<>();
		for (int index : indexs) {
			values.addAll(valueListArray[index].toList());
		}
		return values;
	}

	public void printAll() {
		for (int index : indexs) {
			valueListArray[index].printAll();
		}
	}

	public Set<K> keys() {
		return keys;
	}

	public int count() {
		return total;
	}

	@SuppressWarnings("unchecked")
	public void clear() {
		K[] keyArray = (K[]) keys.toArray();
		for (K k : keyArray) {
			this.remove(k);
		}
	}

	private int convertToActualKey(K key) {
		return key.hashCode();
	}

	private int convertToIndex(K key) {
		return key.hashCode() % size;
	}

}
