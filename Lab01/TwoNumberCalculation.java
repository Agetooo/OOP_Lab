import javax.swing.JOptionPane;
public class TwoNumberCalculation{
    public static void main(String[] args){
        String a,  b;
        a = JOptionPane.showInputDialog(null,"Nhap so dau tien: ","Ghi gia tri dau tien",JOptionPane.INFORMATION_MESSAGE);
        b= JOptionPane.showInputDialog(null,"Nhap so thu hai: ", "Ghi gia tri thu hai",JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(a);
        double num2 = Double.parseDouble(b);
        double sum= num1+num2;
        double difference = num1-num2;  
        double product= num1*num2;
        double divisor = 0; 
        if (num2 != 0) {
            divisor = num1 / num2;
        } else {
            JOptionPane.showMessageDialog(null, "Khong the chia cho 0", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }

        String strmessage = "Sum: " + sum + "\nDifference: " + difference + "\nProduct: " + product;

        if (num2 != 0) {
            strmessage += "\nDivisor: " + divisor;
        }
        JOptionPane.showMessageDialog(null,strmessage,"Ket qua",JOptionPane.INFORMATION_MESSAGE);
    }
}