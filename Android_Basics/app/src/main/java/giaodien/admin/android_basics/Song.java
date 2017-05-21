package giaodien.admin.android_basics;

import java.io.Serializable;

/**
 * Created by Admin on 20/05/2017.
 */

public class Song implements Serializable {
    private String ten;
    private String caSi;
    private String trangThai;
    private int image;
    private int loi;

    public Song(String ten, String caSi, String trangThai, int image,int loi) {
        this.ten = ten;
        this.caSi = caSi;
        this.trangThai = trangThai;
        this.image = image;
        this.loi = loi;
    }

    public int getLoi() {
        return loi;
    }

    public void setLoi(int loi) {
        this.loi = loi;
    }

    public Song(String ten, String caSi, String trangThai) {
        this.ten = ten;
        this.caSi = caSi;
        this.trangThai = trangThai;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCaSi() {
        return caSi;
    }

    public void setCaSi(String caSi) {
        this.caSi = caSi;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}


