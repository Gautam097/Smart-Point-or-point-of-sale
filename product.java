
public class product {

    int product_id;
    String product_name;
    String brand;
    String description;
    String category_name;
    int price;
    int offerprice;
    String photo;

    product(int product_id, String product_name, String brand, String description, String category_name, int price, int offerprice, String photo) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.brand = brand;
        this.description = description;
        this.category_name = category_name;
        this.price = price;
        this.offerprice = offerprice;
        this.photo = photo;
    }
}
