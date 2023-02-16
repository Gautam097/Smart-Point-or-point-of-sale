
public class bill {
    int bill_id;
    String date_time;
    int total_price;
    String username;
    String customer_no;
    String payment_method;
    bill(int bill_id,String date_time,int total_price,String username,String customer_no,String payment_method){
      this.bill_id=bill_id;
      this.date_time=date_time;
      this.total_price=total_price;
      this.username=username;
      this.customer_no=customer_no;
      this.payment_method = payment_method;
    }
}
