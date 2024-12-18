package com.education.ztu;

public class Product implements Comparable<Product> {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public int compareTo(Product other) {
        // Сортування за ціною продукту
        return Double.compare(this.price, other.price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Double.compare(product.price, price) == 0 &&
                quantity == product.quantity &&
                name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + Double.hashCode(price) + Integer.hashCode(quantity);
    }

    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 1000.0, 5);
        Product p2 = new Product("Phone", 500.0, 10);
        Product p3 = new Product("Tablet", 700.0, 3);

        System.out.println("Product 1: " + p1);
        System.out.println("Product 2: " + p2);
        System.out.println("Product 3: " + p3);

        System.out.println("Comparison p1 vs p2: " + p1.compareTo(p2)); // Compare by price
        System.out.println("Comparison p2 vs p3: " + p2.compareTo(p3)); // Compare by price

        System.out.println("Equality check p1 and p2: " + p1.equals(p2));
    }
}