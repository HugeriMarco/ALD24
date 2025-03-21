package A07_Sorting;


public class QuickSort implements PersonenSort {

	/**
	 * Sortier-Funktion
	 */
	public void sort(Person[] personen) {
		sort(personen, 0, personen.length - 1);
	}

	private void sort(Person[] personen, int left, int right) {



		while(left<=right) {


			int p = partition(personen, left, right);
			sort(personen, left, p - 1);
			sort(personen, p + 1, right);
		}

	}

	private int partition(Person[] personen, int left, int right) {

		int p = right;
		int i = left-1;
		int k = right;


		do {

			do {
				i++;

			}while(personen[i].compareTo(personen[p]) < 1 && i <= right);


			do {
				k--;

			}while(personen[k].compareTo(personen[p]) > 1 && k >= left);


			if(i<k) {
				Person copy = personen[i];
				personen[i] = personen[k];
				personen[k] = copy;
			}




		}while(i<k);

		Person copy = personen[p];
		personen[p] = personen[i];
		personen[i] = copy;


		return i;
	}
}