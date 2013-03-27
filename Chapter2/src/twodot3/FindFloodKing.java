package twodot3;

/**
 * 
 * 2013.3.27
 * 这本书确实是本好书
 * @author gengchen
 *
 */
public class FindFloodKing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data1 = {4,1,2,3,4,5,4,1,4,4,4,4,4,3,5,7,9,4,4,1,2,3};
		System.out.println(findtheOne(data1));
		
		int[] data2 = {1,2,3,5,6,7,1,2,3,1,4,5,2,3,1,3,2,2,3,1,1,2,2,3,3};
		int[] result = findtheOneExtention(data2);
		for(int r : result){
			System.out.println(r+ "  ");
		}
	}
	
	public static int findtheOne(int [] data){
		int count = 0;
		int theone = 0;
		for(int i = 0 ; i <data.length; i++){
			if(count == 0){
				theone = data[i];
				count ++;
			}
			
			if(data[i] == theone){
				count ++;
			}
			if(data[i] != theone){
				count --;
			}
		}
		return theone;
	}
	
	public static int[] findtheOneExtention(int[] data){
		int [] candidates = {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
		int[]counts = {0,0,0};
		
		
		for(int i = 0 ; i < data.length; i++){
			if(counts[0] == 0){
				candidates[0] = data[i];
				counts[0] ++;
			}else if(counts[1] == 0){
				candidates[1] = data[i];
				counts[1] ++;
			}else if (counts[2] == 0){
				candidates[2] = data[i];
				counts[2] ++;
			}else if(data[i] == candidates[0]){
				counts[0]++;
			}else if(data[i] == candidates[1]){
				counts[1]++;
			}else if(data[i] == candidates[2]){
				counts[2]++;
			}else{
				counts[0]--;
				counts[1]--;
				counts[2]--;

			}
		}
		
		return candidates;
	}
		
}
	
