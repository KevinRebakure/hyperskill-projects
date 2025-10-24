package machine;

public class Message {
    private final Store store;
    public Message(Store store) {
        this.store = store;
    }

    public void startApp() {
        System.out.println("The coffee machine has:");
        System.out.println(String.format("%d ml of water", store.getWater()));
        System.out.println(String.format("%d ml of milk", store.getMilk()));
        System.out.println(String.format("%d g of coffee beans", store.getCoffeeBeans()));
        System.out.println(String.format("%d disposable cups", store.getCups()));
        System.out.println(String.format("$%d of money", store.getMoney()));
        System.out.println();
    }
}
