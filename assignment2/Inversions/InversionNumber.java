//Patrick Mann: a1646630
//Xiang Guo: a1077337

import java.lang.Math;

public class InversionNumber {

	public InversionNumber() {

	}

	public int getInversionNumber(int[] inarr) {
		SortData data = count(inarr);

		return data.inversions;
	}
	
	public SortData count(int[] data) {

		SortData sort_data = new SortData(data);

		//Only one value, already sorted
		if (data.length == 1) {
			return sort_data;
		}
		else {
			//Split array
			int first_length = (int) Math.floor(data.length / 2);
			int second_length = data.length - first_length;
			int[] set1 = new int[first_length];
			int[] set2 = new int[second_length];

			System.arraycopy(data, 0, set1, 0, set1.length);
			System.arraycopy(data, set1.length, set2, 0, set2.length);

			//Call recursive functions
			SortData data_set1 = count(set1);
			SortData data_set2 = count(set2);

			//Sort
			int set1_count = 0;
			int set2_count = 0;
			int displacement;

			sort_data.inversions = data_set1.inversions + data_set2.inversions;

			for (int i = 0; i < data.length; i++) {
				//If the value in first array is smaller then the value from second array, put the first value into final array
				if (data_set1.data[set1_count] < data_set2.data[set2_count]) {
					sort_data.data[i] = data_set1.data[set1_count];
					set1_count++;

					//If last pair
					if(data_set1.data.length == set1_count && (data_set2.data.length - 1) == set2_count) {
						i++; 
						sort_data.data[i] = data_set2.data[set2_count];
					}
				}
				//Otherwise put the second array value into the final array
				//And add inversions
				else {
					displacement = data_set1.data.length - set1_count;
					sort_data.data[i] = data_set2.data[set2_count];
					set2_count++;
					sort_data.inversions += displacement;

					//If last pair
					if(data_set2.data.length == set2_count && data_set1.data.length - 1 == set1_count) {
						i++;
						sort_data.data[i] = data_set1.data[set1_count];
					}
				}

				//If no more values in first array
				if (data_set1.data.length == set1_count && data_set2.data.length != (set2_count - 1) && i + 1 < data.length) {
					i++;
					while(i < data.length) {
						sort_data.data[i] = data_set2.data[set2_count];
						set2_count++;

						i++;
					}
				}
				//If no more values in second array
				else if (data_set1.data.length != (set1_count - 1) && data_set2.data.length == set2_count && i + 1 < data.length) {
					i++;
					while (i < data.length) {
						sort_data.data[i] = data_set1.data[set1_count];
						set1_count++;
						i++;
					}
				}
			}

			return sort_data;

		}
	}
}