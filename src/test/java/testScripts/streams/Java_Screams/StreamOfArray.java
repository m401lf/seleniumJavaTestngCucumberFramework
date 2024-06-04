package testScripts.streams.Java_Screams;

import org.testng.annotations.Test;

import java.util.stream.Stream;

public class StreamOfArray {

        @Test
        public void StreamOf(){
            Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
            //stream.forEach(System.out::println);
            stream.forEach(System.out::println);
        }

        @Test
        public void StreamOf_String(){
            Stream<String> stream = Stream.of("Benjamin","Andrew", "Donald","Alfred");
            stream.forEach(System.out::println);
        }
}
