public class Generator<T> {
    Class<T> tClass;

    public Generator(Class<T> tClass) {
        this.tClass = tClass;
    }

    T newInstance() {
        T instance=null;
        try {
            instance=tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return instance;
    }
}
