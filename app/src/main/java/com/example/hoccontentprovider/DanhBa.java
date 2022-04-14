package com.example.hoccontentprovider;

import java.io.Serializable;

public class DanhBa implements Serializable {
    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public DanhBa() {
    }

    public void setPhone(String phone) {
        this.phone = phone;

    }

    public DanhBa(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", phone='" + phone + '\'';
    }
}
