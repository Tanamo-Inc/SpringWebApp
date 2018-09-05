package com.tanamoinc.springwebapp.domain;

/**
 *
 * @author Tanamo
 */
public class Contact {

    private Integer id; //PK
    private Integer userId; //FK
    private String cName;
    private String phone;
    private String email;
    private String address;
    private String remark;

    public Contact() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer _id) {
        this.id = _id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
