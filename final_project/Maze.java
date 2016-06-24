import java.util.Arrays;

class Maze {
	public static void main(String[] args) {
		String[][] maze = {{"*", " ", "*", "*", "*", "*", "*", "*", "*"}, 
				     {"*", " ", " ", " ", " ", " ", "*", " ", "*"}, 
				     {"*", " ", "*", "*", "*", "*", "*", " ", "*"}, 	
				     {"*", " ", "*", " ", "*", " ", " ", " ", "*"}, 	
				     {"*", " ", "*", " ", "*", "*", "*", " ", "*"}, 	
				     {"*", " ", " ", " ", "*", " ", " ", " ", "*"}, 	
				     {"*", "*", "*", " ", "*", " ", "*", " ", "*"},
				     {"*", " ", " ", " ", " ", " ", "*", " ", "*"}, 	
				     {"*", "*", "*", "*", "*", "*", "*", " ", "*"}};

		String mazeOut = "";
		for(String[] out1 : maze) {
			for(String out2 : out1) {
				mazeOut += out2;
			}
			mazeOut += "\n";
		}
		System.out.println(mazeOut);

		String result = "";
		for(String[] out1 : route(maze)) {
			for(String out2 : out1) {
				result += out2;
			}
			result += "\n";
		}
		System.out.println(result);
	}

	public static String[][] route (String[][] maze) {
		String[][] tmp = maze.clone();
		String[][] output = new String[maze.length][];

		for(int i = 0; i < tmp.length; i++) {
			output[i] = Arrays.copyOf(tmp[i], tmp[i].length);

			for(int j = 0; j < tmp[i].length; j++) {
				if(!isFeasible(tmp, i, j)) {
					tmp[i][j] = "*";
				}
			}
			for(int j = tmp[i].length - 1; j >= 0; j--) {
				if(!isFeasible(tmp, i, j)) {
					tmp[i][j] = "*";
				}
			}
		}
		for(int i = tmp.length - 1; i >= 0; i--) {			
			for(int j = 0; j < tmp[i].length; j++) {
				if(!isFeasible(tmp, i, j)) {
					tmp[i][j] = "*";
				}
			}
			for(int j = tmp[i].length - 1; j >= 0; j--) {
				if(!isFeasible(tmp, i, j)) {
					tmp[i][j] = "*";
				}
			}
		}
		for(int i = 0; i < tmp.length; i++) {
			for(int j = 0; j < tmp[i].length; j++) {
				if(tmp[i][j].equals(" ")) {
					output[i][j] = "+";
				}
			}
		}
		return output;
	}

	public static boolean isFeasible(String[][] maze, int i, int j) {
		int counter = 0;
		if(i + 1 == maze.length || j + 1 == maze[i].length) {
			return true;
		}
		if(i - 1 < 0 || j - 1 < 0) {
			return true;
		}
		if(maze[i - 1][j].equals("*")) {
			counter++;
		}
		if(maze[i + 1][j].equals("*")) {
			counter++;
		}
		if(maze[i][j - 1].equals("*")) {
			counter++;
		}
		if(maze[i][j + 1].equals("*")) {
			counter++;
		}
		return counter < 3;
	}
}