package com.lrcf.yhb.pojo;

import java.io.Serializable;

public class BaseConfig implements Serializable {
    private Integer id;

    private String title;

    private String name;

    private String value;

    private String valuese;

    private String data;

    private String from;

    private String description;

    private Integer orders;

    private String res1;

    private String res2;

    private String res3;

    private String res4;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValuese() {
        return valuese;
    }

    public void setValuese(String valuese) {
        this.valuese = valuese;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getRes1() {
        return res1;
    }

    public void setRes1(String res1) {
        this.res1 = res1;
    }

    public String getRes2() {
        return res2;
    }

    public void setRes2(String res2) {
        this.res2 = res2;
    }

    public String getRes3() {
        return res3;
    }

    public void setRes3(String res3) {
        this.res3 = res3;
    }

    public String getRes4() {
        return res4;
    }

    public void setRes4(String res4) {
        this.res4 = res4;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BaseConfig other = (BaseConfig) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getValuese() == null ? other.getValuese() == null : this.getValuese().equals(other.getValuese()))
            && (this.getData() == null ? other.getData() == null : this.getData().equals(other.getData()))
            && (this.getFrom() == null ? other.getFrom() == null : this.getFrom().equals(other.getFrom()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getOrders() == null ? other.getOrders() == null : this.getOrders().equals(other.getOrders()))
            && (this.getRes1() == null ? other.getRes1() == null : this.getRes1().equals(other.getRes1()))
            && (this.getRes2() == null ? other.getRes2() == null : this.getRes2().equals(other.getRes2()))
            && (this.getRes3() == null ? other.getRes3() == null : this.getRes3().equals(other.getRes3()))
            && (this.getRes4() == null ? other.getRes4() == null : this.getRes4().equals(other.getRes4()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getValuese() == null) ? 0 : getValuese().hashCode());
        result = prime * result + ((getData() == null) ? 0 : getData().hashCode());
        result = prime * result + ((getFrom() == null) ? 0 : getFrom().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getOrders() == null) ? 0 : getOrders().hashCode());
        result = prime * result + ((getRes1() == null) ? 0 : getRes1().hashCode());
        result = prime * result + ((getRes2() == null) ? 0 : getRes2().hashCode());
        result = prime * result + ((getRes3() == null) ? 0 : getRes3().hashCode());
        result = prime * result + ((getRes4() == null) ? 0 : getRes4().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", name=").append(name);
        sb.append(", value=").append(value);
        sb.append(", valuese=").append(valuese);
        sb.append(", data=").append(data);
        sb.append(", from=").append(from);
        sb.append(", description=").append(description);
        sb.append(", orders=").append(orders);
        sb.append(", res1=").append(res1);
        sb.append(", res2=").append(res2);
        sb.append(", res3=").append(res3);
        sb.append(", res4=").append(res4);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}