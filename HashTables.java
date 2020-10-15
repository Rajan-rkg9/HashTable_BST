package com.DataStructure.HashTables_BST;

import java.util.ArrayList;

public class HashTables<K, V> {
	 LinkedList<K> list;
	
	public HashTables() {
		this.list= new LinkedList<>();
	} 
	
	public V get(K key) {
		MapNode<K, V> mapNode = (MapNode<K, V>) this.list.searchElement(key);
		return (mapNode == null) ? null : mapNode.getValue();
	}
	
	public void add(K key, V value) {
		MapNode<K, V> mapNode = (MapNode<K, V>) this.list.searchElement(key);
		if(mapNode == null) {
			list.insert(new MapNode<K, V>(key, value));
		}
		else 
		{
			mapNode.setValue(value);
		}
	}

	@Override
	public String toString() {
		return "HashMap{" + list + "}";
	}
	
	public static void main(String[] args) {
		HashTables<String, Integer> hashTable= new HashTables<String, Integer>();
		String sentence = "To be or not to be";
		String wordsArray[] = sentence.toLowerCase().split(" ");
		for(String word: wordsArray)
		{
			if(hashTable.get(word) ==  null)
				hashTable.add(word, 1);
			else
				hashTable.add(word, hashTable.get(word) + 1);
		}
		System.out.println(hashTable);
	}
}
