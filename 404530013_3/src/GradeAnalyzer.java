import java.lang.Math;
import java.util.Arrays;

/**
 * GradeAnalyzer
 *
 * @author Vincent Huang
 *
 */

class GradeAnalyzer {
	private double[] grades = new double[0];	//成績儲存陣列
	private int apCounter, aCounter, amCounter, //各門檻人數
	bpCounter, bCounter, bmCounter,
	cpCounter, cCounter, cmCounter,
	dCounter, fCounter,
	average, deviation;
	final int ap = 98, a = 92, am = 90, bp = 88, b = 82, bm = 80,	//作業需求，各門檻分數
	cp = 78, c = 72, cm = 70, d = 60, f = 60,
	maximum = 110, minimum = 0;	//最大最小範圍
	private double sum,sumPow;	//總和、平方總和

	/**
     *  判斷數值是否在正確範圍內
     *  @param aGrade 使用者輸入的數值
     *  @return 數值是否正確
     */
	public boolean isValidGrade(double aGrade) {
		return aGrade >= minimum && aGrade <= maximum;
	}

	int counter = 0;
	/**
     *  將合法數值加入陣列中
     *  @param aGrade 使用者輸入的數值
     */
	public void addGrade(double aGrade) {
		if(isValidGrade(aGrade)) {
			grades = Arrays.copyOf(grades, grades.length + 1);	//變動陣列
			grades[grades.length - 1] = aGrade;
		}
	}

	/**
     *  分析成績各門檻人數、標準差、總平均
     *  
     */
	public void gradeAnalyze() {
		for(double grade : grades) {
			sum += grade;	// 計算總和
			sumPow += Math.pow(grade,2);	// 計算平方總和
			if(grade >= ap) {
				apCounter++; 
				continue;
			}
			if(grade < ap && grade >= a) {
				aCounter++;
				continue;
			}
			if(grade < a && grade >= am) {
				amCounter++;
				continue;
			}
			if(grade < am && grade >= bp) {
				bpCounter++; 
				continue;
			}
			if(grade < bp && grade >= b) {
				bCounter++;
				continue;
			}
			if(grade < b && grade >= bm) {
				bmCounter++;
				continue;
			}
			if(grade < bm && grade >= cp) {
				cpCounter++; 
				continue;
			}
			if(grade < cp && grade >= c) {
				cCounter++;
				continue;
			}
			if(grade < c && grade >= cm) {
				cmCounter++;
				continue;
			}
			if(grade < cm && grade >= d) {
				dCounter++; 
				continue;
			}
			if(grade < 60) {
				fCounter++;
				continue;
			}
		}
		average = (int)Math.round(sum/grades.length); // 計算平均
		deviation = (int)Math.sqrt((sumPow - grades.length * Math.pow(average, 2)) / grades.length); //計算標準差

	}

	/**
     *  輸出成績統計結果
     *  @return String 成績統計結果
     */
	public String toString() {
		if(grades.length < 2) {
			return "You did not enter enough grades to analyze. Please enter at least 2 valid grades.";
		}
		return "You entered " + grades.length + " valid grades from " + minimum +
		" to " + maximum +". Invalid grades are ignored!" +
		"\nThe average = " + average + " with a standard deviation = " + deviation + "," +
		"\nThe grade distribution is:" +
		"\nA+ = " + apCounter +
		"\nA = " + aCounter +
		"\nA- = " + amCounter +
		"\nB+ = " + bpCounter +
		"\nB = " + bCounter +
		"\nB- = " + bmCounter +
		"\nC+ = " + cpCounter +
		"\nC = " + cCounter +
		"\nC- = " + cmCounter +
		"\nD = " + dCounter +
		"\nF = " + fCounter;
	}



}