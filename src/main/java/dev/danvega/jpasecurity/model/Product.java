package dev.danvega.jpasecurity.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Product")
public class Product implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private int id;
     private String name;
     private String macId;
     private boolean activate;
     private String expirationDate;
     @ManyToOne(optional = false,fetch = FetchType.LAZY)
     @JoinColumn(name="type_id")
     @JsonIgnore
     private Type type;

     @ManyToOne
     @JoinColumn(name="user_id")
     @JsonIgnore
     private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }

    public Type getType() {
        return type;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setType(Type type) {
        this.type = type;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", macId='" + macId + '\'' +
                ", activate=" + activate +
                ", expirationDate='" + expirationDate + '\'' +
                ", type=" + type +
                ", user=" + user +
                '}';
    }
}
