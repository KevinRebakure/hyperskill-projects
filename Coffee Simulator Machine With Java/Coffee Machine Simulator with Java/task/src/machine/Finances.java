package machine;


public class Finances {
    private final Store store;
    public Finances(Store store) {
        this.store = store;
    }

    public int take() {
        int currentRevenue = store.getMoney();
        store.setMoney(0);
        return currentRevenue;
    }
}
