Program 1: Eight Queens
A puzzler for chess buffs is the Eight Queens problem, which asks the following: Is it possible to place eight queens on an empty chessboard so that no queen is "attacking" any other (i.e., no two queens are in the same row, in the same column or along the same diagonal)? For instance, if a queen is placed in the upper-left corner of the board, no other queens could be placed in any of the marked squares shown in F

Program 2: Sierpinski triangle
The Sierpinski triangle is a fractal that is defined as follows: The construction begins with a triangle. The triangle is cut into four congruent sub-triangles with the central triangle removed. The same process is then applied recursively to the three other sub-triangles. Obviously this can run indefinitely with infinitesimally decreasing coordinate components. Therefore you must decide base case, i.e. you can ask the recursive function after five calls. 


Program 3: Maze
Solving a maze involves a great deal of trial and error: following a path, backtracking when you cannot go farther, and trying other untried options. More specifically, you follow a path until it either gets you to a solution or it becomes a dead end. If you reach a dead end, you backtrack (go back) to a point in the maze where there is an unexplored path, which you follow. You keep doing this until you find a solution or have explored all possible paths, in which case you conclude that there is no solution. 

Features: 
	a.	Allow the user to create the maze. This is achieved by loading the maze from an existing file. Keep in mind that a “*” indicates a 		blocked path and a white space character indicates a clear path. As the maze is solved, the white space characters will be changed 		to dots (periods) to indicate attempted paths and ultimately a successful path through the maze if one exists. 
	
	b.	Randomly generate a maze to be searched if the user decides not to provide a maze of her/his own. This is a nice feature since it is 	 a little painful to create the mazes by hand, but it tends to produce a lot of unsolvable mazes. 
	
	c.	Update the maze as each step is taken (instead of just showing the completed maze at the end).
