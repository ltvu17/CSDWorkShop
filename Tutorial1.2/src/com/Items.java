package com;
public class Items {
    String code ="", name="";
    int price=0, guaranty=0;
    public Items(){
        
    }
    public Items(String code, String name, int price, int guaranty){
        this.code = code; this.name = name; this.price = price; this.guaranty = guaranty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGuaranty() {
        return guaranty;
    }

    public void setGuaranty(int guaranty) {
        this.guaranty = guaranty;
    }
    public String toString(){
        return code + "\t" + name + "\t" + price + "\t" + guaranty;
    }
    
    
    
}
