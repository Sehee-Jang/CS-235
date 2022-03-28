package edu.ensign.cs235.dynamicarray;

import java.util.Arrays;

public class DynamicArray<T> {
	private static final int DEFAULT_CAPACITY = 20;
	private int capacity;
	private int size;
	private Object[] elements;
	T[] array;

	// Default Constructor
	public DynamicArray() {
		this(DEFAULT_CAPACITY);
	}

	// Custom Constructor
	public DynamicArray(final int capacity) {
		this.size = 0;
		this.capacity = capacity;
		array = (T[]) new Object[DEFAULT_CAPACITY];

	}

	// Methods
	public void add(T element) {
		if (this.size == this.array.length) {
			T[] temp = (T[]) Arrays.copyOf(this.array, capacity);
			this.array = (T[]) new Object[this.capacity * 2];
			this.capacity = this.capacity * 2;

			for (int i = 0; i < temp.length; ++i) {
				this.array[i] = temp[i];
			}
		}
		this.array[this.size] = element;
		this.size++;

	}

	public int remove(final int idx) {

		// Check the array
		if (idx >= 0 && idx < this.capacity) {

			// Remove idx

			this.array[idx] = null;
			if ((this.array.length > DEFAULT_CAPACITY) || (this.size * 4) <= this.capacity) {

				this.array = Arrays.copyOf(this.array, this.capacity / 2);
				this.capacity = this.capacity / 2;
			}
			this.size--;
		} else
			System.out.println("idx out of bound");

		return idx;
	}

	// putting element
	public void put(final int idx, T element) {

		// if idx is betwween 0 - capacity of array
		if (array == null)
			return;
		else
			array[idx] = element;
	}

	public T get(final int idx) {
		if (array == null) {
			return null;
		} else
			return array[idx];
	}

	public int get_size() {
		return array.length;
	}

	public boolean is_empty() {
		if (!(array == null)) // if size is == 0
			return true;
		else
			return false;
	}

}
