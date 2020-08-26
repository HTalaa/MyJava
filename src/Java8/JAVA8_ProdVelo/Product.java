package Java8.JAVA8_ProdVelo;

import java.time.LocalDate;

public class Product {
    private String mark;
    private String model;
    private float price;
    private int iNBSell=0;
    private int stockNumber;
    private ProductType type;
    private LocalDate dateReStock;

    public Product(String mark, String model, float price, int iNBSell, int stockNumber, ProductType type, LocalDate dateReStock) {
        this.mark = mark;
        this.model = model;
        this.price = price;
        this.iNBSell = iNBSell;
        this.stockNumber = stockNumber;
        this.type = type;
        this.dateReStock = dateReStock;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getiNBSell() {
        return iNBSell;
    }

    public void setiNBSell(int iNBSell) {
        this.iNBSell = iNBSell;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public LocalDate getDateReStock() {
        return dateReStock;
    }

    public void setDateReStock(LocalDate dateReStock) {
        this.dateReStock = dateReStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", iNBSell=" + iNBSell +
                ", stockNumber=" + stockNumber +
                ", type=" + type +
                ", dateReStock=" + dateReStock +
                '}';
    }
}
