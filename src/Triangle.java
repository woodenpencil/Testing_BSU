enum TriangleType {
    Equilateral,
    Isosceles,
    Versatile
}

public class Triangle {
    public int _a;
    public int _b;
    public int _c;

    public boolean isTriangle() {
        return _a > 0 && _b > 0 && _c > 0 && _a < _b + _c && _b < _a + _c && _c < _a + _b;
    }

    public Triangle(int a, int b, int c) {
        //assert isTriangle(a, b, c);
        _a = a;
        _b = b;
        _c = c;
    }

    public long perimeter() {
        return (long)_a + _b + _c;
    }

    public double square() {
        double hp = (double)perimeter()/2;
        return Math.sqrt(hp*(hp-_a)*(hp-_b)*(hp-_c));
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
