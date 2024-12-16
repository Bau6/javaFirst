package OOP.Students151;

public class Group {
    private Student[] students;
    private int size;

    public Group(int capacity) {
        students = new Student[capacity];
        size = 0;
    }

    public void addStudent(Student student) {
        students[size] = student;
        size++;
    }

    public void removeStudent(Student student) {
        for (int i = 0; i < size; i++) {
            if (students[i].equals(student)) {
                students[i] = null;
                break;
            }
        }
    }

    public double getAverage() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            if (students[i] != null) {
                sum += students[i].getAverageGrade();
            }
        }
        return sum / size;
    }

    public String displayStudents(Student student) {

            if (student != null) {
                return ("Имя: " + student.getName() +
                        " Возраст: " + student.getAge() + " Оценка: "
                        + student.getAverageGrade());
            }
        return null;
    }
}
