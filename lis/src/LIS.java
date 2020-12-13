import java.util.Arrays;
import java.util.Random;

public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int n = rand.nextInt(99) + 1;
		int arr[] = new int[n];
		int temp[] = new int[arr.length];
		int maxVal = 0;
		for (int i = 0; i < n; ++i) {
			arr[i] = rand.nextInt(100);
		}
		
		for(int i = 0; i < temp.length; i++) {
			temp[i] = 1;
		}
		
		for(int i = 1; i < arr.length; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					temp[i] = Math.max(temp[i], temp[j] + 1);
				}
			}
		}
		
		for(int i = 0; i < temp.length; i++) {
			if(maxVal < temp[i]) {
				maxVal = temp[i];
			}
		}
		
		System.out.println("The number of random numbers in array are: " + n);
		System.out.println("The array is: ");
		System.out.println(Arrays.toString(arr));
		System.out.println("The array with subsequence is: ");
		System.out.println(Arrays.toString(temp));
		int longestSub = Arrays.stream(temp).max().getAsInt();
		System.out.println("The longest subsequence size is: " + longestSub);
	}
}