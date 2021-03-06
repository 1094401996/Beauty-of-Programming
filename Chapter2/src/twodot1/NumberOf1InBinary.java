package twodot1;
/**
 * 
 * @author gengchen
 * 
 * 2013.3.27
 *第三和第四个方法十分碉堡
 *
 *
 *第四个方法用空间换时间，十分不错。。。。
 *
 */

public class NumberOf1InBinary {
	public static void main(String[] args){
		int[] data = {5,15,45,63};
		for(int d : data){
			System.out.println(d + " has " + method1(d) + " 1s");
			System.out.println(d + " has " + method2(d) + " 1s");
			System.out.println(d + " has " + method2(d) + " 1s");
		}
	}
	
	
	public static int method1(int data){
		int num = 0;
		while(data != 0){
			if(data % 2 == 1){
				num++;
			}
			data /=2;
		}
		return num;
	}
	
	public static int method2(int data){
		int num = 0;
		while(data != 0){
			num += data & 1;
			data >>=1;
		}
		return num;
	}
	
	public static int method3(int data){
		int num = 0;
		while(data != 0){
			data >>= (data-1);
			num++;
		}
		return num;
	}
}
