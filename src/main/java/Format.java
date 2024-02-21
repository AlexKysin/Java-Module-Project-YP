public class Format {
    static String formatRub(double sum) {
        int a = (int) sum;
        if (a > 100) {
            a %= 100;
        }
        if (a > 20) {
            a %= 10;
        }
        switch (a) {
            case 1:
                return " рубль";
            case 2:
            case 3:
            case 4:
                return " рубля";
            default:
                return " рублей";
        }
    }
}
