package testScripts.streams.Java_Screams.Stream;

import org.testng.annotations.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream_of_String_chars_or_tokens {

    @Test
    public void streamOfString(){
        IntStream stream = "12345_abcdefg".chars();
        stream.forEach(System.out::println);

//OR

        Stream<String> stream1 = Stream.of("A$B$C".split("\\$"));
        stream1.forEach(System.out::println);
    }

}
