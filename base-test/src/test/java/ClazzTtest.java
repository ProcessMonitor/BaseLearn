import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClazzTtest {


    public static class Person<T> {

        private T name;
    }


    public static class Student extends Person<String> {
        public Student(String name) {
            super.name = name;
        }
    }

    public class Teacher extends Person<Integer> {

    }


    public static void test1(List<? extends Person> list) {
        System.out.println(list);
    }

    public static void test2(List<? super Person> list) {
        System.out.println("to String :" + list.toString());
        System.out.println("print : " + list);
    }

    public static void main(String[] args) {

        List<Student> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();

        Student student1 = new Student("张三");
        Student student2 = new Student("张4");

        list1.add(student1);
        list1.add(student2);
        System.out.println(list1);
//        test1(list1);
//        test2(list2);
        List<Object> varibaleList = Collections.singletonList(list1);
        test2(varibaleList);
    }

}
