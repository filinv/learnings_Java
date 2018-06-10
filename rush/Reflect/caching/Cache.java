import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();

    public V getByKey(K key, Class<V> clazz) throws Exception {
        if (!cache.containsKey(key)) {
            cache.put(key, clazz.getConstructor(key.getClass()).newInstance(key) );
        }
        return cache.get(key);
    }

    public boolean put(V obj){
        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            K key = (K) method.invoke(obj);
            int size=size();
            cache.put(key, obj);
            return size<size();
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {}
        return false;
    }

    public int size() {
        return cache.size();
    }
}
