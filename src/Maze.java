/* Rashad saab, rms78, 201301697 */

import java.awt.Point;
import java.io.*;
import java.util.*;


public class Maze {
	static char[][] maze;

	/**
	 * CHECK FOR A VALID MOVEMENT
	 */
	private boolean isValidMove(Point desiredPos, Stack<Point> deadEndPoints){
		boolean isValid=false;
		if(desiredPos.x<maze.length && desiredPos.x>=0 && desiredPos.y<maze[desiredPos.x].length && desiredPos.y>=0){
			if((!deadEndPoints.contains(desiredPos)) && (((maze[desiredPos.x][desiredPos.y]==' ') && (maze[desiredPos.x][desiredPos.y]!='.') || (maze[desiredPos.x][desiredPos.y]=='E')))){
				isValid=true;
			}
		}

		return isValid;
	}

	/**
	 * DECIDING WHICH DIRECTION TO MOVE AT EACH POINT OF THE MAZE
	 **/
	public boolean traverseMaze(){
		Stack<Point> pointsTraversed=new Stack<Point>();
		Stack<Point> deadEndPoints=new Stack<Point>();
		Point start=findStartPos();
		return exploreCurrentPos(pointsTraversed, deadEndPoints, start, 0);
	}

	private boolean exploreCurrentPos(Stack<Point> pointsTraversed, Stack<Point> deadEndPoints, Point currPos, int level){
		if(level==20){
			printMaze();
			System.out.println();
		}
		boolean traversed=false;
		if(maze[currPos.x][currPos.y]=='E'){
			printMaze();
			return true;
		}else{
			if(canGoDown(currPos, deadEndPoints)){
				pointsTraversed.push(currPos);
				Point p=new Point(currPos.x+1, currPos.y);
				if(maze[p.x][p.y]!='E'){
					maze[p.x][p.y]='.';
				}
				//backtracking: if a position leads to dead end, push it into a stack to prevent going to it again and chose another available position
				traversed=exploreCurrentPos(pointsTraversed, deadEndPoints, p, level+1);
				if(!traversed){
					deadEndPoints.push(pointsTraversed.pop());
					return exploreCurrentPos(pointsTraversed, deadEndPoints, p, level+1);
				}else{
					return traversed;
				}


			}else if(canGoUp(currPos, deadEndPoints)){
				pointsTraversed.push(currPos);
				Point p=new Point(currPos.x-1, currPos.y);
				if(maze[p.x][p.y]!='E'){
					maze[p.x][p.y]='.';
				}
				
				traversed=exploreCurrentPos(pointsTraversed, deadEndPoints, p, level+1);
				if(!traversed){
					deadEndPoints.push(pointsTraversed.pop());
					return exploreCurrentPos(pointsTraversed, deadEndPoints, p, level+1);
				}else{
					return traversed;
				}

			}else if(canGoRight(currPos, deadEndPoints)){
				pointsTraversed.push(currPos);
				Point p=new Point(currPos.x, currPos.y+1);
				if(maze[p.x][p.y]!='E'){
					maze[p.x][p.y]='.';
				}
				
				traversed=exploreCurrentPos(pointsTraversed, deadEndPoints, p, level+1);
				if(!traversed){
					deadEndPoints.push(pointsTraversed.pop());
					return exploreCurrentPos(pointsTraversed, deadEndPoints, p, level+1);
				}else{
					return traversed;
				}

			}else if(canGoLeft(currPos, deadEndPoints)){
				pointsTraversed.push(currPos);
				Point p=new Point(currPos.x, currPos.y-1);
				if(maze[p.x][p.y]!='E'){
					maze[p.x][p.y]='.';
				}
				
				traversed=exploreCurrentPos(pointsTraversed, deadEndPoints, p, level+1);
				if(!traversed){
					deadEndPoints.push(pointsTraversed.pop());
					return exploreCurrentPos(pointsTraversed, deadEndPoints, p, level+1);
				}else{
					return traversed;
				}
			}else{
				return traversed;
			}
		}

	}


	private boolean canGoRight(Point currPos, Stack<Point> deadEndPoints){
		Point p=new Point(currPos.x, currPos.y+1);
		return isValidMove(p, deadEndPoints);
	}

	private boolean canGoLeft(Point currPos, Stack<Point> deadEndPoints){
		Point p=new Point(currPos.x, currPos.y-1);
		return isValidMove(p, deadEndPoints);
	}

	private boolean canGoDown(Point currPos, Stack<Point> deadEndPoints){
		Point p=new Point(currPos.x+1, currPos.y);
		return isValidMove(p,  deadEndPoints);
	}

	private boolean canGoUp(Point currPos, Stack<Point> deadEndPoints){
		Point p=new Point(currPos.x-1, currPos.y);
		return isValidMove(p, deadEndPoints);
	}

	/**
	 * find the starting point in the maze
	 */
	public Point findStartPos(){
		for(int x=0; x<maze.length; x++){
			for(int y=0; y<maze[x].length; y++){
				if(maze[x][y]=='S'){
					return new Point(x,y);
				}
			}
		}
		return null;
	}

	/** 
	 * READING FROM FILE AND PRINTING THE MAZE METHODS
	 * @throws FileNotFoundException 
	 **/
	public void readMaze(String fileName) throws FileNotFoundException{
		File f=new File(fileName);
		Scanner read=new Scanner(f);
		int numOfLines=getNumOfLines(fileName);
		maze=new char[numOfLines][];
		for(int x=0; x<numOfLines; x++){
			String line=read.nextLine();
			maze[x]=new char[line.length()];
			for(int y=0; y<line.length(); y++){
				maze[x][y]=line.charAt(y);
			}
		}
		read.close();
	}

	public void printMaze(){
		for(int x=0; x<maze.length; x++){
			for(int y=0; y<maze[x].length; y++){
				System.out.print(maze[x][y]);
			}
			System.out.println();
		}
		//System.out.println(Arrays.deepToString(maze));
	}

	private int getNumOfLines(String fileName) throws FileNotFoundException{
		File f=new File(fileName);
		Scanner read=new Scanner(f);
		int i=0;
		while(read.hasNextLine()){
			read.nextLine();
			i++;
		}
		System.out.println("number of lines: "+i);
		read.close();
		return i;
	}

	/** END OF
	 *  READING FROM FILE AND PRINTING THE MAZE METHODS
	 * @throws FileNotFoundException 
	 **/

	/**
	 * Test Main
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException{
		Maze maze1=new Maze();
		maze1.readMaze("maze.txt");
		maze1.printMaze();
		System.out.println();
		System.out.println("\nTraversed: "+maze1.traverseMaze());
	}
}
