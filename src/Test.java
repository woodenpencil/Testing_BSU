import java.util.Locale;
import java.util.Scanner;

public class Test {
    public Triangle read() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        return new Triangle(a, b, c);
    }
    
    public void printTestResult (String exp, String act) {
        System.out.println("Expected value: " + exp);
        System.out.println("Actual value: " + act);
        String testResult = exp.equals(act) ? "PASSED" : "FAIL";
        System.out.println("Test result: " + testResult);
    }
    
    public boolean Test1() {
        Triangle t = read();
        printTestResult("Versatile", t.type().toString());
        return t.type() == TriangleType.Versatile;
    }

    public boolean Test2() {
        
        for (int i = 0; i < 3; ++i) {
            Triangle t = read();
            
            if (t.type() != TriangleType.Isosceles) {
                return false;
            }
        }
        return true;
    }

    public boolean Test3() {
        Triangle t = read();
        return t.type() == TriangleType.Equilateral;
    }

    public boolean Test4() {
        return true;
    }

    public boolean Test5() {
        return true;
    }

    public boolean Test6() {
        return true;
    }

    public boolean Test7() {
        return true;
    }

    public boolean Test8() {
        return true;
    }

    public boolean Test9() {
        return true;
    }

    public boolean Test10() {
        return true;
    }

    public static void main(String[] args) {

    }
}
