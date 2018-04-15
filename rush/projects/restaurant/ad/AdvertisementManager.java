import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage=AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }
    /**AdvertisementManager выполняет только одно единственное действие - обрабатывает рекламное видео */
    public void processVideos() throws NoVideoAvailableException{
        List<Advertisement> ads=storage.list();
        if(ads.isEmpty())throw new NoVideoAvailableException();
        
        List<Advertisement> videoToBeShown = new ArrayList<>(ads);

        Collections.sort(videoToBeShown, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                if (result == 0)
                    result = Long.compare(o1.getAmountPerOneDisplaying() / o1.getDuration(), o2.getAmountPerOneDisplaying() / o2.getDuration());
                return result;
            }
        });        
    }
}
