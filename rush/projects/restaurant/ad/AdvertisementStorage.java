public class AdvertisementStorage {
    private static AdvertisementStorage ourInstance = new AdvertisementStorage();
    public static AdvertisementStorage getInstance() {
        return ourInstance;
    }
    private AdvertisementStorage() {}
}
