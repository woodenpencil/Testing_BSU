enum TriangleType {
    Equilateral,
    Isosceles,
    Versatile
}

public class Triangle {
    public int _a;
    public int _b;
    public int _c;

    private boolean isTriangle(int a, int b, int c) {
        return a < b + c && b < a + c && c < a + b;
    }

    public Triangle(int a, int b, int c) {
        assert a > 0 && b > 0 && c > 0 && isTriangle(a, b, c);
        _a = a;
        _b = b;
        _c = c;
    }

    public long perimeter() {
        return (long)_a + _b + _c;
    }

    public long square() {
        return 0;
    }

    TriangleType type() {
        if (_a == _b && _b == _c) {
            return TriangleType.Equilateral;
        }
        if (_a == _b || _a == _c || _b == _c) {
            return TriangleType.Isosceles;
        }
        return TriangleType.Versatile;
    }

}
