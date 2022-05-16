package youtube;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

        static String[] convert = {
                "N",
                "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        public static void main(String[] args) throws Exception {
                Calc calc = new Calc();
                Scanner scanner = new Scanner(System.in);
                String usesInput = scanner.nextLine();
                String[] str = usesInput.split(" ", 3);
                if ( str.length !=3)
                        throw new Exception("т.к. строка не является математической операцией");
                String a = str[0];
                calc.op = str[1];
                String b = str[2];
                if (Arrays.asList(convert).contains(a)&&!Arrays.asList(convert).contains(b)||!Arrays.asList(convert).contains(a)&&Arrays.asList(convert).contains(b))
                        throw new Exception("т.к. используются одновременно разные системы счисления");

                if (Arrays.asList(convert).contains(a)&&Arrays.asList(convert).contains(b)) {
                        calc.num1 = Arrays.asList(convert).indexOf(a);
                        calc.num2 = Arrays.asList(convert).indexOf(b);
                        if (calc.num1 >= 1 && calc.num1 <= 10 && calc.num2 >= 1 && calc.num2 <= 10) {
                                int res = calc.mat();
                                if(res <= 0)
                                        throw new Exception("т.к. в римской системе нет отрицательных чисел");
                                else
                                System.out.println(convert[calc.mat()]);
                                return;
                        }

                        throw new Exception("Вводимые числа не должны быть меньше I и больше X");

                }
                else {
                        try {
                                calc.num1 = Integer.parseInt(a);
                                calc.num2 = Integer.parseInt(b);
                        } catch (Exception e) {
                                throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                        }

                        if (calc.num1 >= 1 && calc.num1 <= 10 && calc.num2 >= 1 && calc.num2 <= 10) {
                                System.out.println(calc.mat());
                        }
                        if (calc.num1 <= 0 || calc.num1 > 10 || calc.num2 <= 0 || calc.num2 > 10)
                                throw new Exception("Вводимые числа не должны быть меньше 1 и больше 10");
                }


        }
}
class Calc{
        int num1;
        int num2;
        String op;
        int res;
        int mat() {
                switch (op) {
                        case "+" -> {
                                res = num1 + num2;
                                return res;
                        }
                        case "-" -> {
                                res = num1 - num2;
                                return res;
                        }
                        case "*" -> {
                                res = num1 * num2;
                                return res;
                        }
                        case "/" -> {
                                res = num1 / num2;
                                return res;

                        }
                }

        return res;
}}