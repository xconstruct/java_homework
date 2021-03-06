/**
 * @author Constantin Schomburg <me@xconstruct.net>
 *
 * Übung 06 - Programmieren (Java) - Gruppe 6
 * 10.05.11 - 17.05.11
 */

package de.sim.sort;

import de.sim.enumeration.SortMode;
import de.sim.interfaces.ISortable;

/**
 * Sortierungsklasse
 */
public class Sort {

	/**
	 * Sortiert ein Array von Sortables mit Selection Sort
	 *
	 * @param array Sortables
	 * @param mode Sortierungsmodus
	 */
	public static void selectionSort(ISortable[] array, SortMode mode) {
		for (int pos = 0; pos < array.length; pos++) {

			// Finde kleinsten Wert
			int minPos = pos;
			String minString = array[minPos].getSortString(mode);
			for (int i = pos+1; i < array.length; i++) {
				String currString = array[i].getSortString(mode);
				if (currString.compareTo(minString) < 0) {
					minPos = i;
					minString = currString;
				}
			}

			// Tausche Werte
			ISortable tmp = array[pos];
			array[pos] = array[minPos];
			array[minPos] = tmp;
		}
	}

	/**
	 * Sortiert ein Array von Sortables mit Insertion Sort
	 *
	 * @param array Sortables
	 * @param mode Sortierungsmodus
	 */
	public static void insertionSort(ISortable[] array, SortMode mode) {
		for (int i = 1; i < array.length; i++) {
			ISortable value = array[i];
			int j = i;
			String valString = value.getSortString(mode);

			while (j > 0 && array[j-1].getSortString(mode).compareTo(valString) > 0) {
				array[j] = array[j-1];
				j--;
			}
			array[j] = value;
		}
	}

	/**
	 * Sortiert ein Array von Sortables
	 *
	 * @param array Sortables
	 * @param mode Sortierungsmodus
	 */
	public static void sort(ISortable[] array, SortMode mode) {
		insertionSort(array, mode);
	}
}
