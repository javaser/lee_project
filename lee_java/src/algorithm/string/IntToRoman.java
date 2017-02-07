package algorithm.string;

public class IntToRoman {
    public static String intToRoman(int num) {
        String[] one = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        String[] ten = { "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] hundred = { "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC",
                "CM" };
        String[] thou = { "M", "MM", "MMM" };
        String roman = "";
        if(num >= 1000) {roman += thou[num/1000-1]; num = num%1000;}
        if(num >= 100) {roman += hundred[num/100 -1]; num = num %100;}
        if(num >= 10) {roman += ten[num/10 - 1];num = num%10;}
        if(num >= 1) roman += one[num%10 - 1];
        return roman;
    }
}
