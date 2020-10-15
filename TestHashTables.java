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

	@Test
	public void givenASentence_WhenWordsAddedToHashTable_ShouldReturnParanoidFrequency() {
		HashTables<String, Integer> hashTable= new HashTables<String, Integer>();
		String sentence= "paranoid are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
		String wordsArray[] = sentence.toLowerCase().split(" ");
		for(String word: wordsArray) {
			if(hashTable.get(word) == null)
				hashTable.add(word, 1);
			else 
				hashTable.add(word, hashTable.get(word)+1);;
		}
		int count = hashTable.get("paranoid");
		System.out.println(hashTable);
		assertEquals(4, count);
	}
	
	@Test
	public void givenASentenceWordsAddedToHashMapWordWhenWordRemovedAndSearchedShouldReturnNull() {
		HashTables<String, Integer> hashTable= new HashTables<String, Integer>();
		String sentence= "paranoid are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
		String wordsArray[] = sentence.toLowerCase().split(" ");
		for(String word: wordsArray) {
			if(hashTable.get(word) == null)
				hashTable.add(word, 1);
			else 
				hashTable.add(word, hashTable.get(word)+1);;
		}
		System.out.println(hashTable);
		hashTable.remove("avoidable");
		Integer count=hashTable.get("avoidable");
		assertEquals(null, count);
}
