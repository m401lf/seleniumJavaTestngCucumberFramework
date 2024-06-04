package testScripts.streams.Java_Screams;

import java.util.Arrays;
import java.util.List;

public class Filtering_and_Collecting_into_a_List {

        public static void main(String[] args) {

            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

            List<Integer> evenNumbers = list.stream()
                    .filter(n -> n % 2 == 0)
                    .toList();

            System.out.println(evenNumbers);
        }

}
