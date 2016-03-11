/**
 *  RectangleTester
 *
 *  @author Vincent Huang
 */

import java.util.Scanner;
import Java.Rectangle;

class RectangleTester {
	public static void main(String[] args) {
		/*程式進入點*/

		/**建立 Rectangle 物件*/
		Rectangle rect1 = new Rectangle(18, 57, 25, 15);
		Rectangle rect2 = new Rectangle(47, 60, 12, 0);
		Rectangle rect3 = new Rectangle();

		/**顯示 rect1、rect2 物件詳細資訊*/
		System.out.print("\nObject name:rect1\n" + rect1.toString() + "\nArea = " + 
			rect1.getArea() + "\nPerimeter = " + rect1.getPerimeter() + "\n\n");
		System.out.println("Object name:rect2\n" + rect2.toString() + "\nArea = " + 
			(double)rect2.getWidth() * rect2.getHeight() + 
			"\nPerimeter = " + (double)(rect2.getWidth() + rect2.getHeight()) * 2 + 
			"\n");

		/**輸入物件 rect3 的 x, y, width, height*/
		System.out.println("Please set rect3 value,");
		System.out.print("X:");
		rect3.setX(nextDouble(0));
		System.out.print("Y:");
		rect3.setY(nextDouble(0));
		System.out.print("Width:");
		rect3.setWidth(nextDouble(1));
		System.out.print("Height:");
		rect3.setHeight(nextDouble(1));
		
		/*顯示 rect3 物件詳細資訊*/
		System.out.printf("%nObject name:rect3%n%s%nArea = %f%nPerimeter = %f%n", 
			rect3.toString(), rect3.getArea(), rect3.getPerimeter());
	}/*主程式結束*/

	/*
	 *	由於使用者輸入資料的不可預測性
	 *	建立nextDouble方法來偵測及糾正輸入資料使其符合預期
	 *	以避免程式不可預期的例外狀況
	 */

	/**
	  *	建立靜態的Scanner物件以接受使者輸入資料
	  *	在本類別載入時及建立
	  */
	static Scanner con = new Scanner(System.in);

	/**
	  *	建立靜態的 nextDouble 方法
	  *	負責偵測及糾正使用者輸入資料是否符合預期
	  *	在本類別載入時及建立
	  *	@param a 預期的輸入資料類型
	  *			 (a = 0 時接受任何數字, a > 0 時僅接受正數, a < 0 時僅接受負數)
	  */
	static double nextDouble(int a) {
		String input = con.next();
		if(a == 0) {
			while(!input.matches("\\d*")) { //規則表示式，當資料不是數字時，請使用者重新輸入
			System.out.print("Please enter number:");
			input = con.next();
			}
		}
		else if(a > 0) {
			while(!input.matches("\\d*[^-]")) { //規則表示式，當資料不是正數時，請使用者重新輸入
			System.out.print("Please enter positive number:");
			input = con.next();
			}
		}
		else if(a < 0) {
			while(!input.matches("\\d*[-]")) { //規則表示式，當資料不是負數時，請使用者重新輸入
			System.out.print("Please enter negative number:");
			input = con.next();
			}
		}
		return Double.parseDouble(input); // 通過檢查後，將資料轉成Double型態並回傳
	}
}