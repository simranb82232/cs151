package lab1;

public class Arrays {
	public static void swapLargestAndSmallest(int[] a) {
		int min = a[0];
		int max = a[0];
		int minIndex = 0;
		int maxIndex = 0;
		for (int i = 0; i < a.length; i++) {
			if (min > a[i]) {
				min = a[i];
				minIndex = i;
			}
			if (max < a[i]) {
				max = a[i];
				maxIndex = i;
			}
		}
		int temp = a[minIndex];
		a[minIndex] = a[maxIndex];
		a[maxIndex] = temp;
	}
}
