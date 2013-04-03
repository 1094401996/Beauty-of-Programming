package twodot1;

public class Extention {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numberOfChange(31,14));
	}
	
	public static int numberOfChange(int a , int b){
		a = a^b;
		return numberOf1s(a);
	}
	public static int numberOf1s(int data){
		int num = 0;
		while(data != 0){
			data &= data - 1;
			num ++;
		}
		
		return num;
	}

}
