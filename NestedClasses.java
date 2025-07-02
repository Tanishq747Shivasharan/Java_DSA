public class NestedClasses {
    class Calculator {
        public int add(int a, int b) {
            return a + b;
        }

        public int subtract(int a, int b) {
            return a - b;
        }

        public int multiply(int a, int b) {
            return a * b;
        }

        public double divide(int a, int b) {
            if(b != 0) {
                return a / b;
            }
            else{
                throw new ArithmeticException("Divide by zero not allowed");
            }
        }
    }

    public static void main(String[] args) {
        NestedClasses c = new NestedClasses();
        Calculator cal = c.new Calculator();

        System.out.println("Addition: " +cal.add(12, 5));
        System.out.println("Subtraction: " + cal.subtract(12, 5));
        System.out.println("Muliplicaiton: " + cal.multiply(12, 5));
        System.out.println("Division: " + cal.divide(10, 5));
    }
}
