public class TooShortStringSecondThreadException extends RuntimeException {
    Throwable e;
    public TooShortStringSecondThreadException(Throwable e){
        super(e);
        this.e=e;
    }
    @Override
    public String toString() {
        String name="TooShortStringSecondThreadException";
        return name;
    }
}
