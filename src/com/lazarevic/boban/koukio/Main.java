package com.lazarevic.boban.koukio;

import com.lazarevic.boban.koukio.priorities.Priorities;
import com.lazarevic.boban.koukio.student.Student;
import com.lazarevic.boban.koukio.utils.IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        try (InputStream config = new FileInputStream("src/resources/config.properties")) {
            Properties properties = new Properties();
            properties.load(config);

            Priorities priorities = Priorities.getInstance();

            List<String> input = IO.readFile(properties.getProperty("input.file"));

            List<Student> students = priorities.getStudents(input);

            students.stream().forEach(System.out::println);
        } catch (IOException e) {
            // e.printStackTrace();
        }
    }

}
