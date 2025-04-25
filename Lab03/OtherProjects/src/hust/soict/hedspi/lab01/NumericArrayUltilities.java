package hust.soict.hedspi.lab01;
import java.util.Scanner;
public class NumericArrayUltilities {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Nhap so phan tu cua mang: ");
			int n = sc.nextInt();
			double[] arr = new double[n];
			System.out.println("Nhap cac phan tu cua mang: ");
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextDouble();
			}
			for(int i=0;i<n;i++) {
				for(int j=i+1;j<n;j++) {
					if(arr[i] > arr[j]) {
						double temp = arr[i];
						arr[i]= arr[j];
						arr[j]=temp;
					}
				}
			}
			double sum=0;
			for(int i=0;i<n;i++) {
				sum+=arr[i];
			}
			double avg = sum/n;
			System.out.print("Mang sau khi da sap xep la: ");
			for(int i=0;i<n;i++) {
				System.out.print(arr[i] +" ");
			}
			System.out.println("\nTong cua mang: " + sum);
			System.out.print("So trung binh cong cua mang:" + avg);
		
		}

}
