package testScripts.streams.learnJava8.functionalInterfaces;

import testScripts.streams.learnJava8.data.Student;
import testScripts.streams.learnJava8.data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionStudentExample {

    static Function<List<Student>, Map<String, Double>> studentFunction = (students -> {

        Map<String, Double> studentGrademap = new HashMap<>();
        students.forEach((student -> {
            if (PredicateStudentExample.p1.test(student)) {
                studentGrademap.put(student.getName(), student.getGpa());
            }

        }));
        return studentGrademap;

    });

    public static void main(String[] args) {

        System.out.println(studentFunction.apply(StudentDataBase.getAllStudents()));

    }
}
