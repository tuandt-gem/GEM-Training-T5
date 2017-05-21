package com.linhdt.helix.listview;

/**
 * Created by DangThanhLinh on 17/05/2017.
 */

public class ItemFace {
    int image;
    String name;

    public ItemFace(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
