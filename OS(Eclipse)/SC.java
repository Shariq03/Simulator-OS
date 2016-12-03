
// 2 3 2 1 5 2 4 5 3 2 5 2           		Ans : 7 PageFaults.(3 Frames)
// 7 0 1 2 0 3 0 4 2 3 0 3 2 1 2 7 1		Ans : 
import java.util.Random;
import java.util.Scanner;

public class SC{
	public static int second_chance(int n,int Frames,int Pages[],int table[][]){
//		Random random = new Random();1
		Scanner scan = new Scanner(System.in);
		int kk=1;
		int i,j,pointer=1,PageFaults,flag,flag1=1,l,m;
//		n = 1 + random.nextInt(20);
//		n = scan.nextInt();
//		Frames = scan.nextInt();
//		int Pages[]     = new int[21];
		int Memory[]    = new int[10];
		int Check[]     = new int[10];
		int PageFault[] = new int[21];		//0-PageFault.
		int Pointer[]   = new int[21];      //1-completed.   0-yet to be...
		int ReferenceBit[] = new int[10];
//		n = 20;
		PageFaults = 1;
		for(i=1;i<=n;i++){
		//	Pages[i] = 1 + random.nextInt(10);
//			Pages[i] = scan.nextInt();
			Pointer[i] = 0;
			System.out.printf("%d ",Pages[i]);
		}
		System.out.println("\n");
		for(i=1;i<=Frames;i++){
			Memory[i] = -1;
			ReferenceBit[i] = -1;
		}
		pointer = 1;
		Memory[1] = Pages[1];
		ReferenceBit[1] = 0;
		for(j=1;j<=Frames;j++){
			System.out.printf("%d ",Memory[j]);
			table[kk][j]=Memory[j];
		}
		kk++;
		System.out.println("\n");
		
		for(i=2;i<=n;i++){
			flag1 = 1;
			flag = 0;
			for(j=1;j<=Frames;j++){
				if(Pages[i]==Memory[j]){
					flag = 1;
					ReferenceBit[j] = 1;
					PageFault[i] = 1;
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
					ReferenceBit[j] = 0;
				}
			}
			if(flag1==0){
				int k;
				k = FindFault(Pointer,PageFault,Memory,ReferenceBit,n,Frames,Pages);
				for(j=1;j<=Frames;j++){
					if(Memory[j] == Pages[k]){
						Memory[j] = Pages[i];
						PageFault[i] = 0;
						PageFaults = PageFaults + 1;
						break;
					}
				}
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
	public static int FindFault(int Pointer[],int PageFault[],int Memory[],int ReferenceBit[],int n,int Frames,int Pages[]){
		int i,j;
		for(i=1;i<=n;i++){
			if(Pointer[i] == 0 && PageFault[i] == 0){
				for(j=1;j<=Frames;j++){
					if(Pages[i]==Memory[j] && ReferenceBit[j] == 1){
						ReferenceBit[j] = 0;
					}
					else if(Pages[i]==Memory[j] && ReferenceBit[j] == 0){
						Pointer[i] = 1;
						return i;
					}
				}
			}
		}
		return 0;
	}
}