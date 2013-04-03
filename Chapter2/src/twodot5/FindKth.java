package twodot5;

import java.util.Random;

public class FindKth {

	/**
	 * @param args
	 */ 
	public static void main(String[] args) {
		int [] arr = {10,3,4,5,1,2,8,7,9,6,0};
//		quicksort(arr,0 ,arr.length - 1);
//		for(int e : arr){
//			System.out.print(e + " ");
//		}
		int k = 3;
//		findKth3(arr,k);
//		for(int i = 0 ; i < k; i++)
//			System.out.print(arr[i] + " ");
//		
		System.out.println(findKth4(arr,k));
	}
	//不断的缩小范围
	public static int findKth1(int[] arr, int k ){
		float max = findMax(arr);
		float min = findMin(arr);
		float mid = 0;
		while(max - min > 0.5){
			mid = (max + min) /2;
			if(find(arr, mid) >= k)
				min = mid;
			else
				max = mid;
		}
		System.out.println("max: " + max +" min: " + min);
		int kthindex = 0;
		for (int i = 0 ; i < arr.length; i++){
			if(arr[i] >= min && arr[i] <= max){
				kthindex = i;
				break;
			}
		}
		return kthindex;
	}
	
	private static int find(int [] arr, float num){
		int N = 0;
		for(int i = 0 ; i < arr.length; i++) {
			if(arr[i] >= num){
				N++;
			}
		}
		return N;
	}
	private static int findMax(int[] arr){
		int maxIndex = 0;
		for(int i = 0 ; i < arr.length; i++){
			if(arr[i] > arr[maxIndex])
				maxIndex = i;
		}
		return arr[maxIndex];
		
	}
	private static int findMin(int[] arr){
		int minIndex = 0;
		for(int i = 0 ; i < arr.length; i++){
			if(arr[i] < arr[minIndex]){
				minIndex = i;
			}
		}
		return arr[minIndex];
	}
	
	//运用了快排的思想
	public static int findKth2(int[] arr, int left, int right ,int k ){
	
		int i = partition(arr,0,arr.length - 1);
		int j = right - i + 1; //a[i ~~ right]
		
		if(j == k ){
			return i;
		}
		if(j > k)//the kth is in the right subarray
			return findKth2(arr,i + 1, right, k);
		else{
			return findKth2(arr,left, i - 1, k - j);
		}
		
	}
	
//	private static void quicksort(int[]arr, int left, int right){
//		if(right > left){
//			int i =partition(arr, left, right);
//			quicksort(arr,0,i - 1);
//			quicksort(arr,i + 1, right);
//		}
//	}
	private static int partition(int[] arr, int left, int right ){
		Random r = new Random();
		int privot = left + r.nextInt(right - left + 1);
		swap(arr,privot, right);
		int i = left - 1;
		for(int j = left; j <right ; j++){
			if(arr[j] < arr[right]){
				swap(arr,j,++i);
			}
		}
		swap(arr,++i,right);
		return i;
	}
	private static void swap(int[] arr, int i , int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp ;
	}
	
	//建立一个大小为K最小堆
	public static void findKth3(int[]arr, int k ){
		buildMinHeap(arr, k);
		for(int i = k ; i < arr.length; i++){
			if(arr[i] > arr[0]){
				swap(arr,0,i);
			}
			minHeapify(arr,0,k);
		}
	}
	private static void buildMinHeap(int[] arr, int size){
		for(int i = size/2 - 1; i >= 0 ; i --){
			minHeapify(arr,i, size);
		}
	}
	private static void minHeapify(int[] arr, int i , int size){
		int left = left(i);
		int right = right(i);
		int least = i;
		if(left < size && arr[left] < arr [i])
			least = left;
		if(right < size && arr[right] < arr[i]){
			least = right;
		}
		if(least != i){
			swap(arr,least, i);
			minHeapify(arr, least,size);
		}
	}
	
	
	private static int left(int i ){
		return 2*i;
	}
	private static int right(int i ){
		return 2*i + 1;
	}
	
	//count sort,range limited
	
	public static int findKth4(int[]arr, int k ){
		int[] b = new int[findMax(arr) + 1];
		for(int i = 0; i < arr.length ; i++){
			b[arr[i]]++;
		}
		int sum = 0;
		int i = 0;
		for(i = b.length - 1; i >= 0; i--){
			sum += b[i];
			if(sum >=k){
				break;
			}
		}
		return i;
	}
	
//	private static int findMax(int[] arr){
//		int max = arr[0];
//		for(int i = 0 ; i < arr.length; i++){
//			if(arr[i] > max){
//				max = arr[i];
//			}
//		}
//		return max;
//	}
	
	
}
