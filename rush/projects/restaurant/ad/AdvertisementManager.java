public class AdvertisementManager {
    private final AdvertisementStorage storage=AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }
    /**AdvertisementManager выполняет только одно единственное действие - обрабатывает рекламное видео */
    public void processVideos(){
        ConsoleHelper.writeMessage("calling processVideos method");
    }
}
