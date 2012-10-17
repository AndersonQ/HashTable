package hash;

import bin.tree.trie.*;

//How to treat collisions: Without two different zones

public class HashTable {

	private int size;
	private int[] weight;
	private NodeT[] nodes;
	
	/**
	 * Create HashTable with a default size
	 */
	public HashTable()
	{
		//Default size
		this.size = 50;
		//Initialize weight
		initWeight();
		//Initialize nodes with default value
	}
	
	/**
	 * Create HashTable to 's' elements
	 * The table size is 120% of 's'
	 * @param s number of elements to be stored in hashtable
	 */
	public HashTable(int s)
	{
		//Define size as 120% of size defined by user
		this.size = (int) Math.floor(1.20 * s);
	}
	
	/**
	 * Get the hash value to key
	 * @param key a string to calculate the hash value
	 * @return the hash value as a integer
	 */
	private int getHash(String key)
	{
		//Hash value to be returned
		int hash = 0;
		//key length
		int keysize = key.length();
		
		//Set key to lower case
		key = key.toLowerCase();
		
		for(int i = 0; i < keysize; i++)
		{
			hash = key.charAt(i) - 97;
		}

		return -1;
	}
	
	/**
	 * initialize weight vector
	 */
	private void initWeight()
	{
		weight = new int[26];
		
		for(int i = 0; i < 26; i++)
		{
			weight[i] = i + 1;
		}
		
	}
	
	private class NodeT
	{
		private String key;
	}
	
}
