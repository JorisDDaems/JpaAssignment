package be.intecbrussel.Entities;


import org.hibernate.type.BlobType;
import org.hibernate.type.TextType;
import org.w3c.dom.Text;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Blob;

@Entity
@Table(name = "productlines")
public class ProductLine {

    @Id
    private String productLine;
    private String textDescription;
    private TextType htmlDescription;
    private BlobType image;

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

    public TextType getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(TextType htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public BlobType getImage() {
        return image;
    }

    public void setImage(BlobType image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ProductLine{" +
                "productLine='" + productLine + '\'' +
                ", textDescription='" + textDescription + '\'' +
                ", htmlDescription=" + htmlDescription +
                ", image=" + image +
                '}';
    }
}


