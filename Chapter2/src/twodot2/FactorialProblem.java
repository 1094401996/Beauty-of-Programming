package twodot2;
/*
 * 
 * 2013.3,27
 * ����˼��ﱤ��������
 */
public class FactorialProblem {
	
	
	public static void main(String[] args){
		int N = 3;
		System.out.println(problem2Method1(N));
	}
	
	
	
	
	public static int problem1Method1(int N){
		int num = 0;
		for(int i = 5 ; i <= N; i++){
			int j  = i;
			while(j % 5 ==0 ){
				num ++;
				j /= 5;
			}
		}
		
		return num;
	}	
	
	
	public static int problem1Method2(int N){
		int num = 0;
		//ͬ����˼�룬 ��ͬ��ʵ�ַ�ʽ��������
//		while(N != 0){
//			num += N/5;
//			N/=5;
//			
//		}
		int k = 5;
		while(k <= N){
			num += N / 5;
			k *= 5;
		}
		return num;
	}
	
	
	public static int problem2Method1(int N){
		int num = 0;
		int k = 2;
		while(k <= N){
			N >>= 1;
			num += N;
			k <<= 1;
		}
		
		return num;
	}
	
	//N!���е�������2�ĸ��� = N - ��N�Ķ����Ʊ�ʾ��1����Ŀ��
}