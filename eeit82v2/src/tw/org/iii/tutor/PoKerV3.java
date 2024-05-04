package tw.org.iii.tutor;

import java.util.Arrays;

//public = 主列別 = 只有一個
public class PoKerV3 {

	public static void main(String[] args) {
//		設定num = 52
		int num = 52;
//		設定poker為52
		int[] poker = new int[num];
//		 i = num = 51
		for(int i = 0 ; i < num ; i++) poker[i] = i;
//		i = num = 52 -1
		for(int i = num -1; i > 0 ; i -- ) {
			int rand = (int)(Math.random()*(i + 1));
			int temp = poker[rand];
			poker[rand] = poker[i];
			poker[i] = temp;
		}
//		驗算看看
//		for(int card : poker) {
//			System.out.println(card);
//		}
//		System.out.println("-----");
		
		int[][] players = new int[4][13];
		for(int i = 0; i < num ; i++ ) {
			players[i%4][i/4] = poker[i];
		}
//		驗算
//		for(int card : players[0]) {
//			System.out.println(card);
//		}
		
		String[] suits = {"黑桃","紅心","方塊","梅花"};
		String[] values = {"A ","2 ","3 ","4 ","5 ","6 ","7 ","8 ","9 ","10","J ","Q ","K "};
		for(int[] player: players) {
			Arrays.sort(player);
			
			
			for(int card : player) {
				
				System.out.printf("%s%s  ", suits[card/13] , values[card%13]);
			}
			System.out.println();
		}
	}

}
