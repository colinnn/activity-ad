package com.lenovo.ad.bean.game;

/**
 * Created by chenlm3 on 2017/7/20.
 */
import javax.persistence.*;

@Entity
@Table(name="xx_dictionary")
public class Dictionary {
    @Id
    private String id;
    private String name;// Name
    private String value;// VALUE
    private String type;// 所属类型
    private String displayName;// 界面显示名称
    private Integer orderList;// 排序

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public Integer getOrderList() {
        return orderList;
    }

    @Column(nullable = false)
    public void setOrderList(Integer orderList) {
        this.orderList = orderList;
    }
    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}