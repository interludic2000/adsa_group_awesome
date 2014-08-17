//Simply used to return both current conversions and an array of data
public class SortData {
	public int inversions;
	public int[] data;

	public SortData(int[] initData) {
		this.inversions = 0;
		this.data = new int[initData.length];
		this.data = initData;
	}
}