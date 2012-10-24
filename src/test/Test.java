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

package test;

import hash.HashTable;

public class Test {

	public static void main(String args[])
	{
		HashTable hash = new HashTable();
		System.out.println("HashTable created!");
		
		hash.add("Anderson", new int[] {1,2,3});
		hash.add("Joao", new int[] {2,3,4});
		
		hash.printElements();
		
		System.out.println("Bye!");
	}
}
