package atmosware.questions.q2;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<String> words = new ArrayList<>();

    private static List<List<Integer>> wordsCharValue = new LinkedList<>();
    private static String alphabet = "";



    public static void main(String[] args) {

        //kelime kontrolu (kelimeler bosluklarla ayrılmış sekilde girilir. alfabedeki karakterlerin dışındaki bütün
        //karakterler silinir ve liste liste döner.
        //Örnek kelimeler (input) : YAKINLAŞTIRMAK, ,YERELLEŞTİRMEK  YAPAYLAŞTIRMAK, YAPILABİLİRLİK, YANITLANDIRMAK , YARDIMSEVERLİK, YASAKLAYICILIK, YASALAŞTIRILMA, YASALLAŞTIRMAK, YASSILAŞTIRMAK, YATIŞTIRICILIK, YAVANLAŞTIRMAK, YAYGINLAŞTIRMA, YELKOVANGİLLER, YENİŞARBADEMLİ, YERELLEŞTİRMEK, YERLEŞTİRİLMEK, YETİŞTİRİCİLİK, YETKİLENDİRMEK,
        //Standart alfabe sırası : abcçdefgğhiıjklmnoöprsştuüvyz
        getWords();
        // alfabe kontrolunde set kullandım. 29 farklı karakter olmazsa tekrar alfabe girmenizi istiyor string olarak
        //alıyorum. örnek (input) -> abcçdefgğhiıjklmnoöprsştuüvyz
        validAlphabet();
        //sıralama kontrolu
        validSord();

    }

    private static void validAlphabet() {

        System.out.println("Alfabe sirasini giriniz");

        Set<Character> characters = new HashSet<>();

        String string = scanner.nextLine().trim().toLowerCase(Locale.ROOT).replace(" ","");

        for (int i = 0; i < string.length(); i++) {

            characters.add(string.charAt(i));
        }
        System.out.println(characters.size());
        if (characters.size()==29)
            alphabet = string;
        else{
            System.out.println(characters);
            System.out.print("Eksik veya hatali girdiniz. ");
            validAlphabet();
        }

    }

    private static void getWords() {

        System.out.println("Kelimeleri boşluk kullanarak giriniz.");

        String string = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
        String[] strings = string.split(" ");

        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].replaceAll("[^(defgauğıvijçklümnocöprsyhbştz)]","").trim();
        }
        for (int i = 0; i < strings.length; i++) {
            if (!strings[i].equals(""))
                words.add(strings[i]);
        }
        System.out.println("Girilen kelimeler : " + words);
    }


    public static void validSord() {

        charValue(words);

        System.out.println("Karakter degerleri : " + wordsCharValue);

        boolean b = true;
        for (int i = 0; i < words.size() - 1; i++) {
            b = compareToWords(words.get(i), words.get(i + 1));
            if (!b) break;
        }
        System.out.println(b ? "Sirali" : "Sirali degil");

    }

    private static void charValue(List<String> words) {
        for (String word : words) {
            List<Integer> list3 = new LinkedList<>();
            for (int j = 0; j < word.length(); j++) {
                list3.add(alphabet.indexOf(word.charAt(j)));
            }
            wordsCharValue.add(list3);
        }
    }

    private static boolean compareToWords(String str1, String str2) {
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            if ((alphabet.indexOf(str1.charAt(i)) < alphabet.indexOf(str2.charAt(i))))
                return true;
            else if ((alphabet.indexOf(str1.charAt(i)) > alphabet.indexOf(str2.charAt(i))))
                return false;
        }
        return true;

    }


}
