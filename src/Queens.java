/* Rashad saab, rms78, 201301697 */

public class Queens {
	
	/**
	 * 	PRINTING THE BOARD
	 */
	public static void printBoard(int[] qns){
		int N=qns.length;
		for (int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(qns[i]==j){
					System.out.print("Q ");
				}else{
					System.out.print("* ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * 	CHECK IF CURRENT PLACEMENT IS CORRECT
	 */
	public static boolean checkPos(int[] qns, int col){
		for(int i=0; i<col; i++){
			if(qns[i]==qns[col]){ // if on same column
				return false;
			}
			if((qns[col]-qns[i])==(col-i)){ //if on same diagonal(upper left to lower right)
				return false;
			}
			if((qns[i]-qns[col])==(col-i)){ //if on same diagonal(lower left to upper right)
				return false;
			}
		}
		return true;
	}
	
	public static void placeQueens(int n){
		int[] queens=new int[n];
		placeQueens(queens, 0);
	}
	
	private static void placeQueens(int[] qns, int col){
		if(col==qns.length){
			printBoard(qns);
		}else{
			for (int i=0; i<qns.length; i++) {
				qns[col]=i;
				if(checkPos(qns, col)){
					placeQueens(qns, col+1);
				}
			}
		}
	}

	public static void main(String[] args){
		int N = Integer.parseInt("8");
		Long start=System.currentTimeMillis();
		placeQueens(N);
		Long end=System.currentTimeMillis();
		System.out.println("Runtime: "+(end-start)+"ms");
	}
}
