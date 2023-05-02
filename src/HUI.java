import java.util.HashMap;
import java.util.List;

/**
 * Shorthand for HandleUserInput
 */
public class HUI {
    private final ConsoleMenuPrinter printer;
    private Shop shop;

    public HUI(ConsoleMenuPrinter printer) {
        this.printer = printer;
    }

    public void runMainMenu() {
        do {
            printer.printGreetings();
            printer.printMainMenu();
            printer.printGuidance();
        }
        while(huiForMainMenu(printer.getUserInput()));
    }

    private boolean huiForMainMenu(String ui) {
        switch (getChoiceFromString(ui)) {
            case 1:
                handleShopMenu();
                break;
            case 2:
                break;
            case 3:
                System.exit(0);
            default:
                return true;

        }
        return true;
    }

    private void handleShopMenu() {
        do {
            printer.printShopMenu();
            printer.printGuidance();
        } while (huiForShopMenu(printer.getUserInput()));
    }

    private boolean huiForShopMenu(String ui) {
        switch (getChoiceFromString(ui)) {
            case 1:
                addNewShop();
                break;
            case 2:
                updateShop();
                break;
            case 3:
                deleteShop();
                break;
            case 4:
                printShop();
                break;
            case 5:
                return false;
            default:
                return true;
        }
        return true;
    }


    private void addNewShop() {
        List<String> list = printer.printAddShop();
        this.shop = new ShopImpl();
        shop.setName(list.get(0));
        shop.setOwnerName(list.get(1));
    }

    private void updateShop() {
        if (validateShop()) {
            List<String> list = printer.printAddShop();
            shop.setName(list.get(0));
            shop.setOwnerName(list.get(1));
        } else {
            addNewShop();
        }
    }

    private void deleteShop() {
        shop.setName("");
        shop.setOwnerName("");
        shop.setProducts(new HashMap<>());
    }

    private void printShop() {
        printer.printShopData(shop);
    }

    private int getChoiceFromString(String choice) {
        try {
            int parsedChoice = Integer.parseInt(choice);
            System.out.println(parsedChoice);
            return validateUserInput(parsedChoice) ? parsedChoice : -1;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
        return -1;
    }

    private boolean validateUserInput(int input) {
        return input >= 1;
    }

    private boolean validateShop() {
        return shop != null;
    }
}
