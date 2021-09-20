package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] cnt=new int[10];
		while(true) {
			int num=sc.nextInt();
			if(num==0) 
				break;
			cnt[num/10]++;
		}
			for(int i=0;i<10;i++) {
				if(cnt[i]!=0) {
					System.out.printf("%d : %d개\n",i,cnt[i]);
				}
			}
			
		}
	}



