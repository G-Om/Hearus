package com.example.hearus.Entity;

import javax.persistence.*;
@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_NAME" , length = 50)
    private String userName;
    @Column(name = "EMAIL",unique = true, length = 50)
    private String email;
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "Relative_PhoneNumber")
    private String relativeNo;

    @Column(name = "Relative_Name")
    private String relativeName;


    //Empty Const
    public UserDetails() {
    }

    //Const with all attributes
    public UserDetails(Long id, String userName, String email, String password, String relativeNo, String relativeName) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.relativeName = relativeName;
        this.relativeNo = relativeNo;
    }
    //Const without id attribute
    public UserDetails(String userName, String email, String password, String relativeNo, String relativeName) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.relativeName = relativeName;
        this.relativeNo = relativeNo;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getRelativeName() {
        return relativeName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRelativeNo() {
        return relativeNo;
    }
//Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String user_name) {
        this.userName = user_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setRelativeName(String relativeName) {this.relativeName = relativeName;}
    public void setRelativeNo(String relativeNo) {
        this.relativeNo = relativeNo;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", user_name='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", relativeName='" + relativeName + '\'' +
                ", relativeNo=" + relativeNo +
                '}';
    }

}
