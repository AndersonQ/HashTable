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
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package hash;

//TODO treat collisions: Without two different zones

public class HashTable {

	private final int weight = 2;
	private int size;
	private Node[] nodes;
	
	/**
	 * A Hash Table node
	 * @author Anderson Queiroz <contato(at)andersonq(dot)eti(dot)br>
	 *
	 */
	private class Node
	{
		/* The key */
		private String key;
		/* The element */
		private int[] element;
		/* A pointer to next node, to solve collisions */
		private Node next;
		
		
		public Node(String key, int[] lines)
		{
			this.key = key;
			this.element = lines;
			this.next = null;
		}
		
		/**
		 * Prints a hashtable node
		 */
		public String toString()
		{
			StringBuilder str = new StringBuilder();
			str.append(key);
			str.append(" -> lines: ");
			for(int l: element)
			{
				str.append(l);
				str.append(" ");
			}
			
			return str.toString();
		}
	}
	
	private class HashTableOverflow extends Exception
	{
		private String message;
		
		public HashTableOverflow(String message)
		{
			this.message = String.format("Error: HashTable Overflow! %s", message);
		}
		
		public void print()
		{
			System.out.println(this.message);
		}
	}
	
	/**
	 * Create HashTable with a default size 10
	 */
	public HashTable()
	{
		//Default size
		this.size = 10;
		nodes = new Node[size];
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
		nodes = new Node[size];
	}
	
	/**
	 * Add the value in the storage vector treating collisions
	 * TODO treat collisions!!!!!!
	 * @param key
	 * @param lines element to add
	 */
	public boolean add(String key, int[] lines)
	{
		//Get the hash value to key
		//Position at nodes vector
		int pos = getHash(key);
		
		//Collision! Solve it!
		if (nodes[pos] != null)
		{
			try
			{
				return solveCollision(key, pos, lines);
			} 
			catch (HashTableOverflow e) {
				//e.printStackTrace();
				e.print();
				return false;
			}
		}
		else
		{
			System.out.println();
			nodes[pos] = new Node(key, lines);
			return true;
		}
	}
	
	private boolean solveCollision(String key, int hashkey, int[] lines) throws HashTableOverflow
	{
		Node tmpnode = nodes[hashkey];
		
		//Find the last collision node
		while(tmpnode.next != null)
		{
			tmpnode = tmpnode.next;
		}
		int tmp = hashkey + 1;
		int i = 0;
		while(nodes[tmp] != null && i < nodes.length)//&& ((tmp % this.size) == (hashkey - 1)))
		{
			++i;
			++tmp;
		}
		//OverFlow!
		if(!(i < nodes.length))//(tmp % this.size) == (hashkey - 1))
		{
			throw new HashTableOverflow(String.format("Impossible add key: %s", key));
		}
		else
		{
			nodes[tmp] = new Node(key, lines);
			tmpnode.next = nodes[tmp];
		}
		return true;
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
			hash += (key.charAt(i)) * weight * (i+1);
		}
		
		return hash % this.size;
	}
	
	/**
	 * Search for a key
	 * @param key a key to find
	 * @return a node that store the key, or null
	 */
	private Node find(String key)
	{
		int pos = getHash(key);
		
		for(Node tmp = nodes[pos]; tmp != null; tmp = tmp.next)
		{
			if(tmp.key.compareTo(key) == 0)
			{
				return tmp;
			}
		}
		return null;
	}
	
	/**
	 * Get the element pointed by a key
	 * @param key a key that represents the element
	 * @return the element pointed by key or null, it it was not found
	 */
	public int[] get(String key)
	{	
		Node n = find(key);
		if(n != null)
		{
			return n.element;
		}
		else
		{
		return null;
		}
	}
	
	/**
	 * Debug method: print all nodes stored in hashtable
	 */
	public void printElements()
	{
		for(Node n: nodes)
		{
			if(n != null)
			{
				System.out.println(n.toString());
			}
		}
	}
}