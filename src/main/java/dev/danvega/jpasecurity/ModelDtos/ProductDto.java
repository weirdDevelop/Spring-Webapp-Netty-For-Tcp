package dev.danvega.jpasecurity.ModelDtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.danvega.jpasecurity.model.Product;
import dev.danvega.jpasecurity.model.Type;
import dev.danvega.jpasecurity.model.User;
import io.netty.channel.Channel;


public class ProductDto {



    private int id;
    private String name;

    private String macId;
    @JsonIgnore
    private Channel channel;
    private boolean online=true;

    public ProductDto(Product product, Channel channel) {
        this.id = product.getId();
        this.name = product.getName();
        this.macId = product.getMacId();
        this.channel = channel;
    }

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

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", macId='" + macId + '\'' +
                ", channel=" + channel +
                ", online=" + online +
                '}';
    }
}
