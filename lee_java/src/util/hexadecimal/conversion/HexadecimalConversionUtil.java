package util.hexadecimal.conversion;

public class HexadecimalConversionUtil {

    private static boolean checkNull(String number) {
        boolean result = false;
        if (number == null || "".equals(number)) {
            System.err.println("错误：number 值为空");
            result = true;
        }
        return result;
    }

    private static boolean checkBase(int originalSystem) {
        boolean result = false;
        if (originalSystem < 2) {
            System.err.println("错误：originalSystem 值小于 2");
            result = true;
        }
        return result;
    }

    private static boolean checkHexadecimal(String number) {
        boolean result = false;
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if ((ch < '0' || '9' < ch)
                    && (ch < 'A' || 'F' < ch)
                    && (ch < 'a' || 'f' < ch)) {
                System.err.println("错误：十六进制字符串含有非法字符" + ch);
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean checkNumber(String number, int base) {
        boolean result = false;
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (ch < '0' || (base + '0' - 1) < ch) {
                System.err.println("错误：" + base + "进制字符串含有非法字符" + ch);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * 转为十进制
     *
     * @param number         字符串数字
     * @param originalSystem 原进制数
     * @return int 类型十进制数
     */
    private static int convertToDecimal(String number, int originalSystem) {

        number = number.toUpperCase();
        int n = 0;
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if ('0' <= ch && ch <= '9')
                n = n * originalSystem + (ch - '0');
            else if ('A' <= ch && ch <= 'F')
                n = n * originalSystem + (ch - 'A' + 10);
        }
        return n;
    }

    /**
     * 十进制转其它进制
     *
     * @param number       字符串数字
     * @param targetSystem 目标进制
     * @return 目标进制的字符串
     */
    private static String decimalToOther(String number, int targetSystem) {
        int n = convertToDecimal(number, 10);
        // StringBuffer 用来接收余数
        StringBuffer sb = new StringBuffer();
        while (n != 0) {
            int ch = n % targetSystem;
            sb.insert(0, ch < 10 ? ch : parseToHexString(ch));
            n /= targetSystem;
        }
        return sb.toString();
    }

    private static String parseToHexString(int ch) {
        return "" + (char) (ch - 10 + 'A');
    }

    /*
    ///////////////////////////////////////////////////////
    -----------------------这是分割线-----------------------
    ///////////////////////////////////////////////////////
     */

    public static String binaryToOctal(String binary) {
        return (checkNull(binary) || checkNumber(binary, 2)) ? "" :
                decimalToOther("" + convertToDecimal(binary, 2), 8);
    }

    public static String binaryToDecimal(String binary) {
        return (checkNull(binary) || checkNumber(binary, 2)) ? "" :
                "" + convertToDecimal(binary, 2);
    }

    public static String binaryToHexadecimal(String binary) {
        return (checkNull(binary) || checkNumber(binary, 2)) ? "" :
                decimalToOther("" + convertToDecimal(binary, 2), 16);
    }

    public static String octalToBinary(String octal) {
        return (checkNull(octal) || checkNumber(octal, 8)) ? "" :
                decimalToOther("" + convertToDecimal(octal, 8), 2);
    }

    public static String octalToDecimal(String octal) {
        return (checkNull(octal) || checkNumber(octal, 8)) ? "" :
                "" + convertToDecimal(octal, 8);
    }

    public static String octalToHexadecimal(String octal) {
        return (checkNull(octal) || checkNumber(octal, 8)) ? "" :
                decimalToOther("" + convertToDecimal(octal, 8), 16);
    }

    public static String decimalToBinary(String decimal) {
        return (checkNull(decimal) || checkNumber(decimal, 10)) ? "" :
                decimalToOther(decimal, 2);
    }

    public static String decimalToOctal(String decimal) {
        return (checkNull(decimal) || checkNumber(decimal, 10)) ? "" :
                decimalToOther(decimal, 8);
    }

    public static String decimalToHexadecimal(String decimal) {
        return (checkNull(decimal) || checkNumber(decimal, 10)) ? "" :
                decimalToOther(decimal, 16);
    }

    public static String hexadecimalToBinary(String hexadecimal) {
        return (checkNull(hexadecimal) || checkHexadecimal(hexadecimal)) ? "" :
                decimalToOther("" + convertToDecimal(hexadecimal, 16), 2);
    }

    public static String hexadecimalToOctal(String hexadecimal) {
        return (checkNull(hexadecimal) || checkHexadecimal(hexadecimal)) ? "" :
                decimalToOther("" + convertToDecimal(hexadecimal, 16), 8);
    }

    public static String hexadecimalToDecimal(String hexadecimal) {
        return (checkNull(hexadecimal) || checkHexadecimal(hexadecimal)) ? "" :
                "" + convertToDecimal(hexadecimal, 16);
    }

//    public static void main(String[] args) {
//        String str = decimalToOther("8", 2);
//        System.out.println(str);
//        System.out.println(convertToDecimal("g", 16));
//        System.out.println(binaryToOctal("1010"));
//        System.out.println(binaryToDecimal("1111"));
//        System.out.println(binaryToHexadecimal("1111111111111"));
//        System.out.println(octalToBinary("10"));
//        System.out.println(octalToDecimal("1010"));
//        System.out.println(octalToHexadecimal("777"));
//    }
}
