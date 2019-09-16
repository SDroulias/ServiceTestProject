package me.sdroulias.ServiceTestProject.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;


@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "idproducts")
    private int id;
    @Column(name="name")
    @NotNull
    @Size(min = 1, max = 100)
    private String name;
    @NotNull
    private int price;
    @NotNull
    private String code;
    @Column(name = "expdate")
    private Date expDate;
    @Column(name = "avdate")
    @NotNull
    private Date avDate;

    public Product() {}

    public Product(int id, String name, int price, String code, Date expDate, Date avDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.code = code;
        this.expDate = expDate;
        this.avDate = avDate;
    }

    public Product(String name, int price, String code, Date expDate, Date avDate) {
        this.name = name;
        this.price = price;
        this.code = code;
        this.expDate = expDate;
        this.avDate = avDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCode() {
        return code;
    }

    public Date getExpDate() {
        return expDate;
    }

    public Date getAvDate() {
        return avDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public void setAvDate(Date avDate) {
        this.avDate = avDate;
    }
}
