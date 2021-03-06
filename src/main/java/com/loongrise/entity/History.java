package com.loongrise.entity;

import java.util.Date;

/**
 * 历史记录表实体类
 */
public class History {
    private long historyId;
    //当前结点的上一个结点
    private long pre;
    //当前结点的下一个结点
    private long next;
    //当前结点的上一个结点的整个hash值
    private String hashCode;
    private String epc;
    private String tid;
    //当前所处结点
    private String name;
    private String address;
    private Date date;

    //对应的零部件
    private long  amId;
    private long amCategory;

    public long getAmCategory() {
        return amCategory;
    }

    public void setAmCategory(long amCategory) {
        this.amCategory = amCategory;
    }

    public long getAmId() {
        return amId;
    }

    public void setAmId(long amId) {
        this.amId = amId;
    }

    public long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(long historyId) {
        this.historyId = historyId;
    }

    public long getPre() {
        return pre;
    }

    public void setPre(long pre) {
        this.pre = pre;
    }

    public long getNext() {
        return next;
    }

    public void setNext(long next) {
        this.next = next;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    public String getEpc() {
        return epc;
    }

    public void setEpc(String epc) {
        this.epc = epc;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
