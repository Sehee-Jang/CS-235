package edu.ensign.cs235.dynamicarray;

public class DynamicArray_driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicArray<Integer> list = new DynamicArray<>();
		System.out.println("===== Add =====");
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(15);
		list.add(16);
		list.add(17);
		list.add(18);
		list.add(19);
		list.add(20);
		list.add(21);

		
		// Print the list
		for (int i = 0; i < list.get_size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println();
		System.out.println("------------");
		System.out.println("size is: " + list.get_size());
		System.out.println("------------");
		System.out.println();
		
		System.out.println("===== Remove =====");
		list.remove(18);
		list.remove(19);
		list.remove(20);
		
		for (int i = 0; i < list.get_size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("------------");
		System.out.println("size is: " + list.get_size());
		System.out.println("------------");

		


	}

}
