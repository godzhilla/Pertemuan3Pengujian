import org.example.Student;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentTest {
    private  List<Student> students;

    @BeforeAll
    public void initClass() {
        students = new ArrayList<>();
        System.out.println("BeforeAll dijalankan");
    }

    @AfterAll
    public void cleanClass() {
        students.clear();
        System.out.println("AfterAll dijalankan");
    }

    @BeforeEach
    public void initMethod() {
        students.add(new Student("Ashila", 20));
        students.add(new Student("Mark", 25));
        System.out.println("BeforeEach dijalankan");
    }

    @AfterEach
    public void cleanMethod() {
        students.clear();
        System.out.println("AfterEach dijalankan");
    }

    @Test
    public void testGetName() {
        Assertions.assertFalse(students.isEmpty());
        Assertions.assertEquals("Ashila", students.get(0).getName());
        Assertions.assertEquals("Mark", students.get(1).getName());
        System.out.println(students.get(0).getName());
        System.out.println(students.get(1).getName());
    }

    @Test
    public void testGetAge() {
        Assertions.assertFalse(students.isEmpty());
        Assertions.assertEquals(20, students.get(0).getAge());
        Assertions.assertEquals(25, students.get(1).getAge());
        System.out.println(students.get(0).getAge());
        System.out.println(students.get(1).getAge());
    }

    @Test
    public void testStudentEnrolment() {
        Student student = students.get(0);
        student.enrollCourse("Algoritma Pemrograman");
        student.enrollCourse("Praktikum Pengujian");
        Assertions.assertTrue(student.getEnrolledCourses().contains("Praktikum Pengujian"));
        Assertions.assertTrue(student.getEnrolledCourses().contains("Algoritma Pemrograman"));
        System.out.println(student.getEnrolledCourses().toString());

        Student student1 = students.get(1);
        student1.enrollCourse("Math");
        student1.enrollCourse("Science");
        System.out.println(student1.getEnrolledCourses().toString());

    }

    @Test
    public void testStudentGrade() {
        Student student = students.get(0);
        student.setGrade("Algoritma Pemrograman", "A");
        student.setGrade("Praktikum Pengujian", "B");
        Assertions.assertEquals("A", student.getGrade("Algoritma Pemrograman"));
        System.out.println("Nilai mata kuliah Pengujian " + student.getGrade("Praktikum Pengujian"));
        System.out.println("Nilai mata kuliah Alpro " + student.getGrade("Algoritma Pemrograman"));
    }

}
