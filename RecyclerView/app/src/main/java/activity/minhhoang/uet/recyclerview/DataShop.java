package activity.minhhoang.uet.recyclerview;

import android.widget.TextView;

/**
 * Created by MINHHOANG-PC on 20/05/2017.
 */

public class DataShop {
    private int imgImageItem;
    private String txtName;

    public DataShop(int imgImageItem, String txtName) {
        this.imgImageItem = imgImageItem;
        this.txtName = txtName;
    }

    public int getImgImageItem() {
        return imgImageItem;
    }

    public void setImgImageItem(int imgImageItem) {
        this.imgImageItem = imgImageItem;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }
}
