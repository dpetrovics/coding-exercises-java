import java.util.Arrays;


public class Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {12, 5, 13, 7, 21, 1, 4, 64, 9, 32, 3, 8, 6};
		System.out.println("Unsorted: " + Arrays.toString(nums));
		System.out.println(Arrays.toString(bubblesort(nums)));
		System.out.println(Arrays.toString(selectionsort(nums)));
		System.out.println(Arrays.toString(insertionsort(nums)));

	}
	
	//swaps side by side numbers if necessary until nums is ordered. O(n^2).
	public static int[] bubblesort(int[] nums) {
		int temp;
		int counter=0;
		boolean sorted=false;
		while (sorted==false) {
			sorted=true;
			for (int i=0; i<nums.length-1; i++) {
				counter++;
				if (nums[i]>nums[i+1]) {
					temp = nums[i];
					nums[i]=nums[i+1];
					nums[i+1]=temp;
					sorted=false;
				}
			}
		}
		System.out.println("Bubble Sort Counter: " + counter);
		return nums;
	}
	
	//selects the min number in the array and places it at the front of the unsorted numbers. 
	//repeat till sorted. O(n^2)
	public static int[] selectionsort(int[] nums) {
		int min;
		int minIndex;
		int a = 0;
		int temp;
		int counter=0;
		
		while (a<nums.length-1) {
			min=nums[a];
			minIndex=-1;
			//find min
			for (int i=a+1; i<nums.length; i++) {
				if (nums[i]<min) {
					min = nums[i];
					minIndex=i;
				}
				counter++;
			}
			//swap
			if (minIndex!=-1) {
				temp = nums[a];
				nums[a]=nums[minIndex];
				nums[minIndex]=temp;
			}
			a++;
		}
		System.out.println("Selection sort counter: " + counter);
		return nums;
	}
	
	// take elements from the list one by one and insert them 
	//in their correct position into a new sorted list
	public static int[] insertionsort(int[] nums) {
		int counter=0;
		int temp;
		
		for (int i=1; i<nums.length; i++) {
			for (int j=i; j>0; j--) {
				if (nums[j]<nums[j-1]) {
					temp=nums[j];
					nums[j]=nums[j-1];
					nums[j-1]=temp;
				}
				counter++;
			}
		}
		System.out.println("Insertion sort counter: " + counter);
		return nums;
	}
	
	//mergesort
	
	//quicksort
	
	//heapsort
}
