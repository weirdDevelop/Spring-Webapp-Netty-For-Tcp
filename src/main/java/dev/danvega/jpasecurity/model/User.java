package dev.danvega.jpasecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.checkerframework.checker.regex.qual.Regex;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull(message = "email address is null")
    @Pattern(regexp = "^(.+)@(\\\\S+)$")
    private String emailAddress;

    @NotNull(message = "name is null")
    private String name;
    @NotNull(message = "phone is null")
    @Pattern(regexp = "(0|\\+98)?([ ]|-|[()]){0,2}9[1|2|3|4]([ ]|-|[()]){0,2}(?:[0-9]([ ]|-|[()]){0,2}){8}"
            ,message = "لطفا شماره موبایل صحیحی را وارد کنید" )
    private String phoneNumber;
    @JsonIgnore
    @NotNull(message = "password is null")
    private String password;

    private String roles;

    @Transient
    private String reWritePassword;


    public User(int id, String emailAddress, String name, String phoneNumber, String password, String roles, String reWritePassword) {
        this.id = id;
        this.emailAddress = emailAddress;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.roles = roles;
        this.reWritePassword = reWritePassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", emailAddress='" + emailAddress + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                ", reWritePassword='" + reWritePassword + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getReWritePassword() {
        return reWritePassword;
    }

    public void setReWritePassword(String reWritePassword) {
        this.reWritePassword = reWritePassword;
    }
}
