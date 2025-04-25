package hust.soict.hedspi.lab01;
import java.util.Scanner;

public class SameSizeMatrix {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dien so hang: ");
        int row = scanner.nextInt();
        System.out.print("Dien so cot: ");
        int coll = scanner.nextInt();
        System.out.println("Enter the first matrix:");
        int[][] matrix1 =MatrixInfor(scanner, row, coll);
        System.out.println("Enter the second matrix:");
        int[][] matrix2 = MatrixInfor(scanner, row, coll);
        int[][] result = MatrixAdding(matrix1, matrix2,row,coll);
        System.out.println("The matrix by add matA and matB is: ");
		for(int i=0;i<row;i++) {
			for(int j=0;j<coll;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.print("\n");
        }
	}
        private static int[][] MatrixInfor(Scanner scanner, int row, int coll) {
            int[][] matrix = new int[row][coll];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < coll; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            return matrix;
        }
        private static int[][] MatrixAdding(int[][] mat1,int[][] mat2,int row, int coll){
        	int[][] matrix = new int[row][coll];
        	for (int i=0;i<row;i++) {
    			for(int j=0;j<coll;j++) {
    				matrix[i][j]=mat1[i][j] + mat2[i][j];
    			}
    		}
        	return matrix;
        }
}
