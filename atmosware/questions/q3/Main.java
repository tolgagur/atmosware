package atmosware.questions.q3;

import java.util.Scanner;

//
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(palindromeTamamlayiciSayi(scanner.nextLine()));
    }

    public static String palindromeTamamlayiciSayi(String sayi) {

        try {
            Integer.parseInt(sayi);

        } catch (NumberFormatException nfe) {
            return "Format Tamsayı degil";
        }

        boolean b = true;
        int count = 0;

        int number = Integer.parseInt(sayi);
        while (b) {
            String numString = String.valueOf(number);
            String numStringRe = reString(numString);
            if (String.valueOf(number).equals(numStringRe)) {
                return number - count + " + " + count + " = " + number;
            } else {
                number++;
                count++;
            }
        }

        return "";
    }

    private static String reString(String numString) {
        StringBuilder reNumber = new StringBuilder();
        for (int i = numString.length() - 1; i >= 0; i--) {
            reNumber.append(numString.charAt(i));
        }
        return reNumber.toString();
    }

}
