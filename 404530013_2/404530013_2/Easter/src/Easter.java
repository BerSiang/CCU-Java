package com.vincent;

/**
 * Easter
 *
 * @author Vincent Huang
 *
 */

public class Easter {

	/**
	 * 本類別不提供建構子建立物件
	 *
	 */
	private Easter() {

	}

	/**
	 * 透過高斯演算法計算復活節日期
	 *
	 * @param aYear 欲知道的年份
	 * @return 復活節日期(年、月、份)
	 *
	 */
	public static String calculateEaster(int aYear) {
		
		//先做了基本判斷, Good!
		if (33 < aYear && aYear < 325) {
			return "本方法不適用於西元" + aYear + "年" + "(西元325年前復活節是採用猶太曆法，本方法只適用於西元325年第一次尼西亞會議後)";
			} else if (aYear < 33) {
			return "西元" + aYear + "年並沒有復活節" + "(耶穌基督於西元33年被釘死於十字架上，三天後復活，在西元33年前並沒有復活節)";		}

		int a = aYear % 19;
		int b = aYear % 4;
		int c = aYear % 7;
		int k = aYear / 100;// Math.floor(), -2
		int p = (13 + 8 * k) / 25;
		int q = k / 4;
		int M = (15 - p + k - q) % 30;
		int N = (4 + k - q) % 7;
		int d = (19 * a + M) % 30;
		int e = (2 * b + 4 * c + 6 * d + N) % 7;

		int month = (d + e < 10) ? 3 : 4;
		int day = (d + e < 10) ? (d + e + 22) : (d + e - 9);
		// 下面這個else if的部分其實可以直接針對month==4去最判斷就好了, month==3在後面的檢核是無需加入考慮的.
		// ()?:這種寫法Good! 不過還是會建議先使用if-else的平常寫法
		//透過這樣去增加程式易讀性.
		
		/*
		 * if(month==3){
		 * 	day=(d + e + 22);
		 * }else{
		 *  if(d == 29 && e == 6) {
		 *  	day=19;
		 *  }else if(d == 28 && e == 6 && (11 * M + 11) % 30 < 19){
		 *  	day=18;
		 *  }else{
		 *  	day=(d + e - 9);
		 *  }
		 * }
		 * */
		
		

		day = (d == 29 && e == 6) ? 19 : (month == 3 ? (d + e + 22) : (d + e - 9));
		day = (d == 28 && e == 6 && (11 * M + 11) % 30 < 19) ? 18 : (month == 3 ? (d + e + 22) : (d + e - 9));

		return "In " + aYear + ", Easter Sunday is: month = " + month + " and day = " + day;
	}

}