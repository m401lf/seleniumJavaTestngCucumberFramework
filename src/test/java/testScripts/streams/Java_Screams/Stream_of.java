package testScripts.streams.Java_Screams;

import org.testng.annotations.Test;

import java.util.stream.Stream;

public class Stream_of{

    @Test
    public void StreamOf(){
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
        stream.forEach(System.out::println);
    }

}

