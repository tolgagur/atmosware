package atmosware.questions.q3;

import java.util.List;

public class Exampe {
    List<String> numbers = List.of("0","1","2","3","4","5","6","7","8","9");
    public static void main(String[] args) {
        System.out.println(palindromeTamamlayiciSayi("222.45"));

    }
    public static String palindromeTamamlayiciSayi(String sayi) {

        boolean isNum = sayi.matches("[0-9]*");
        if(isNum)
            System.out.println( "String bir tamsayıdır.");
        else
            throw new NumberFormatException("String tamsayı degildir.");

        String sayiR = reString(sayi);
        if (sayi.length()%2==0){
            //12 3 54
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
