package dev.danvega.jpasecurity.model;
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
     @ManyToOne(optional = false)
     @JoinColumn(name="type_id")
     private Type type;

     @ManyToOne
     @JoinColumn(name="user_id")
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

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", macId='" + macId + '\'' +
                ", type=" + type +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
