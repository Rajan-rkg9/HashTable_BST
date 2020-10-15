package com.DataStructure.HashTables_BST;

import java.util.ArrayList;

public class HashTables<K, V> {
	
	final int NUMBUCKETS;
	
	ArrayList<LinkedList<K>> bucketArray;
	
	public HashTables() {
		this.NUMBUCKETS = 10;
		this.bucketArray = new ArrayList<LinkedList<K>>();
		for(int i = 0 ; i < NUMBUCKETS ; i++)
			this.bucketArray.add(null);
	} 
	public int getIndex(K key) {
		int hashKey = Math.abs(key.hashCode());
		int index = hashKey % NUMBUCKETS;
		return index;
	}
	public V get(K key) {
		int index = getIndex(key);
		LinkedList<K> linkedList = bucketArray.get(index);
		if(linkedList == null)
			return null;
		MapNode<K, V> mapNode = (MapNode<K, V>)linkedList.searchElement(key);
		return (mapNode == null) ? null : mapNode.getValue();
	}
	
	public void add(K key, V value) {
		int index = getIndex(key);
		LinkedList<K> list = bucketArray.get(index);
		if(list == null)
		{
			list = new LinkedList<K>();
			bucketArray.set(index,list);
		}
		MapNode<K, V> mapNode = (MapNode<K, V>)list.searchElement(key);
		if(mapNode == null)
			list.append(new MapNode<K, V>(key, value));
		else 
			mapNode.setValue(value);
	}

	@Override
	public String toString() {
		return "HashMap{" + bucketArray + "}";
	}
	
	public static void main(String[] args) {
		HashTables<String, Integer> hashTable= new HashTables<String, Integer>();
		String sentence = "paranoid are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
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
