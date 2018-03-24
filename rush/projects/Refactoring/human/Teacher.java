public class Teacher extends Human {
    private int numberOfStudents;    

    public Teacher(String name, int age, int numberOfStudents) {
        super(name, age);
        this.numberOfStudents = numberOfStudents;
    }

    public void live() {
        teach();
    }

    public void teach() {
    }    

    public void printData() {
        System.out.println("Преподаватель: " + name);
    }
}
