package com.example.pmdm_practicasexamen.EJ1.models;

import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("count")
    private long count;
    @SerializedName("pages")
    private int pages;
    @SerializedName("next")
    private String next;
    @SerializedName("prev")
    private String prev;

    public long getCount() { return count; }
    public void setCount(long value) { this.count = value; }

    public int getPages() { return pages; }
    public void setPages(int value) { this.pages = value; }

    public String getNext() { return next; }
    public void setNext(String value) { this.next = value; }

    public String getPrev() { return prev; }
    public void setPrev(String value) { this.prev = value; }

}
