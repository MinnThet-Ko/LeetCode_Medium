import java.util.HashMap;

public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(3999));
    }
    public static String intToRoman(int num) {
//        HashMap<Integer, String> integerRomanMap = new HashMap<>();
//        integerRomanMap.put(1000, "M");
//        integerRomanMap.put(900, "CM");
//        integerRomanMap.put(500, "D");
//        integerRomanMap.put(400, "CD");
//        integerRomanMap.put(100, "C");
//        integerRomanMap.put(90, "XC");
//        integerRomanMap.put(50, "L");
//        integerRomanMap.put(40, "XL");
//        integerRomanMap.put(10, "X");
//        integerRomanMap.put(9, "IX");
//        integerRomanMap.put(5, "V");
//        integerRomanMap.put(4, "IV");
//        integerRomanMap.put(1, "I");

        StringBuilder romanStringBuilder = new StringBuilder();

        String[] romanSymbolList = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int[] integerList = {1000, 900, 500, 400, 100, 90, 50, 40,  10, 9, 5, 4, 1};


        int index = 0;

        while(num > 0) {

            if (num >= integerList[index]){
                romanStringBuilder.append(romanSymbolList[index]);
                num =  num - integerList[index];
                if (num == 0) {
                    break;
                }
            } else {
                index++;
            }
        }
        return romanStringBuilder.toString();
    }
}
