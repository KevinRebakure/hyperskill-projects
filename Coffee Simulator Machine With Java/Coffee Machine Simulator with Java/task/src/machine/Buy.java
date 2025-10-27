package machine;

// STEP 2. buy
// choose: (1) espresso, (2) latte, (3) cappuccino
// espresso - 250ml water, 16g beans -- $4
// latte - 350 ml water, 75ml milk, 20g beans -- $7
// cappuccino - 200ml water, 100ml milk, 12g beans - $6

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
                store.setWater(checkIfAvailable(store.getWater(), 250, "ml"));
                store.setCoffeeBeans(checkIfAvailable(store.getCoffeeBeans(), 16, "g"));
                store.setCups(checkIfAvailable(store.getCups(), 1, "cups"));
                pay(4);
                break;
            case "latte":
                store.setWater(checkIfAvailable(store.getWater(), 350, "ml"));
                store.setMilk(checkIfAvailable(store.getMilk(), 75, "ml"));
                store.setCoffeeBeans(checkIfAvailable(store.getCoffeeBeans(), 20, "g"));
                store.setCups(checkIfAvailable(store.getCups(), 1, "cups"));
                pay(7);
                break;
            case "cappuccino":
                store.setWater(checkIfAvailable(store.getWater(), 200, "ml"));
                store.setMilk(checkIfAvailable(store.getMilk(), 100, "ml"));
                store.setCoffeeBeans(checkIfAvailable(store.getCoffeeBeans(), 12, "g"));
                store.setCups(checkIfAvailable(store.getCups(), 1, "cups"));
                pay(6);
                break;
            case null, default:
                System.out.println("Invalid type");
        }

        message.showCurrentMachineStatus();
    }

    private int checkIfAvailable(int capacity, int request, String unit) {
        if (capacity >= request) {
            return capacity - request;
        } else {
            System.out.printf("Not enough water. We only have %d %s and your %s request require at least %d %s. Please refill the coffee machine", capacity, unit, type, request, unit);
            coffeMade = false;
            return capacity;
        }
    }

    private void pay(int amount) {
        if (coffeMade) {
            store.setMoney(store.getMoney() + amount);
        }
    }
}
