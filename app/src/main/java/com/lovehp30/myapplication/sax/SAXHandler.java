package com.lovehp30.myapplication.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {

    private List<Weather> weatherList;

    private Weather weather;
    private Boolean elementOn = false;

    private String str;

    public SAXHandler(){
        weatherList = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        elementOn = true;
        if(qName.equals("data")){
            weather = new Weather();
            weatherList.add(weather);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if(qName.equals("hour")){
            weather.setHour(Integer.parseInt(str));
        }else if (qName.equals("day")){
            weather.setDays(Integer.parseInt(str));
        }else if (qName.equals("temp")){
            weather.setTemp(Float.parseFloat(str));
        }else if (qName.equals("wfKor")){
            weather.setWfKor(str);
        }else if (qName.equals("pop")){
            weather.setPop(Integer.parseInt(str));
        }else if (qName.equals("reh")){
            weather.setReh(Integer.parseInt(str));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(elementOn) {
            str = new String(ch, start, length);
            elementOn=false;
        }
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }
}
