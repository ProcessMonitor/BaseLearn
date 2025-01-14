import com.google.common.base.Joiner;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class returnMethodBlock {


    class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }


    @Test
    void customCollectionTest() {
        // 构建一个 Person 集合
        List<Person> persons = Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 23),
                new Person("Pamela", 23),
                new Person("David", 12)
        );

        // T:person  A: StringJoiner R String
        // 我们希望将流中的所有人转换成一个字符串，包含所有大写的名称，并以|分割
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner("|"),   // supplier 供应器
                        (joiner, person) -> joiner.add(person.name.toUpperCase()),   // accumulator 累加器
                        (j1, j2) -> j1.merge(j2),                // combiner 组合器
                        (StringJoiner stringJoiner) -> stringJoiner.toString(), // finisher 终止器
                        Collector.Characteristics.UNORDERED
                );
        String names = persons.stream()
                .collect(personNameCollector); // 传入自定义的收集器
        System.out.println(names);  // MAX | PETER | PAMELA | DAVID

    }

    class Foo {
        String name;
        List<Bar> bars = new ArrayList<>();

        Foo(String name) {
            this.name = name;
        }
    }

    class Bar {
        String name;

        Bar(String name) {
            this.name = name;
        }
    }

    @Test
    void flatMapTest() {
        List<Foo> foos = new ArrayList<>();
        // 创建 foos 集合
        IntStream.range(1, 4).forEach(i -> foos.add(new Foo("Foo" + i)));
        // 创建 bars 集合
        foos.forEach(f -> IntStream.range(1, 4).forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));

//        foos.stream()
//                .flatMap((Foo f) -> f.bars.stream())
//                .forEach((Bar b) -> System.out.println(b.name));

        // 等价于
        foos.stream().forEach(foo -> foo.bars.stream().forEach(bar -> System.out.println(bar.name)));
    }

    @Test
    void reduceTest() {
        // 构建一个 Person 集合
        List<Person> persons = Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 23),
                new Person("Pamela", 23),
                new Person("David", 12)
        );
//        persons.stream()
//                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
//                .ifPresent(System.out::println);    // Pamela
        Person person = persons.stream()
                .reduce(new Person("", 0), (p1, p2) -> {
                    p1.age += p2.age;
                    p1.name += p2.name;
                    return p1;
                });
        System.out.format("name=%s; age=%s \n", person.name, person.age);
    }
}
