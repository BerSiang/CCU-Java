/*
* [A]100
* [TA's Advise]
* 1. Good!
*/

import javax.swing.JOptionPane;

/**
 * GradeAnalyzerTester
 *
 * @author Vincent Huang
 *
 */
class GradeAnalyzerTester {
	public static void main(String[] args) {
		GradeAnalyzer analyzer = new GradeAnalyzer();
		String input = "";
		while(!(input.equals("q") || input.equals("Q"))) {
			input = JOptionPane.showInputDialog(null, "輸入成績", "成績統計系統", JOptionPane.QUESTION_MESSAGE);

			if(!(input.equals("q") || input.equals("Q"))) { 	
			analyzer.addGrade(Double.parseDouble(input));
			}
		}
		analyzer.gradeAnalyze();
		JOptionPane.showMessageDialog(null, analyzer.toString(), "成績統計系統", JOptionPane.INFORMATION_MESSAGE);
	}
}