
public class bill_details {

    int bill_details_id;
    int billing_id;
    String product_name;
    int price;
    int offerprice;

    bill_details(int bill_details_id,int billing_id,String product_name,int price,int offerprice) {
        this.bill_details_id=bill_details_id;
        this.billing_id=billing_id;
        this.product_name=product_name;
        this.price = price;
        this.offerprice = offerprice;
    }
}
