package atmosware.questions.q4;

/*
Merhaba Osman Bey,
Öncelikle nasılsınız, umarım tatiliniz iyi geçiyordur :) Gönderdiğiniz algoritma sorusunun çözümünü ekte paylaştım.
Kısaca çözüm yolunu anlatmaya çalışayım.
Başlangıçta global index=0 değeri tanımladım. Amacı dizide her kontrol yaptığımda  ulasilacakToplam değeri bulamadığım
zaman index'i 1 arttırmak ve her defasında diziyi daraltarak ilerlemek. Method başlangıçta dizi uzunluğunu kontrol
ediyor. Yeterli uzunlukta değil ise false dönüyor. Devamında int sum değişkeni tanımlıyorum. Değeri ise kullanılan
dizenin index'e göre başlangıç değeri(yani index 2 ise dizide 2. eleman başlangıç değeri olur) olarak tanımlıyorum.
Dizenin başlangıç değeri ile ulasilacakToplam değer
eşit olabilir fakat mailde bizden  'dizede yan yana olsun ve toplamları 'ulasilacakToplam' sayısına eşit ' olması
istendiği için en az iki değer olması gerektiğini düşündüm. Böylelikle for'a girmeden bu kuralı sağlamış oluyorum.

Örneğin alttaki dizeler verilsin, ulasilacakToplam = 1 için;
arr = {1} -> false
arr = {1,0} -> true
arr = {1,2,4,1,0} -> 1,0 -> true
arr = {1,2,4} -> false
Bu kural ile ilk değer 1 geldiğinde true dönmesini engelliyorum.

For i, index+1 değeri ile başlar. For en kötü senaryoda dizi uzunluğu kadar döner ve her defasında sum'a dizi
değerlerini ekler. İçerisinde if ile ulasilacakToplam değeri sum'a eşit olup olmadığını kontrol ediyorum. Eşit ise ilk
alt kümeyi bulmuş olur ve for'u bitirir true döner. Eşit değil ise toplamaya devam eder. Eğer index dizi uzunluğundan
küçük ise if'e girer ve index'i 1 arttırır fonksiyonu yeniden çağırır. En kötü senaryoda index ile dizi uzunluğu
eşitlenir ve dizide böyle bir alt küme olmadığı için false döner.


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
