//Patrick Mann: a1646630
//Xiang Guo: a1077337

public class FindLocation {

	public FindLocation() {

	}

	//Complexity = O(2m + n)
	public int[] getLocation(int[][] matrix, int value) {

		int[] location = new int[2];

		int i = 0;
		int j = 0;

		//Search first row, unit matrix value is equal to or greater
		for (i = 0; i < matrix.length; ++i) {

			//If value found, return position
			if (matrix[i][0] == value) {
				location[0] = j;
				location[1] = i;
				return location;
			}

			//If matrix value larger then value, end loop
			if (matrix[i][0] > value) {
				break;
			}
		}

		i--;

		if(i < 0) {
			location[0] = -1;
			location[1] = -1;
			return location;
		}

		//Go down column until you find the value or find a value larger then expected
		for (j = 1; j < matrix[0].length; ++j) {

			//System.out.println(j + ", " + i);
			
			//If value found, return position
			if (matrix[i][j] == value) {
				location[0] = j;
				location[1] = i;
				return location;
			}

			//If matrix value larger then value, move back a column
			if (matrix[i][j] > value) {
				i--;
				j--;

				//Value does not exist in matrix
				if (i < 0) {
					location[0] = -1;
					location[1] = -1;
					return location;
				}
			}

		}
		
		//At end of matrix (highest value), therefore value does not exist in array
		location[0] = -1;
		location[1] = -1;
		return location;

	}

}