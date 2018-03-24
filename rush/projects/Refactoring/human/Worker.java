public class Worker extends Human{
    private double salary;
    private String company;

    public Worker(String name, int age) {
        super(name, age);
    }

    public void live() {
        super.live();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
