package com.entity;

public class Page {

    private int count;    //总条数
    private int shownum;  //每页最多显示数量
    private int page;     //当前显示的页数
    private int sumpage;  //  1/10    page/sumpage

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getShownum() {
        return shownum;
    }

    public void setShownum(int shownum) {
        this.shownum = shownum;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSumpage() {
        return sumpage;
    }

    public void setSumpage(int sumpage) {
        this.sumpage = sumpage;
    }
}
