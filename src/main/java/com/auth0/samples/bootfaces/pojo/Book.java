package com.auth0.samples.bootfaces.pojo;

import java.sql.Timestamp;

public class Book {

    private int id;
    private String name;
    private float price;
    private int sum;
    private String autor;
    private String info;
    private String verlag;
    private String sort;
    private  int url;
    //private Timestamp update_time;

    private int wg_id;
    private String wg_name;
    private int wg_amount;
    private Timestamp wg_update_time;


   /*public Book(Integer id, String name, float price, Integer sum, String autor, String info, String verlag, Timestamp update_time){
        this.id=id;
        this.name=name;
        this.price=price;
        this.sum=sum;
        this.autor=autor;
        this.info=info;
        this.verlag=verlag;
        this.update_time=update_time;
    }*/


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWG_Id() {
        return wg_id;
    }
    public void setWG_Id(int WG_id) {
        this.wg_id = WG_id;
    }
    public String getWG_Name() {
        return wg_name;
    }
    public void setWG_Name(String WG_name) {
        this.wg_name = WG_name;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getSum() {
        return sum;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public String getVerlag() {
        return verlag;
    }
    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }
    public String getSort() {
        return sort;
    }
    public void setSort(String Sort) {
        this.sort = Sort;
    }
    public int getWG_Amount() {
        return wg_amount;
    }
    public void setWG_Amount(int WG_amount) {
        this.wg_amount = WG_amount;
    }
    public Timestamp getWG_update_time() {
        return wg_update_time;
    }
    public void setWG_update_time(Timestamp WG_update_time) {
        this.wg_update_time = WG_update_time;
    }

    public int getUrl() {
        return url;
    }
    public void setUrl(int url) {
        this.url = url;
    }
}
