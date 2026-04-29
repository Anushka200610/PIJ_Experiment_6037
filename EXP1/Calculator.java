import java.util.Scanner;
public class Calculator {
    public int ch, num1, num2;
    public int addNuma(int n1, int n2) {
        return n1 + n2;
    }
    public int substractNums(int n1, int n2) {
        return n1 - n2;
    }
    public long multiplyNums(int n1, int n2) {
        return n1 * n2;
    }
    public double DivideNums(int n1, int n2)
    {
        return (double)n1/n2;
    }
    public int calMod(int n1, int n2)
    {
        return n1%n2;
    }
    public static void main(String args[])
    {
        Calculator op=new Calculator();
        Scanner sc=new Scanner(System.in);
        do {
            System.out.print("\nThe operation you want to perform: 1:Addition 2:Substraction 3: Multiplication 4:Division 5: Modulus\nchoice: ");
            op.ch = sc.nextInt();
            if(op.ch==0)
                System.exit(0);
            System.out.println("Enter First number value:");
            op.num1 = sc.nextInt();
            System.out.println("Enter Second number value:");
            op.num2 = sc.nextInt();
            switch (op.ch) {
                case 1:
                    int sum = op.addNuma(op.num1, op.num2);
                    System.out.println("The sum is: " + sum);
                    break;
                case 2:
                    int diff = op.substractNums(op.num1, op.num2);
                    System.out.println("The difference is: " + diff);
                    break;
                case 3:
                    long prod = op.multiplyNums(op.num1, op.num2);
                    System.out.println("The product is: " + prod);
                    break;
                case 4:
                    if (op.num2 == 0) {
                        System.out.println("Number 2 cannot be zero");
                        break;
                    }
                    double div = op.DivideNums(op.num1, op.num2);
                    System.out.println("The Divisor is: " + div);
                    break;
                case 5:
                    double mod = op.calMod(op.num1, op.num2);
                    System.out.println("The Remainder is: " + mod);
                    break;
                default:
                    System.out.println("Wrong choice");
                    System.out.println("Try Again");
            }
        }while(op.ch!=0);
        sc.close();
    }
}