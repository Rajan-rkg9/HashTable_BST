package com.DataStructure.HashTables_BST;

public class LinkedList<K> {
	INode<K> head;
	INode<K> tail;
	int size;
	public LinkedList() {
		super();
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public void insert(INode<K> newNode) {
		if (this.head == null) {
			this.head = newNode;
		}
		if (this.tail == null) {
			this.tail = newNode;
		} 
		else
		{
			INode<K> current = this.head;
			this.head = newNode;
			this.head.setNext(current);
		}
		this.size++;
	}
	public void append(INode<K> newNode)
	{
		if(this.head == null)
			this.head = newNode;
		if(this.tail == null)
			this.tail = newNode;
		else
		{
			this.tail.setNext(newNode);
			this.tail = this.tail.getNext();
		}
		this.size++;
	}
	public void insertAfter(INode<K> newNode1 , INode<K> newNode2)
	{
		INode<K> current = newNode1.getNext();
		newNode1.setNext(newNode2);
		newNode2.setNext(current);
	}
	public INode<K> popFirstElement()
	{
		INode<K> current = this.head;
		this.head = current.getNext();
		return current;
	}
	public INode<K> popLastElement()
	{
		INode<K> prev = null;
		INode<K> current = this.head;
		while(current.getNext() != null)
		{
			prev = current;
			current = current.getNext();
		}
		prev.setNext(current.getNext());
		return current;
	}
	public INode<K> searchElement(K key)
	{
		INode<K> current = this.head;
		while(current != null)
		{
			if(current.getData() == key)
				return current;
			current = current.getNext();
		}
		return null;
	}
	public void insertAfterAnElement(K input , INode<K> newNode)
	{
		INode<K> current = this.head;
		while(current != null)
		{
			if(current.getData() == input)
				break;
			else
			{
				INode<K> temp = current.getNext();
				current.setNext(newNode);
				current.getNext().setNext(temp);
				if(current == this.tail)
					this.tail = newNode;
			}							
		}
	}
	public void remove(K input) {
		INode<K> current = this.head;
		if (current == this.tail && current != null) {
			if (current.getData() == input) 
			{
				this.head = null;
				this.tail = null;
			}
		} 
		else if (current != null) {
			while (current != this.tail && !(current.getNext().getData() == input)) {
				current = current.getNext();
			}
			if (current != this.tail) {
				INode<K> deletedElement = current.getNext();
				current.setNext(deletedElement.getNext());
				deletedElement.setNext(null);
				if (deletedElement == this.tail) {
					this.tail = current;
				}
			}
		}
	}
	public  void display()
	{
		INode<K> current = this.head;
		if(current != null) {
		System.out.print(current.getData());
		while((current =current.getNext()) != null)
		{
			System.out.print("->" + current.getData());
		}
		}
	}
	@Override
	public String toString() {
		return "[" + this.head + "]";
	}
}
