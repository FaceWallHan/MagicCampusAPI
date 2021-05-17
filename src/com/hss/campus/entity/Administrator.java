package com.hss.campus.entity;

public class Administrator {
    private Integer id;
    private String password;
    private String position;
    private String avatar;
    private String name;
    private String unit;

    public Administrator() {
    }

    public Administrator(Integer id, String password, String position, String avatar, String name, String unit) {
        this.id = id;
        this.password = password;
        this.position = position;
        this.avatar = avatar;
        this.name = name;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", position='" + position + '\'' +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
