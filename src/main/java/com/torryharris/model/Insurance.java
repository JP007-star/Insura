package com.torryharris.model;

public class Insurance {
    public int ins_id;
    public  String ins_name;
    public int sum;
    public String ins_type;

    public Insurance( String ins_name,int ins_id, int sum, String ins_type) {
        this.ins_id = ins_id;
        this.ins_name = ins_name;
        this.sum = sum;
        this.ins_type = ins_type;
    }

    public int getIns_id() {
        return ins_id;
    }

    public void setIns_id(int ins_id) {
        this.ins_id = ins_id;
    }

    public String getIns_name() {
        return ins_name;
    }

    public void setIns_name(String ins_name) {
        this.ins_name = ins_name;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getIns_type() {
        return ins_type;
    }

    public void setIns_type(String ins_type) {
        this.ins_type = ins_type;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "ins_id=" + ins_id +
                ", ins_name='" + ins_name + '\'' +
                ", sum=" + sum +
                ", ins_type='" + ins_type + '\'' +
                '}';
    }
}
