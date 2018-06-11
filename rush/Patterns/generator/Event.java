public class Event {

    private static int nextId = 1;

    private int id;

    public Event() {
        id = nextId++;
    }

    public int getId() {
        return id;
    }
}
