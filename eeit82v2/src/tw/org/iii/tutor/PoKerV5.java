package tw.org.iii.tutor;

import java.util.Arrays;
/*
 		1.做牌
 		2.洗牌
 		3.發牌
 		4.判斷每個人手上的牌是否有重複 分成兩堆
 		5.最後輸出每個人的手牌
  */


public class PoKerV5 {

	public static void main(String[] args) {
		int num = 52;  //撲克牌張數52張
		int poker[] = new int [num]; //撲克牌
		int temp;      //洗牌用的變數
		
		
		//製造牌
		
		
		for(int i = 0 ; i < num ; i++) {
			poker[i] = i+1; //此處因為後面的存放陣列 會先加一 最後輸出會減回來
		}
		
		//洗牌
		
		for(int i = num-1 ; i > 0; i--) {
			int random = (int)(Math.random()*(i+1));
			temp = poker[i];
			poker[i] = poker[random];
			poker[random] = temp;			
		}
		
		//發牌
		
		
		int handsTemp [][] = new int [4][13];	
		for(int i =0 ; i < num; i++) {
			handsTemp[i % 4][i / 4]= poker[i];
		}
		
		//此處分成兩個部分 將有重複的數字牌和沒有重複的分成兩個部分
		
		int handsOne [][] = new int [4][13];	// 存放重複
		int handsTwo [][] = new int [4][13];	// 存放不重複
		
		for(int p = 0; p < 4; p++) {
			int temp1 =0;//存放區1
			int temp2 =0;//存放區2
		
		//  一張一張判斷是不是數字重複 並放對對應的陣列
			for(int i = 0; i < 13; i++) {
				for(int j = 0; j < 13; j++) {
					if((handsTemp[p][i]%13)==(handsTemp[p][j]%13) && i != j) {
						handsOne[p][temp1]=handsTemp[p][i];
						temp1 ++ ;
						break;
					}else if(j==12) {
						handsTwo[p][temp2]=handsTemp[p][i];
						temp2++;
					}
				}
			}
		}
		//分別排序兩個部分
		
		
		for(int[] handOneAfterSort: handsOne) {
			Arrays.sort(handOneAfterSort);
		}
		for(int[] handTwoAfterSort: handsTwo) {
			Arrays.sort(handTwoAfterSort);
		}
		
		
		
		//輸出玩家手牌
		String[] suits = {"黑桃","紅心","方塊","梅花"};
		String[] players = {"玩家A手牌","玩家B手牌","玩家C手牌","玩家D手牌"};
		String[] values = {"A ","2 ","3 ","4 ","5 ","6 ","7 ","8 ","9 ","10","J ","Q ","K "};
		
		for(int p = 0; p < 4; p++) {
			System.out.print(players[p]+" : \s");
			System.out.println();
			
			//先印出第一部分 	>> A~Q的PAIR 因為前面設計陣列時裡面有很多沒有用的0 所以只印出陣列裡非0的數字
			
			
			for(int i = 1; i < 13; i++) {     // 此處的i為檢測餘數
				for(int j = 0; j < 13; j++) {
					if(handsOne[p][j] != 0) {
						if(handsOne[p][j]%13 == i ){
							int pokerCode = handsOne[p][j]-1; // 把LINE 17 加的1減回來
							System.out.printf("%s %s ",suits[pokerCode/13],values[pokerCode%13]);	
						}					
					}
				}

			}
			//印出第二部分 	>> K的PAIR
			
			
			for(int i = 0; i < 13; i++) {
				if(handsOne[p][i] != 0 && handsOne[p][i]%13 == 0) {
						int pokerCode = handsOne[p][i]-1; // 把LINE 17 加的1減回來
						System.out.printf("%s %s ",suits[pokerCode/13],values[pokerCode%13]);	

				}
			}
			//印出第三部分 	>> 沒有PAIR的散張
			
			
			for(int i = 0; i < 13; i++) {
				
				if(handsTwo[p][i]!=0) {
					int pokerCode = handsTwo[p][i]-1; // 把LINE 17 加的1減回來
					System.out.printf("%s %s ",suits[pokerCode/13],values[pokerCode%13]);
				}
				
			}
			System.out.println();
			System.out.println();
		}
	
	}

}