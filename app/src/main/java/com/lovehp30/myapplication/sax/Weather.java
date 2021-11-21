package com.lovehp30.myapplication.sax;

import java.io.Serializable;

public class Weather implements Serializable {
    private int hour;
    private int days;
    private float temp;//온도
    private String wfKor;
    private int pop;//강수확률
    private int reh;//습도

    public void setDays(int days) {
        this.days = days;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public void setReh(int reh) {
        this.reh = reh;
    }

    public void setWfKor(String wfKor) {
        this.wfKor = wfKor;
    }
    public int getDays() {
        return days;
    }
    public int getHour() {
        return hour;
    }
    public int getPop() {
        return pop;
    }
    public int getReh() {
        return reh;
    }

    public float getTemp() {
        return temp;
    }

    public String getWfKor() {
        return wfKor;
    }
    public String getAll(){
        return days+" "+hour+" "+temp+" "+pop+" "+reh+" "+wfKor;
    }
}
