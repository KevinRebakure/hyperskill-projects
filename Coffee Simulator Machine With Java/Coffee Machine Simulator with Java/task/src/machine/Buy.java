package machine;

public class Buy {
    private final String type;
    private final Store store;
    private final Message message;

    private int money;
    private boolean coffeMade = true;

    public Buy(String type, Store store, Message message) {
        this.store = store;
        this.type = type;
        this.message = message;
    }

    public void buyCoffee() {
        switch (type) {
            case "espresso":
                store.setWater(checkIfAvailable(store.getWater(), 250, "ml", "water"));
                store.setCoffeeBeans(checkIfAvailable(store.getCoffeeBeans(), 16, "g", "beans"));
                store.setCups(checkIfAvailable(store.getCups(), 1, "cups", "cups"));
                pay(4);
                break;
            case "latte":
                store.setWater(checkIfAvailable(store.getWater(), 350, "ml", "water"));
                store.setMilk(checkIfAvailable(store.getMilk(), 75, "ml", "milk"));
                store.setCoffeeBeans(checkIfAvailable(store.getCoffeeBeans(), 20, "g", "beans"));
                store.setCups(checkIfAvailable(store.getCups(), 1, "cups", "cups"));
                pay(7);
                break;
            case "cappuccino":
                store.setWater(checkIfAvailable(store.getWater(), 200, "ml", "water"));
                store.setMilk(checkIfAvailable(store.getMilk(), 100, "ml", "milk"));
                store.setCoffeeBeans(checkIfAvailable(store.getCoffeeBeans(), 12, "g", "beans"));
                store.setCups(checkIfAvailable(store.getCups(), 1, "cups", "cups"));
                pay(6);
                break;
            case null, default:
                System.out.println("Invalid type");
        }
    }

    private int checkIfAvailable(int capacity, int request, String unit, String resource) {
        if (capacity >= request) {
            return capacity - request;
        } else {
            System.out.printf("Sorry, not enough %s", resource);
            System.out.println();
//            System.out.printf("Not enough water. We only have %d %s and your %s request require at least %d %s. Please refill the coffee machine", capacity, unit, type, request, unit);
            coffeMade = false;
            return capacity;
        }
    }

    private void pay(int amount) {
        if (coffeMade) {
            store.setMoney(store.getMoney() + amount);
            message.haveEnoughResources();
        }
    }
}
