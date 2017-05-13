package com.luongapp.vanluong.androidbasic.model.obj;

/**
 * Created by vanluong on 13/05/2017.
 */

public class DemoRecy {
   private String name;
    private int idImage;

    public DemoRecy(String name, int idImage) {
        this.name = name;
        this.idImage = idImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }
}
