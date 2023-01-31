package dev.danvega.jpasecurity.ModelDtos;


import dev.danvega.jpasecurity.model.Product;
import dev.danvega.jpasecurity.model.Type;
import dev.danvega.jpasecurity.model.User;
import io.netty.channel.Channel;


public class ProductDto {


    private int id;

    private User user;
    private Type type;
    private String name;
    private String macId;
    private Channel channel;


    public ProductDto(Product product, Channel channel) {
     this.id=product.getId();
     this.user=product.getUser();
     this.name=product.getName();
     this.macId=product.getMacId();
     this.type=product.getType();
     this.channel=channel;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", user=" + user +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", macId='" + macId + '\'' +
                ", channel=" + channel +
                '}';
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
}
