package Java8.JAVA8_ProdVelo;
import java.util.List;

public class Order implements Runnable {
    private List<Product> productsList;
    private OrderStatus currentStatus = OrderStatus.CONFIRMED;
    private Customer customer;
    private static int idNmbr= 0;
    private int orderId=idNmbr++;

    public Order(List<Product> productsList, Customer customer) {
        this.productsList = productsList;
        this.customer = customer;
        Thread t= new Thread(this);
        t.start();
    }

    @Override
    public void run() {

        try{
            setCurrentStatus(OrderStatus.TRANSIT);
            Thread.sleep(15000);
            setCurrentStatus(OrderStatus.ARRIVED);
            System.out.println(this+ "\n"+"-------IS FINISHED---------");

        }

        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    public OrderStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(OrderStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "products=" + productsList +
                ", currentStatus=" + currentStatus +
                ", customer=" + customer +
                "id= "+getOrderId()+'}';
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}

