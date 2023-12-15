public class Fraction {
    private int numer;
    private int denom;

    public Fraction() {
        this(1, 1);
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero.");
        this.numer = numerator;
        this.denom = denominator;
    }

    public Fraction(String fractionString) {
        String[] parts = fractionString.split("/");
        int num = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[1]);
        if (num2 != 0) {
            this.numer = num;
            this.denom = num2;
        } else {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
    }

    public Fraction(Fraction otherFraction) {
        this(otherFraction.numer, otherFraction.denom);
    }

    public int getNum() {
        return numer;
    }

    public int getDenom() {
        return denom;
    }

    public String toString() {
        return numer + "/" + denom;
    }

    public double toDouble() {
        return (double) numer / denom;
    }

    public void setNum(int numerator) {
        this.numer = numerator;
    }

    public void setDenom(int denominator) {
        if (denominator == 0){
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        else{
            this.denom = denominator;
        }
    }

    public static int GCF(int m, int n) {


        while (n != 0) {
            int temp = n;
            n = m % n;
            m = temp;
        }
        return m;
    }

    public void reduce() {
        int gcf = GCF(numer, denom);
        numer /= gcf;
        denom /= gcf;
    }

    public static Fraction multiply(Fraction fraction1, Fraction fraction2) {
        return new Fraction(fraction1.numer * fraction2.numer, fraction1.denom * fraction2.denom);
    }

    public static Fraction divide(Fraction fraction1, Fraction fraction2) {
        if (fraction2.numer == 0){
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return new Fraction(fraction1.numer * fraction2.denom, fraction1.denom * fraction2.numer);
    }

    public static Fraction add(Fraction fraction1, Fraction fraction2) {
        int commonDenom = fraction1.denom * fraction2.denom;
        int sumNum = fraction1.numer * fraction2.denom + fraction2.numer * fraction1.denom;
        return new Fraction(sumNum, commonDenom);
    }

    public static Fraction subtract(Fraction fraction1, Fraction fraction2) {
        int commonDenom = fraction1.denom * fraction2.denom;
        int diffNum = fraction1.numer * fraction2.denom - fraction2.numer * fraction1.denom;
        return new Fraction(diffNum, commonDenom);
    }

    public static void main(String[] args) {
        Fraction half = new Fraction(1, 2);
        Fraction third = new Fraction(1, 3);
        Fraction sum = Fraction.add(half, third);
        sum.reduce();
        System.out.println("Sum of fractions (1/2 + 1/3): " + sum.toString());
    }
}

class driver{
    public static void main(String[] args) {
        // Default Constructor
        Fraction fraction1 = new Fraction();
        System.out.println("Expected: 0/1");
        System.out.println("Actual: " + fraction1.toString());
        System.out.println();

        // Parameterized Constructor
        Fraction fraction2 = new Fraction(3, 4);
        System.out.println("Expected: 3/4");
        System.out.println("Actual: " + fraction2.toString());
        System.out.println();
        Fraction fraction3 = new Fraction(5, 0);
        System.out.println();

        //  String Constructor
        Fraction fraction4 = new Fraction("2/5");
        System.out.println("Expected: 2/5");
        System.out.println("Actual: " + fraction4.toString());
        System.out.println();
        Fraction fraction5 = new Fraction("1/0");
        System.out.println();


        // Multiplication
        Fraction fraction7 = Fraction.multiply(fraction2, fraction4);
        System.out.println("Expected: 6/20");
        System.out.println("Actual: " + fraction7.toString());
        System.out.println();

        // Division
        Fraction fraction8 = Fraction.divide(fraction2, fraction4);
        System.out.println("Expected: 15/8");
        System.out.println("Actual: " + fraction8.toString());
        System.out.println();

        //Addition
        Fraction fraction9 = Fraction.add(fraction2, fraction4);
        System.out.println("Expected: 23/20");
        System.out.println("Actual: " + fraction9.toString());
        System.out.println();

        // Subtraction
        Fraction fraction10 = Fraction.subtract(fraction2, fraction4);
        System.out.println("Expected: 7/20");
        System.out.println("Actual: " + fraction10.toString());
    }
}