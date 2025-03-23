package A07_Sorting;


public class QuickSort implements PersonenSort {

	/**
	 * Sortier-Funktion
	 */
	public void sort(Person[] personen) {
		sort(personen, 0, personen.length - 1);
	}

	private void sort(Person[] personen, int left, int right) {



		if(left>=right)
			return;

		int p = partition(personen, left, right);
		sort(personen, left, p - 1);
		sort(personen, p + 1, right);



	}

	private int partition(Person[] personen, int left, int right) {

		int p = right;
		//Person pivot = personen[right];

		int i = left-1;
		int k = right;


		do {

			do {
				i++;

			}while(i <= right && personen[i].compareTo(personen[p]) < 0 );


			do {
				k--;

			}while(k >= left && personen[k].compareTo(personen[p]) > 0 ) ;


			if(i<k) {
				Person copy = personen[i];
				personen[i] = personen[k];
				personen[k] = copy;
			}




		}while(i<k);

		Person copy = personen[right];
		personen[right] = personen[i];
		personen[i] = copy;


		return i;
	}
}