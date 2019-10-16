import java.util.Set;
import java.util.TreeSet;

public class Testsort {
    public static void main(String args[]) {
        Set<Person> allSet = new TreeSet<Person>();
        allSet.add(new Person("赵六", 34));
        allSet.add(new Person("张三", 30));
        allSet.add(new Person("王五", 35));
        allSet.add(new Person("李四", 31));
        allSet.add(new Person("孙七", 33));
        System.out.println(allSet);
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "姓名：" + this.name + "；年龄：" + this.age;
    }

    public int compareTo(Person per) {
        if (this.age > per.age) {
            return 1;
        } else if (this.age < per.age) {
            return -1;
        } else {
            return this.name.compareTo(per.name); // 调用String中的compareTo()方法
        }
    }
}
