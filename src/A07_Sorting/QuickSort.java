package A07_Sorting;


public class QuickSort implements PersonenSort {

	/**
	 * Sortier-Funktion
	 */
	public void sort(Person[] personen) {
		sort(personen, 0, personen.length - 1);
	}

	private void sort(Person[] personen, int left, int right) {

		if(left<right) {

			int p = partition(personen, left, right);
			sort(personen, left, p - 1);
			sort(personen, p + 1, right);

		}

	}

	private int partition(Person[] personen, int left, int right) {


		Person pivot = personen[right];

		int i = left-1;
		int k = right;

		Person copy;

		do {

			do {

				i++;




			}while(i<=right && personen[i].compareTo(pivot)<0);

			do {
				k--;




			}while(k>=left && personen[k].compareTo(pivot)>0);

			if(i<k) {
				copy = personen[i];
				personen[i] = personen[k];
				personen[k] = copy;
			}




		}while(i<k);

		copy = personen[i];
		personen[i] = personen[right];
		personen[right] = copy;


		return i;



	}
}