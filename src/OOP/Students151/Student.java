package OOP.Students151;

public class Student {
    private String name;
    private int age;
    private double averageGrade;

    public Student(String name, int age, double averageGrade) {
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
