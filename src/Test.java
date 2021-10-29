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
    
    public void Test1() {
        Triangle t = read();
        printTestResult("Equilateral", t.isTriangle() ? t.type().toString():"Not a triangle");
        //return t.type() == TriangleType.Versatile;
    }

    public void Test2() {
        Triangle t = read();
        printTestResult("Equilateral", t.isTriangle() ? t.type().toString():"Not a triangle");
        //return t.type() == TriangleType.Equilateral;
    }

    public void Test3_5() {
        for (int i = 0; i < 3; ++i) {
            Triangle t = read();
            printTestResult("Isosceles", t.isTriangle() ? t.type().toString():"Not a triangle");
        }
    }

    public void Test6_10() {
        for (int i = 0; i < 5; ++i) {
            Triangle t = read();
            if (t._a!=0 &&  t._b!=0 && t._c!=0)
                printTestResult("Triangle has null side(s)", "Triangle has not null side(s)");
            else
                printTestResult("Triangle has null side(s)", "Triangle has null side(s)");
        }
    }

    public void Test11() {
            Triangle t = read();
            if (t._a>=0 &&  t._b>=0 && t._c>=0)
                printTestResult("Triangle has negative side(s)", "Triangle has not negative side(s)");
            else
                printTestResult("Triangle has negative side(s)", "Triangle has negative side(s)");
    }

    public void Test12_14() {
        for (int i = 0; i < 3; ++i) {
            Triangle t = read();
            if (t._a == t._b + t._c || t._b == t._a + t._c || t._c == t._a + t._b)
                printTestResult("Sum of two sides equals the third", "Sum of two sides equals the third");
            else
                printTestResult("Sum of two sides equals the third", "Sum of two sides doesn't equal the third");
        }
    }

    public void Test15_17() {
        for (int i = 0; i < 3; ++i) {
            Triangle t = read();
            if (t._a < t._b + t._c && t._b < t._a + t._c && t._c < t._a + t._b)
                printTestResult("Sum of two sides less than the third", "Sum of two sides less than the third");
            else
                printTestResult("Sum of two sides less than the third", "Sum of two sides is not less than the third");
        }
    }

    public void Test8() {

    }

    public void Test9() {

    }

    public void Test21() {
        Triangle t = read();
        if((long)t.square()>2147483647 || (long)t.perimeter()>2147483647)
            printTestResult("Square or perimeter are int", "Square or perimeter are out of int");
        else
            printTestResult("Square or perimeter are int", "Square or perimeter are int");
    }

    public void main(String[] args) {
        Test1();

    }
}
