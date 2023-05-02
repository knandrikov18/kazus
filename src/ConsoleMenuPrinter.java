import java.util.List;

public interface ConsoleMenuPrinter {
    void printGreetings();

    void printMainMenu();

    void printShopMenu();
    List<String> printAddShop();
    void printShopData(Shop shop);

    void printProductMenu();


    void printGoodbyeMessage();

    void printGuidance();

    String getUserInput();
}
