package com.shs.nxstudy.no2_generic.commit.homework1;

public class Father extends Person{
    private String work;

    public Father(String name,String work) {
       super(name);
       this.work = work;
    }


    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
