import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static AdvertisementStorage ourInstance = new AdvertisementStorage();
    private final List videos=new ArrayList();
    public static AdvertisementStorage getInstance() {
        return ourInstance;
    }
    private AdvertisementStorage() {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); //10 min
    }
    /**вернет список всех существующих доступных видео */
    public List list(){return videos;}
    public void add(Advertisement advertisement){videos.add(advertisement);}
}
