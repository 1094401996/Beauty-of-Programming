package twodot5;
/**
 * find the kth largest number in two sorted arrays
 * method:
 * ���������������н��ж���������ʱ�临�Ӷ�ΪO��logn+logm��
 * �ȱȽ���������k/2��Ԫ�أ������ȣ�����
 * ����ϴ���Ǹ�������ȥk/4����С���Ǹ���������k/4�������Ƚϡ�
 * ������ͣ������ȥ��ֱ��������Ȼ������ﵽ�˱߽磨0��k����
 * @author gengchen
 * 
 * http://blog.csdn.net/fangkyo/article/details/8114784
 * 
 *these is a terrible bug in the program...I couldn;t find it...
 *
 */
public class extension {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]a = {1,3,5,7,9,12};
		int[] b ={2,4,6,8,10,11};
		int k = 5;
		for (int i = 1; i <= a.length + b.length; i++)
			System.out.print(findKth2(a,0,a.length - 1, b, 0 ,b.length - 1, i )+" ");
	}
	
	
	
	public static int findKth2(int[] A, int aBeg, int aEnd, int[] B, int bBeg, int bEnd ,int k ){
		if (aBeg > aEnd)  
	    {  
	        return B[bEnd + 1 - k];  
	    }  
	    if (bBeg > bEnd)  
	    {  
	        return A[aEnd + 1 - k];  
	    }  
	      
	    //ȡ�м�λ��  
	    int aMid = aBeg + (aEnd - aBeg)/2;    
	    int bMid = bBeg + (bEnd - bBeg)/2;  
	      
	    //��A��B�Ŀ�ʼ����λ�õ����������м�λ�õ�Ԫ�ظ���  
	    int halfLen = aEnd - aMid + bEnd - bMid + 2;  
	      
	    if (A[aMid] < B[bMid])  
	    {  
	        if (halfLen > k)  
	        {  
	            // ��ʱ�ںϲ���������A[aBeg...aMid]��Ԫ��һ����B[bMid]����࣬  
	            // ����ʱ��k���Ԫ��һ����A[aMid]���Ԫ�ش��ϸ���˵��С�ڣ�  
	            // ���Ժ�û�б�Ҫ���� A[aBeg...aMid]��ЩԪ��  
	            return findKth2(A, aMid + 1, aEnd, B, bBeg, bEnd, k);  
	        }  
	        else  
	        {  
	            // ��ʱ�ںϲ���������A[aBeg...aMid]Ԫ��һ����B[bMid]����࣬  
	            // ����ǰK��Ԫ����һ������B[bMid...bEnd]������ʹ�÷�֤����֤����㣩��  
	            // �����޷��ж�A[aBeg...aEnd]��B[bBeg...bMid]֮��Ĺ�ϵ������Ҫ�����ǽ����ж�  
	            // ��ʱK��ʣ�³�ȥA[aBeg...aMid]��ЩԪ�أ�����Ϊk - (aMid - aBeg + 1)  
	            return  findKth2(A, aBeg, aEnd, B, bBeg, bMid -1 , k - (bEnd - bMid + 1));  
	        }  
	    }  
	    else  
	    {  
	        //ע������������  
	        if (halfLen > k)  
	        {  
	            return findKth2(A, aBeg, aEnd, B, bMid + 1, bEnd, k);  
	        }  
	        else  
	        {  
	            return  findKth2(A, aBeg, aMid - 1, B, bBeg, bEnd, k - (aEnd - aMid + 1));  
	        }  
	    }  
	}
	
	static int FindKthElm(int A[], int aBeg, int aEnd, int B[], int bBeg, int bEnd, int k)  
	{  
	    if (aBeg > aEnd)  
	    {  
	        return B[bBeg + k - 1];  
	    }  
	    if (bBeg > bEnd)  
	    {  
	        return A[aBeg + k - 1];  
	    }  
	      
	    //ȡ�м�λ��  
	    int aMid = aBeg + (aEnd - aBeg)/2;    
	    int bMid = bBeg + (bEnd - bBeg)/2;  
	      
	    //��A��B�Ŀ�ʼλ�õ����������м�λ�õ�Ԫ�ظ���  
	    int halfLen = aMid - aBeg + bMid - bBeg + 2;  
	      
	    if (A[aMid] < B[bMid])  
	    {  
	        if (halfLen > k)  
	        {  
	            // ��ʱ�ںϲ���������A[aBeg...aMid]��Ԫ��һ����B[bMid]����࣬  
	            // ����ʱ��k���Ԫ��һ����B[bMid]���Ԫ��С���ϸ���˵�����ڣ�  
	            // ���Ժ�û�б�Ҫ���� B[bMid...bEnd]��ЩԪ��  
	            return FindKthElm(A, aBeg, aEnd, B, bBeg, bMid - 1, k);  
	        }  
	        else  
	        {  
	            // ��ʱ�ںϲ���������A[aBeg...aMid]Ԫ��һ����B[bMid]����࣬  
	            // ����ǰK��Ԫ����һ������A[aBeg...aMid]������ʹ�÷�֤����֤����㣩��  
	            // �����޷��ж�A[amid+1...aEnd]��B[bBeg...bEnd]֮��Ĺ�ϵ������Ҫ�����ǽ����ж�  
	            // ��ʱK��ʣ�³�ȥA[aBeg...aMid]��ЩԪ�أ�����Ϊk - (aMid - aBeg + 1)  
	            return FindKthElm(A, aMid + 1, aEnd, B, bBeg, bEnd, k - (aMid - aBeg + 1));  
	        }  
	    }  
	    else  
	    {  
	        //ע������������  
	        if (halfLen > k)  
	        {  
	            return FindKthElm(A, aBeg, aMid - 1, B, bBeg, bEnd, k);  
	        }  
	        else  
	        {  
	            return FindKthElm(A, aBeg, aEnd, B, bMid + 1, bEnd, k - (bMid - bBeg + 1));  
	        }  
	    }  
	}  
	
	//time complexity: O(M + N)
		private static int findKth1(int[] a, int[] b, int k){
			int i = a.length - 1;
			int j = b.length - 1;
			int count = 0;
			int target = 0;
			while(i >= 0 && j >= 0){
				if(a[i] > b[j]){
					target = 0;
				}
				if(a[i] <= b[j]){
					target = 1;
				}
				count ++;
				if(count == k){
					break;
				}
				if(target == 0){
					i--;
				}else{
					j--;
				}
			}
			if(target == 0 ){
				return a[i];
			}else{
				return b[j];
			}
		}
	
	
}