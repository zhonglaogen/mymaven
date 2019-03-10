package com.rentbook.entity;

public class Record {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String userid;
    private String bookid;
    private String rentid;

    public Record() {
    }

    public Record(int id, String userid, String bookid, String rentid) {
        this.id=id;
        this.userid = userid;
        this.bookid = bookid;
        this.rentid = rentid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getRentid() {
        return rentid;
    }

    public void setRentid(String rentid) {
        this.rentid = rentid;
    }
}
