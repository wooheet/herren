package heren;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 숫자는 모두 한자리 숫자만 사용, 같은 조합은 1번으로 판단, 각 숫자는 한번씩만 사용해야 합니다.
 *
 * input apdkf35k47n1t2
 * ouput 5
 *
 * ( 1,2,3,4 / 1,2,7 / 1,4,5 / 2,3,5 / 3,7 )
 *
 */
public class HerrenCombinationCount {

    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = extractNumbers(scanner.nextLine());

        int[] numbersArray = numbers.stream().mapToInt(i->i).toArray();
        combination(numbersArray, 0, 0);
        System.out.println(count);
    }

    static List<Integer> extractNumbers(String input) {
        String intStr = input.replaceAll("[^\\d]", "");

        List<Integer> intList = new ArrayList<>();

        int temp;
        int num = Integer.parseInt(intStr);

        while(num > 0) {
            temp = num % 10;
            num /= 10;

            intList.add(temp);
        }

        return intList.stream().sorted().collect(Collectors.toList());
    }

    static void combination(int[] numbersArray, int starting, int sum) {


        if (numbersArray.length == starting) return;

        if (sum == 10) {
            count++;
        }

        int value = sum + numbersArray[starting];

        combination(numbersArray, starting + 1, value);
        combination(numbersArray, starting + 1, sum);
    }
}
