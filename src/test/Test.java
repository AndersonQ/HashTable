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

package test;

import hash.HashTable;

public class Test {

	public static void main(String args[])
	{
		int[] lines;
		
		HashTable hash = new HashTable(20);
		System.out.println("HashTable created!");
		
		hash.add("Anderson", new int[] {1,2,3});
		hash.add("Joao", new int[] {2,3,4});
		hash.add("teste", new int[] {3,4,5});
				
		lines = hash.get("Anderson");
		System.out.print("Get Anderson: ");
		for(int i = 0; i < lines.length; i++)
		{
			System.out.printf("%d, ", lines[i]);
		}
		System.out.println();
		
		lines = hash.get("Joao");
		System.out.print("Get Joao: ");
		for(int i = 0; i < lines.length; i++)
		{
			System.out.printf("%d, ", lines[i]);
		}
		System.out.println();
		
		hash.printElements();
		
		System.out.println("Bye!");
	}
}
