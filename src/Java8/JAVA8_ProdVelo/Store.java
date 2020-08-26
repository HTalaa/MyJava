package Java8.JAVA8_ProdVelo;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Store {

    private final ArrayList<Order> ordersList = new ArrayList<>();
    private final ArrayList<Product> productsList = new ArrayList<>();

    public Store() {


    }

    public List<Product> topSellers(ProductType productType) {

        return getProductsList()
                .stream()
                .filter(product -> product
                        .getType()
                        .equals(productType))
                .sorted(Comparator.comparing(Product::getiNBSell).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }

    public ProductType mostProfCat() {

       Optional<ProductType> mostProfCat = Arrays.stream(ProductType.values()).max(Comparator.comparing(value ->
            getProductsList()
                    .stream()
                    .filter(product -> product
                            .getType()
                            .equals(value))
                    .mapToInt(product -> (int) (product.getPrice() * product.getiNBSell()))
                    .sum()));

        return mostProfCat.orElse(null);
    }

    public void restock(int quantity) {

        Predicate<Product> restockPred =
                product -> {
                    return product.getStockNumber() <= 0 && (LocalDate.now().toEpochDay() - product.getDateReStock().toEpochDay()) >= 7;
                };

        getProductsList()
                .stream()
                .filter(restockPred)
                .forEach(product -> product.setStockNumber(quantity));
    }

    public List<String> getBrandByCat(ProductType productType) {

        return getProductsList()
                .stream()
                .filter(product -> product
                        .getType()
                        .equals(productType))
                .map(Product::getMark)
                .collect(Collectors.toList());
    }

    public Float getMinByCat(ProductType productType) {

        return getProductsList()
                .stream()
                .filter(product -> product
                        .getType()
                        .equals(productType))
                .min(Comparator.comparing(Product::getPrice))
                .map(Product::getPrice)
                .orElse(null);
    }

    public Float getMaxByCat(ProductType productType) {

        return getProductsList()
                .stream()
                .filter(product -> product
                        .getType()
                        .equals(productType))
                .max(Comparator.comparing(Product::getPrice))
                .map(Product::getPrice)
                .orElse(null);
    }

    public List<Order> getCurrentsOrder() {

        return getOrdersList()
                .stream()
                .filter(order -> !order
                        .getCurrentStatus()
                        .equals(OrderStatus.ARRIVED))
                .collect(Collectors.toList());
    }

    public ArrayList<Order> getOrdersList() {
        return ordersList;
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

}
