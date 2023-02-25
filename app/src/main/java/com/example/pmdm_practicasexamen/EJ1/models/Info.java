package com.example.pmdm_practicasexamen.EJ1.models;

import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("count")
    private long count;
    @SerializedName("pages")
    private long pages;
    @SerializedName("next")
    private String next;
    @SerializedName("prev")
    private String prev;

    public long getCount() { return count; }
    public void setCount(long value) { this.count = value; }

    public long getPages() { return pages; }
    public void setPages(long value) { this.pages = value; }

    public String getNext() { return next; }
    public void setNext(String value) { this.next = value; }

    public String getPrev() { return prev; }
    public void setPrev(String value) { this.prev = value; }

}
