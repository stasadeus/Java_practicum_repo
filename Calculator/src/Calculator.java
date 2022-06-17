public class Calculator {
    String calculate(String str) {
        String result = null;
        try {
            String[] c = new String[5];
            c = str.split(" ");
            double aDouble = Double.parseDouble(c[0]);
            double bDouble = Double.parseDouble(c[2]);
            if (!c[1].equals("+") && !c[1].equals("-") && !c[1].equals("/") && !c[1].equals("*"))
                throw new Exception("Operation Error!");
            if (c[1].equals("/") && bDouble == 0) throw new ArithmeticException();
            switch (c[1]) {
                case "+":
                    result = str + " = " + String.valueOf(aDouble + bDouble);
                    break;
                case "-":
                    result = str + " = " + String.valueOf(aDouble - bDouble);
                    break;
                case "/":
                    result = str + " = " + String.valueOf(aDouble / bDouble);
                    break;
                case "*":
                    result = str + " = " + String.valueOf(aDouble * bDouble);
                    break;
            }
        } catch (ArithmeticException ex) {
            result = str + " = Error! Division by zero";
        } catch (NumberFormatException ex) {
            result = str + " = Error! Not number";
        } catch (Exception ex) {
            result = str + " = " + ex.getMessage();
        } finally {
            return result;
        }
    }
}
