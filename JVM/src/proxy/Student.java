package proxy;

public class Student implements Person{
    String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        System.out.println(name+" give money");
    }
}
