

// 7 0 1 2 0 3 0 4 2 3 0 3 2 1 2 0 1 7 0 1      Ans : 15 PageFaults.
// 4 7 3 0 1 7 3 8 5 4 5 3 4 7                  Ans : 12 PageFaults.
// 1 2 3 4 1 2 5 1 2 3 4 5						Ans : 9  PageFaults.
import java.util.Random;
import java.util.Scanner;
public class fif {
	public static int fifo(int n,int Frames,int Pages[],int table[][]){
		Random random = new Random();
		int k=0;
//		Scanner random = new Scanner(System.in);
		int i,j,pointer=1,PageFaults,flag,flag1=1;
//		n = 1 + random.nextInt(20);
//		n = random.nextInt();
//		Frames = random.nextInt();
//		int Pages[]     = new int[21];
		int Memory[]    = new int[100];
		int PageFault[] = new int[21];
//		n = 20;
		PageFaults = 1;
		for(i=0;i<n;i++){
//			Pages[i] = 1 + random.nextInt(10);
//			Pages[i] = random.nextInt();
			System.out.printf("%d ",Pages[i]);
		}
		System.out.println("\n");
		
		for(i=0;i<Frames;i++){
			Memory[i] = -1;
		}
		pointer = 0;
		Memory[0] = Pages[0];
		for(j=0;j<Frames;j++){
			System.out.printf("%d ",Memory[j]);
			table[k][j]=Memory[j];
		}
		k++;
		System.out.println("");
		for(i=1;i<n;i++){
			flag1 = 1;
			flag = 0;
			for(j=0;j<Frames;j++){
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
				for(j=0;j<Frames;j++){
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
				for(j=0;j<Frames;j++){
					if(Pages[pointer]==Memory[j]){
						Memory[j] = Pages[i];
						break;
					}
				}
				PageFaults = PageFaults + 1;
				PageFault[i] = 0;
				
				for(j=pointer+1;;j++){
					if(PageFault[j]==0){
						break;
					}
					pointer = pointer + 1;
				}
				pointer = pointer + 1;
			}
			System.out.println("SHARIQ");
			for(j=0;j<Frames;j++){
				System.out.printf("%d ",Memory[j]);
				table[k][j]=Memory[j];
			}
			k++;
			System.out.println("");
		}
		System.out.println(PageFaults);
		for(j=1;j<n;j++){
			System.out.printf("%d ",PageFault[j]);
		}
		System.out.println("\n");
		return PageFaults;
	}
}