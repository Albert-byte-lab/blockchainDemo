package com.loongrise.entity;

/**
 * RFID实体类
 */
public class RFID {
    private long rfidId;
    private String epc;
    private String tid;

    public long getRfidId() {
        return rfidId;
    }

    public void setRfidId(long rfidId) {
        this.rfidId = rfidId;
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
}
