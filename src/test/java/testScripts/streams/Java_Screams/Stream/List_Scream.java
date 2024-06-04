package testScripts.streams.Java_Screams.Stream;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class List_Scream {

    @Test
    public void ScreamsOf() {
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 1; i< 10; i++){
            list.add(i);
        }

        Stream<Integer> stream = list.stream();
        stream.forEach(System.out::println);
    }
}
