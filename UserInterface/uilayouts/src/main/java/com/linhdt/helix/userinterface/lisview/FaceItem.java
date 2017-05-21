package com.linhdt.helix.userinterface.lisview;

/**
 * Created by DangThanhLinh on 18/05/2017.
 */

public class FaceItem {
    int image;
    String name;

    public FaceItem(int image, String name) {
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
