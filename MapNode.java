package com.DataStructure.HashTables_BST;

public class MapNode<K , V> implements INode<K> {
	
	public K key;
	public V value;
	public MapNode<K, V> next;
	public MapNode(K key, V value) {
		this.key=key;
		this.value=value;
		this.next=null;
	}
	public K getData() {
		return key;
	}
	public void setData(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public MapNode<K, V> getNext() {
		return next;
	}
	public void setNext(INode<K> next) {
		this.next = (MapNode<K, V>)next;
	}
	@Override
	public String toString() {
		return key+":"+value+(this.getNext() == null ?"":" -> "+this.getNext());
	}
}
