package OOP.Students151;

public class WorkStudents {
    public static void main(String[] args) {
        Group group = new Group(5);

        Student student1 = new Student("One", 20, 4.5);
        Student student2 = new Student("Two", 20, 4);
        Student student3 = new Student("Three", 20, 3.3);

        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);

        double average = group.getAverage();

        System.out.println("Средний балл по группе: " + average);

        System.out.println(group.displayStudents(student1));
        System.out.println(group.displayStudents(student2));
        System.out.println(group.displayStudents(student3));
    }
}
