package atmosware.questions.q4;

/*



* */
public class Main {

    private static int index = 0;

    public static void main(String[] args) {

        int[] arr1 = {};
        int[] arr2 = {0};
        int[] arr3 = {1, 2};
        int[] arr4 = {1, 2, 3};
        int[] arr5 = {1, 2, 4, 1, 0};
        int[] arr6 = {-4, 2, 6};
        int[] arr7 = {1, 2, 4, 2, 3, 5, 7, 3, 1, 2, 3, 4, 6};
        int[] arr8 = {-1, -2, -3, -4, -5, -1, 2, -23, -5, -5, 5};

        int[] ints = {1, 3, 1, 4, 23};
        int[] ints2 = {0, 5};
        int[] ints3 = {11, 123, 4, 23, 21, 3, 14, 123, 12, 523, 2, 324, 0, 0, 1, 3, 5, 456, 567, 35, 24, 234, 33, 456, 567, 3, 32, 24, 3, 3, 456, 4534, 52, 4, 24, 23, 534, 543, 4, 765, 234, 4, 344, 3};

        System.out.println(siraliAltKumeVarMi(arr8, 1));
    }

    public static boolean siraliAltKumeVarMi(int[] sayilar, int ulasilacakToplam) {
        if (sayilar.length <= 1 || index == sayilar.length)
            return false;

        int sum = sayilar[index];
        StringBuilder test = new StringBuilder(sum + "");
        for (int i = index + 1; i < sayilar.length; i++) {
            sum += sayilar[i];
            test.append(" ").append(sayilar[i]);

            if (sum == ulasilacakToplam) {
                System.out.println(test);
                return true;
            }
        }
        if (index < sayilar.length) {
            index++;
            System.out.println("error " + test);
            return siraliAltKumeVarMi(sayilar, ulasilacakToplam);
        }
        return false;
    }
}
