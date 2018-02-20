public class TooShortStringFirstThreadException extends RuntimeException {
    Throwable e;

    public TooShortStringFirstThreadException(Throwable e){
        super(e);
        this.e=e;
    }
    @Override
    public String toString() {
        String name="TooShortStringFirstThreadException";
        return name;
    }
}
