public class Advertisement {
    private Object content;// - видео
    private String name;// - имя/название
    private long initialAmount;// - начальная сумма, стоимость рекламы в копейках.
    private int hits;// - количество оплаченных показов
    private int duration;// - продолжительность в секундах
    /**Оно должно равняться стоимости одного показа
     * рекламного объявления в копейках (initialAmount/hits) */
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying=initialAmount/hits;
    }
    public String getName() {
        return name;
    }
    public int getDuration() {
        return duration;
    }
    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }
}
