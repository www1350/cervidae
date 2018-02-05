package com.absurd.cervidae.utils;

/**
 * Value Encoding  Value Encoding  Value Encoding  Value Encoding
 0 a            17 r            34 I            51 Z
 1 b            18 s            35 J            52 0
 2 c            19 t            36 K            53 1
 3 d            20 u            37 L            54 2
 4 e            21 v            38 M            55 3
 5 f            22 w            39 N            56 4
 6 g            23 x            40 O            57 5
 7 h            24 y            41 P            58 6
 8 i            25 z            42 Q            59 7
 9 j            26 A            43 R            60 8
 10 k            27 B            44 S            61 9
 11 l            28 C            45 T
 12 m            29 D            46 U
 13 n            30 E            47 V
 14 o            31 F            48 W
 15 p            32 G            49 X
 16 q            33 H            50 Y
 * @author wangwenwei
 * @time 2018/2/5
 */
public class Base62Util {
    public static final String BASE_62_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static final int BASE = BASE_62_CHAR.length();

    public static long toBase10(String chars){
        return toBase10(chars.toCharArray());
    }

    private static long toBase10(char[] chars){
        long total = 0;
        int pow = 0;
        for(int i=chars.length;i>0;i--){
            total+=BASE_62_CHAR.indexOf(chars[i-1]) * Math.pow(BASE,pow);
            pow ++;
        }

        return total;
    }

    public static String fromBase10(long i){
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            return "a";
        }
        while (i >0) {
            int mod = (int) (i % BASE);
            sb.append(BASE_62_CHAR.charAt(mod));
            i = i / BASE;
        }
        return sb.reverse().toString();

    }
}
