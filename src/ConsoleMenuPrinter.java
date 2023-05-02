import java.util.List;

public interface ConsoleMenuPrinter {
    void printGreetings();

    void printMainMenu();

    void printShopMenu();
    List<String> printAddShop();
    void printShopData(Shop shop);

    void printProductMenu();
    List<String> printAddProduct();
    List<String> printUpdateProduct();
    String printDeleteProduct();
    void printProducts(String products);

    void printGoodbyeMessage();

    void printGuidance();

    String getUserInput();
}
