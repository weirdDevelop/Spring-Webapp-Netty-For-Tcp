package dev.danvega.jpasecurity.model;



import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class GpsRecords implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private float lon;
    private float lat;
    private float speed;
    private Date Time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    @Override
    public String toString() {
        return "GpsRecords{" +
                "id=" + id +
                ", lon=" + lon +
                ", lat=" + lat +
                ", speed=" + speed +
                ", Time=" + Time +
                '}';
    }
}
