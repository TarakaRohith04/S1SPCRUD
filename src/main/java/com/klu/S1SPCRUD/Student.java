package com.klu.S1SPCRUD;

public class Student{
    int sid;
    String sname;

    public void setSid(int sid){
    	this.sid = sid;
    }

    public void setSname(String sname){
    	this.sname = sname;
    }

    public int getSid() {
    	return sid;
    }

    public String getSname() {
    	return sname;
    }
    public void display(){
    	System.out.println(sid + " " + sname);
    }
}
