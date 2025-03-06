package A07_Sorting;


public class BubbleSort implements PersonenSort {

	/**
	 * Sortier-Funktion
	 */
	public void sort(Person[] personen) {


		Person copy = null;
		boolean swapped = false;

		for (int i = 0; i < personen.length; i++) {
			swapped = false;


			for (int j = 0; j < personen.length - 1 - i; j++) {

				if( personen[j].compareTo(personen[j+1]) > 0)
				{
					copy = personen[j];
					personen[j] = personen[j+1];
					personen[j+1] = copy;
					swapped = true;
				}



			}
			if (!swapped)
				break;

		}
		


	}
	
}
