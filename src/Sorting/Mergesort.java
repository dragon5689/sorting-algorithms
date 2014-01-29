package Sorting;

import Helper.CountingSorter;
import Helper.Sorter;

public class Mergesort extends CountingSorter implements Sorter
{
	private int[] array;
	private int[] helperArray;
	private int length;

	/**
	 * sort an array
	 * 
	 * @param array
	 *            array to be sorted
	 */
	public void sort(int[] array)
	{
		this.array = array;
		length = array.length;

		// depending on variant...
		helperArray = new int[c((length + 1) / 2)];
		helperArray = new int[c(length)];
		mergesort(0, length - 1);
	}

	/**
	 * mergesort algorithm, divide and conquer
	 * 
	 * @param low
	 *            lower boundary
	 * @param high
	 *            upper boundary
	 */
	private void mergesort(int low, int high)
	{
		incrementRekursionDepth();

		if (low < high)
		{
			int middle = (low + high) / 2;
			mergesort(low, middle);
			mergesort(middle + 1, high);
			merge(low, middle, high);
		}
	}

	/**
	 * merge partial arrays
	 * 
	 * @param low
	 * @param middle
	 * @param high
	 */
	void merge(int low, int middle, int high)
	{
		int i, j, k;

		// copy both halves into the helperArray
		for (i = low; i <= high; i++)
			helperArray[c(i)] = array[c(i)];

		i = low;
		j = middle + 1;
		k = low;
		
		// copy back largest remaining element
		while (i <= middle && j <= high)
			if (helperArray[c(i)] <= helperArray[c(j)])
				array[c(k++)] = helperArray[c(i++)];
			else
				array[c(k++)] = helperArray[c(j++)];

		// copy back rest of first half (if neccessary)
		while (i <= middle)
			array[c(k++)] = helperArray[c(i++)];
	}

}
