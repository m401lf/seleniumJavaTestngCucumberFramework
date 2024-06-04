package testScripts.streams.learnJava8.defaults;

import java.util.List;

/**
 * Created by z001qgd on 8/3/18.
 */
public interface Multiplier {

    static boolean isEmpty(List<Integer> integerList) {

        return integerList != null && integerList.size() > 0;
    }

    int multiply(List<Integer> integerList);

    default int size(List<Integer> integerList) {

        System.out.println("Inside Multiplier Interface");
        return integerList.size();
    }
}
