package model;


import Utils.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * Created by donezio on 1/26/19.
 */
public class Wallpaper {

    Set<String> tages;

    Map<String, String> properties;

    String height;

    String width;

    String alt;

    String id;

    String url;

    public Wallpaper(String height, String width, String alt, String id, String url) {
        this.height = height;
        this.width = width;
        this.alt = alt;
        this.id = id;
        this.url = url;

        tages = new HashSet<String>();

        properties = new HashMap<String, String>();

    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void addTag(String str) {
        tages.add(str);
    }


    public Map<String, String> getProperties() {
        return properties;
    }


    public void addProperty(String key, String val) {
        properties.put(key, val);
    }


    public void printWallpaper() {


        System.out.println("Tags");
        this.tages.forEach(e -> {
            System.out.print(e);
            System.out.print(" ");
        } );
        System.out.println();
        System.out.println();
        System.out.println("Properties");
        utils.printHashMap(this.properties);
    }
}
