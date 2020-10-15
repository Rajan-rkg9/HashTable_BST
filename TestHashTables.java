package com.DataStructure.HashTables_BST;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestHashTables {

	@Test
	public void givenASentence_WhenWordsAddedToHashTable_ShouldReturnWordFrequency() {
		HashTables<String, Integer> hashTable= new HashTables<String, Integer>();
		String sentence="to be or not to be";
		String wordsArray[] = sentence.toLowerCase().split(" ");
		for(String word : wordsArray) {
			if(hashTable.get(word) == null) {
				hashTable.add(word, 1);
			}
			else
			hashTable.add(word, hashTable.get(word) + 1);
		}
		int count=hashTable.get("to");
		System.out.println(hashTable);
		assertEquals(2, count);
	}

}
