package com.rentbook.entity;

public class Book {
    private String bookid;
    private String bookname;
    private String information;
    private int counts;
    private String src;

    public Book() {
    }

    public Book(String bookid, String bookname, String information, int counts, String src) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.information = information;
        this.counts = counts;
        this.src = src;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
