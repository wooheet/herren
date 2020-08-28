package heren;

import java.util.Scanner;
import java.util.stream.DoubleStream;

/**
 * input
 *     우리나라 만세
 * output
 *     ㅇㄹㄴㄹ ㅁㅅ
 */
public class HerrenKoreanInitial {

    private static final String[] chs = {
            "ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ",
            "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ",
            "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ",
            "ㅋ", "ㅌ", "ㅍ", "ㅎ"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = getInitial(scanner.nextLine());
        System.out.println(result);
    }

    static String getInitial(String text) {
        StringBuilder sb = new StringBuilder();

        if(text.isEmpty()) return null;

        char[] cText = text.toCharArray();

        for (char c :  cText) {
            if(c >= 0xAC00) {
                int uniVal = c - 0xAC00;
                int cho = ((uniVal - (uniVal % 28))/28)/21;
                sb.append(chs[cho]);
            }

            if (c == 32) sb.append(' ');
        }

        return sb.toString();
    }
}
