/*
 * Copyright 2012 Anderson Queiroz <contato(at)andersonq(dot)eti(dot)br>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OFFViewer. If not, see <http://www.gnu.org/licenses/>.
 */
package hash;

//TODO treat collisions: Without two different zones

public class HashTable {

	private final int weight = 2;
	private int size;
	private NodeT[] nodes;
	
	/**
	 * A Hash Table node
	 * @author Anderson Queiroz <contato(at)andersonq(dot)eti(dot)br>
	 *
	 */
	private class NodeT
	{
		private String key;
		private int[] lines;
		
		public NodeT(String key, int[] lines)
		{
			this.key = key;
			this.lines = lines;
		}
		
		/**
		 * Prints a hashtable node
		 */
		public String toString()
		{
			StringBuilder str = new StringBuilder();
			str.append(key);
			str.append(" -> lines: ");
			for(int l: lines)
			{
				str.append(l);
				str.append(" ");
			}
			
			return str.toString();
		}
	}
	
	/**
	 * Create HashTable with a default size 10
	 */
	public HashTable()
	{
		//Default size
		this.size = 10;
		nodes = new NodeT[size];
	}
	
	/**
	 * Create HashTable to 's' elements
	 * The table size is 120% of 's'
	 * @param s number of elements to be stored in hashtable
	 */
	public HashTable(int s)
	{
		//Define size as user defined
		this.size = s;
		nodes = new NodeT[size];
	}
	
	/**
	 * Add the value in the storage vector treating collisions
	 * TODO treat collisions!!!!!!
	 * @param key
	 * @param lines element to add
	 */
	public void add(String key, int[] lines)
	{
		//Get the hash value to key
		int hashkey  = getHash(key);
		//Position at nodes vector
		int pos = hashkey % this.size;
		
		nodes[pos] = new NodeT(key, lines);
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
		
		//Calculate the hash value
		for(int i = 0; i < keysize; i++)
		{
			hash = (key.charAt(i) - 97) * weight * (i+1);
		}

		return hash;
	}
	
	/**
	 * Debug method: print all nodes stotagede in hashtable
	 */
	public void printElements()
	{
		for(NodeT n: nodes)
		{
			if(n != null)
			{
				System.out.println(n.toString());
			}
		}
	}
}
