public class MyMagazinche extends magazinche
{
    private String title;

    public MyMagazinche(String name, String author, double price) {
        super(name, author, price);
    }

    @Override
    public void getDetails() {
        System.out.println(title + " " + getName()+  " " + getAuthor() + " " + getPrice());
    }
}