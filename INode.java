package com.DataStructure.HashTables_BST;

public interface INode<K> {
	K getData();
	
	void setData(K data);
	
	INode<K> getNext();
	
	void setNext(INode<K> next);
}
