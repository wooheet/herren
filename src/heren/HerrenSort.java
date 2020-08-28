package heren;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 *  랜덤한 숫자를 n개를 받아서 정렬(내림차순)해주세요.
 *
 *  input(첫번째 입력은 숫자의 갯수, 두번째는 정렬할 데이터)
 *     5
 *     1,8,3,6,5
 *  output
 *     8,6,5,3,1
 *
 *
 */
public class HerrenSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        try {
            List<Integer> input = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(","))
                    .map(Integer::parseInt)
                    .collect(toList());

            if (input.size() == n)
                System.out.println(result(input));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }


        bufferedReader.close();
    }

    static String result(List<Integer> input) {
        return input.stream().sorted(Comparator.reverseOrder())
                .map(Object::toString)
                .collect(joining(","));
    }

}
