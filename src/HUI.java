import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
                handleProductMenu();
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
    //------------<SHOP>-----------
    //could be in a separate class
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
//------------</SHOP>-----------
//------------<PRODUCT>-----------
    private void handleProductMenu(){
        if(shop==null){
            System.out.println("Create shop first");
            return;
        }
        do {
            printer.printProductMenu();
            printer.printGuidance();
        } while (huiForProductMenu(printer.getUserInput()));
    }

    private boolean huiForProductMenu(String ui) {
        switch (getChoiceFromString(ui)) {
            case 1:
                addNewProduct();
                break;
            case 2:
            updateQuantityByName();
                break;
            case 3:
                deleteProductByName();
                break;
            case 4:
                printProducts();
                break;
            case 5:
                return false;
            default:
                return true;
        }
        return true;
    }

    private void deleteProductByName() {
        String name= printer.printDeleteProduct();
        Product product = getProductByName(name);
        if(product==null){
            return;
        }
        shop.deleteProduct(product);
    }

    private Product getProductByName(String name){
        Product productToUpdate;
        try {
            productToUpdate = shop.getProducts()
                    .keySet()
                    .stream()
                    .filter(product -> product.getName().equals(name))
                    .findFirst().orElseThrow(IllegalArgumentException::new);
        }catch (IllegalArgumentException e){
            System.out.println("No product with such name");
            return null;
        }
        return productToUpdate;
    }

    private void updateQuantityByName() {
        List <String> data= printer.printUpdateProduct();
        Product productToUpdate = getProductByName(data.get(0));
        if(productToUpdate==null){
            return;
        }
        int parsed =  getChoiceFromString(data.get(1));
        if(parsed==-1){
            return;
        }
        shop.deleteProduct(productToUpdate);
        shop.addProduct(productToUpdate,parsed);
    }

    private void addNewProduct() {

        List<String> data =  printer.printAddProduct();
        Product product = new ProductImpl();
        try {
            product.setPrice(new BigDecimal(data.get(0)));
            product.setName(data.get(1));
            product.setCompany(data.get(2));
            product.setExpireDate(LocalDate.parse(data.get(3)));
        }catch (Exception e){
            System.out.println("Invalid data");
            product = null;
            return;
        }
        int parsed =  getChoiceFromString(data.get(4));
        if(parsed==-1){
            return;
        }
        shop.addProduct(product,parsed);
    }

    private void printProducts() {
        printer.printProducts(shop.getProductsInfo());
    }

    //------------</PRODUCT>-----------
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
