import java.util.Scanner;
public class PiApproximation {
    public static void main(String[] args) {
        Fraction ini = new Fraction(355, 113);
        final double diff = Math.abs(Math.PI - ini.toDouble());

        Fraction Curr = new Fraction(22, 7); // Initial approximation

        while (Math.abs(Math.PI - Curr.toDouble()) >= diff) {
            if (Curr.toDouble() < Math.PI) {
                Curr.setNum(Curr.getNum() + 1);
            } else {
                Curr.setDenom(Curr.getDenom() + 1);
            }
        }

        System.out.println("The next closest fraction to PI is: " + Curr.toString());
    }
}

 class FractionQuizGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int correctCount = 0;
        int TotQ = 0;

        System.out.println("Fraction Quiz Begin. Answers should be in lowest terms ");

        while (true) {
            Fraction Frac1 = new Fraction(randomNumber(9) + 1, randomNumber(9) + 1);
            Fraction Frac2 = new Fraction(randomNumber(9) + 1, randomNumber(9) + 1);

            char operator = getRandomOperator();
            Fraction correctAnswer = calculateAnswer(Frac1, Frac2, operator);

            System.out.print(Frac1 + " " + operator + " " + Frac2 + " = ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("quit")) {
                break;
            }

            try {
                Fraction userAnswer = new Fraction(userInput);
                if (userAnswer.equals(correctAnswer)) {
                    System.out.println("Correct!\n");
                    correctCount++;
                } else {
                    System.out.println("Wrong, the answer was " + correctAnswer + "\n");
                }
                TotQ++;
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException | ArithmeticException e) {
                System.out.println("Invalid input. Please enter a valid fraction or 'quit'.");
            }
        }

        Fraction winLossRatio = new Fraction(correctCount, TotQ);
        int percentage = Math.round((float) correctCount / TotQ * 100);

        System.out.println("Your win/loss ratio was " + winLossRatio + ", for a score of " + percentage + " percent!");
    }

    private static int randomNumber(int max) {
        return (int) (Math.random() * max);
    }

    private static char getRandomOperator() {
        char[] operators = {'+', '-', '*', '/'};
        return operators[randomNumber(operators.length)];
    }

    private static Fraction calculateAnswer(Fraction operand1, Fraction operand2, char operator) {
        if (operator =='+') {
            return Fraction.add(operand1, operand2);
        }
        else if (operator =='-') {
            return Fraction.subtract(operand1, operand2);
        }
        else if (operator =='*') {
            return Fraction.multiply(operand1, operand2);
        }
        else if (operator =='/') {
            return Fraction.divide(operand1, operand2);
        }
        else{

                throw new IllegalArgumentException("Invalid operator");
        }
    }
}