package A07_Sorting;


public class QuickSort implements PersonenSort {

	/**
	 * Sortier-Funktion
	 */
	public void sort(Person[] personen) {
		sort(personen, 0, personen.length - 1);
	}

	private void sort(Person[] personen, int left, int right) {
		// TODO: Implementation

		int i;

		if(right > left)
		{
			i = partition(personen,left,right);
			sort(personen, left,i-1);
			sort(personen, i+1,right);

		}

//		Falls re > li dann:
//		i := partition(li,re)
//		quicksort(li,i-1);
//		quicksort(i+1,re);

	}

	private int partition(Person[] personen, int left, int right) {
		// TODO: Implementation

		Person pivot = personen[right];
		int i=left-1;
		int k=right;

		Person copy;


		do {

			do {
				i++;

			}while(i<=right && personen[i].compareTo(pivot) < 0);

			do {
				k--;

			}while(k>=left && personen[k].compareTo(pivot) > 0);

			if (i < k)
			{
				copy = personen[i];
				personen[i] = personen[k];
				personen[k] = copy;
			}

		} while(i<k);

		copy = personen[i];
		personen[i] = personen[right];
		personen[right] = copy;


		return i;
	}
}