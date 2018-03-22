public class Soldier extends Human{
    public Soldier(String name, int age){
        super(name, age);
    }

    public void fight() {
    }
    public void live() {
        fight();
    }
}
