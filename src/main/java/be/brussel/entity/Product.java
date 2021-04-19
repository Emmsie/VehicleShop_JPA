package be.brussel.entity;

import javax.persistence.*;

@Entity(name = "products")
@NamedQuery(name = "Product.readAllProducts", query = "SELECT p FROM products p")
public class Product {

    @Id
    @Column
    private String productCode;

    @Column
    private String productName;

    @ManyToOne
    @JoinColumn (name = "productLine")
    private ProductLine productLine;

    @Column
    private String productScale;

    @Column
    private String productVendor;

    @Column
    private String productDescription;

    @Column
    private short quantityInStock;

    @Column
    private double buyPrice;

    @Column
    private double MSRP;

    public Product() { }

    public Product(String productCode, String productName, ProductLine productLine, String productScale,
                   String productVendor, String productDescription, short quantityInStock, double buyPrice, double MSRP) {

        this.productCode = productCode;
        this.productName = productName;
        this.productLine = productLine;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.MSRP = MSRP;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductLine getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public short getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(short quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getMSRP() {
        return MSRP;
    }

    public void setMSRP(double MSRP) {
        this.MSRP = MSRP;
    }

    @Override
    public String toString() {

        return String.format("PRODUCT  ||  Code: %-10s  |  Name: %-50s  |  Price: €%7.2f |  Quantity: %5d",
                productCode, productName, MSRP, quantityInStock);

    }
}