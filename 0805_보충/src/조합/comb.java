package 조합;

import java.util.Arrays;

public class comb {
	
	static int COUNT;
	static int[] src = {1,2,3,4,5};
	static int[] tgt = new int[3];
	
	public static void main(String[] args) {
		comb(0,0);
		System.out.println(COUNT);


	}
	
	static void comb(int srcIdx, int tgtIdx) {
		//기저조건
		if(tgtIdx == tgt.length) { //한세트 완성
			System.out.println(Arrays.toString(tgt));
			COUNT++; 
			return;
		}
		
		
		if(srcIdx == src.length) return;
		
		tgt[tgtIdx] = src[srcIdx]; //현재선택
		
		
		//현재 선택을 인정하고 다음자리로 이동
		comb(srcIdx+1,tgtIdx+1);
		//현재 선택을 인정하지 않고 현재 자리를 다시 고려
		comb(srcIdx+1,tgtIdx);
		
	}

}
