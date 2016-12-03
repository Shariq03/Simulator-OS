

// 7 0 1 2 0 3 0 4 2 3 0 3 2 1 2 0 1 7 0 1		Ans : 9 PageFaults.(3 Frames)
// 2 3 4 2 1 3 7 5 4 3							Ans : 6 PageFaults.(3 Frames)
// 0 4 3 2 1 4 6 3 0 							Ans : 7 PageFaults.(3 Frames)

import java.util.Random;
import java.util.Scanner;
public class opti {
	public static int optimal(int n,int Frames,int Pages[],int table[][]){
//		Random random = new Random();
		int kk=1;
		Scanner random = new Scanner(System.in);
		int i,j,pointer=1,PageFaults,flag,flag1=1,l,m;
//		n = 1 + random.nextInt(20);
//		n = random.nextInt();
//		Frames = random.nextInt();
//		int Pages[]     = new int[21];
		int Memory[]    = new int[100];
		int PageFault[] = new int[21];
		int Check[]     = new int[100];

//		n = 20;
		PageFaults = 1;
		for(i=1;i<=n;i++){
		//	Pages[i] = 1 + random.nextInt(10);
//			Pages[i] = random.nextInt();
			System.out.printf("%d ",Pages[i]);
		}
		System.out.println("\n");
		
		for(i=1;i<=Frames;i++){
			Memory[i] = -1;
		}
		pointer = 1;
		Memory[1] = Pages[1];
		for(j=1;j<=Frames;j++){
			System.out.printf("%d ",Memory[j]);
			table[kk][j]=Memory[j];
		}
		kk++;
		System.out.println("\n");
		///////////////////////////////////////////////////////////////////
		for(i=2;i<=n;i++){
			flag1 = 1;
			flag = 0;
			for(j=1;j<=Frames;j++){
				if(Pages[i]==Memory[j]){
					flag = 1;
					break;
				}
			}
			if(flag == 1){
				PageFault[i] = 1;
				//Do nothing.
			}
			else{
				flag1 = 0;
				for(j=1;j<=Frames;j++){
					if(Memory[j] == -1){
						flag1 = 1;
						break;
					}
				}
				if(flag1==1){
					Memory[j] = Pages[i];
					PageFaults = PageFaults + 1;
					PageFault[i] = 0;
				}
			}
			if(flag1==0){
				for(l=1;l<=Frames;l++){
					Check[l] = 0;
				}
				int k,count=0,exit=1,count1=0;
				for(k=i+1;k<=n;k++){
					for(l=1;l<=Frames;l++){
						if(Pages[k] == Memory[l]){
							Check[l] = 1;
							count++;
						}
						if(count>=Frames-1){
							count1=0;
							for(m=1;m<=Frames;m++){
								count1 = count1 + Check[m];
							}
						}
						if(count1 == Frames-1){
							for(m=1;m<=Frames;m++){
								if(Check[m]==0){
									Memory[m] = Pages[i];
									exit=0;
									System.out.println("abhi");
									break;
								}
							}
						}
						if(exit==0){
							break;
						}
						
					}
					if(exit==0){
						break;
					}
					
				}
				if(exit==1){
					for(j=1;j<=Frames;j++){
						if(Check[j] == 0){
							Memory[j] = Pages[i];
							break;
						}
					}
				}
				PageFaults = PageFaults + 1;
			}
			for(j=1;j<=Frames;j++){
				System.out.printf("%d ",Memory[j]);
				table[kk][j]=Memory[j];
			}
			kk++;
			System.out.println("\n");
		}
		System.out.println(PageFaults);
		for(j=1;j<=n;j++){
			System.out.printf("%d ",PageFault[j]);
		}
		System.out.println("\n");
		return PageFaults;
	}
}
