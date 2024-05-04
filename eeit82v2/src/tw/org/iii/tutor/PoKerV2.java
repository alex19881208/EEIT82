package tw.org.iii.tutor;
//public = 主列別 = 只有一個
public class PoKerV2 {

	public static void main(String[] args) {
		//long start = System.currentTimeMillis();=偵測程式時間
		long start = System.currentTimeMillis();
		int[] poker = new int[52];
		boolean isRepeat;
		int temp;
		for(int i = 0;i<poker.length;i++) {
			do {
				temp = (int)(Math.random()*52);
				//檢查機制
				isRepeat = false;
				for(int j = 0 ; j < i ; j++) {
					if(temp == poker[j]) {
						//重複了
						isRepeat = true;
						break;
					}
				}
			}while(isRepeat);
			
			poker[i] = temp;
			System.out.println(poker[i]);
			
			
		}
		System.out.println("---");//分隔線
		System.out.println(System.currentTimeMillis()-start); //測速
	}

}
