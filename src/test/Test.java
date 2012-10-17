package test;

import hash.HashTable;

public class Test {

	public void main(String args[])
	{
		HashTable hash = new HashTable();
		System.out.println("HashTable created!");
		
		hash.add("Anderson", new int[] {1,2,3});
		hash.add("Joao", new int[] {2,3,4});
		
		hash.printElements();
		
		System.out.println("Bye!");
	}
}
