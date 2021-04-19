package be.brussel.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity(name = "productlines")
public class ProductLine {

    @Id
    @Column
    private String productLine;

    @Column
    private String textDescription;

    @Column
    private String htmlDescription;

    @Column
    @Lob
    private byte[] image;

    public ProductLine() { }

    public ProductLine(String productLine, String textDescription, String htmlDescription, byte[] image) {
        this.productLine = productLine;
        this.textDescription = textDescription;
        this.htmlDescription = htmlDescription;
        this.image = image;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ProductLine{" +
                "productLine='" + productLine + '\'' +
                ", textDescription='" + textDescription + '\'' +
                ", htmlDescription='" + htmlDescription + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
