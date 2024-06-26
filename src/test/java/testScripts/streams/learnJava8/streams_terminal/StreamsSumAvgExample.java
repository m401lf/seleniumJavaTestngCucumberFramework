package testScripts.streams.learnJava8.streams_terminal;

import testScripts.streams.learnJava8.data.Student;
import testScripts.streams.learnJava8.data.StudentDataBase;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.summingInt;

public class StreamsSumAvgExample {

    public static int sum() {

        return StudentDataBase.getAllStudents()
                .stream()
                .collect(summingInt(Student::getNoteBooks));
    }

    public static double average() {

        return StudentDataBase.getAllStudents()
                .stream()
                .collect(averagingInt(Student::getNoteBooks));
    }

    public static void main(String[] args) {

        System.out.println("Total No of notebooks : " + sum());

        System.out.println("Average No of notebooks : " + average());
    }
}
