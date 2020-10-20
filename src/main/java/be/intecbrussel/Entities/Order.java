package be.intecbrussel.Entities;

import org.dom4j.Text;
import org.hibernate.type.TextType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="orders")
public class Order {

    @Id
    private int orderNumber;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private String status;
    private TextType comments;

    @ManyToOne
    private Customer costumerNumber;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TextType getComments() {
        return comments;
    }

    public void setComments(TextType comments) {
        this.comments = comments;
    }

    public Customer getCostumerNumber() {
        return costumerNumber;
    }

    public void setCostumerNumber(Customer costumerNumber) {
        this.costumerNumber = costumerNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", orderDate=" + orderDate +
                ", requiredDate=" + requiredDate +
                ", shippedDate=" + shippedDate +
                ", status='" + status + '\'' +
                ", comments=" + comments +
                ", costumerNumber=" + costumerNumber +
                '}';
    }
}
