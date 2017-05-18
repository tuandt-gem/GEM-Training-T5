package gem.vn.uitask.models;

/**
 * Created by Lush on 5/17/2017.
 */

public class Fruit {

    public static final Fruit[] FRUITS = new Fruit[] {
            new Fruit("Apple", "3000 VND", "https://www.thesun.co.uk/wp-content/uploads/2017/01/gettyimages-185071735.jpg?strip=all&w=960"),
            new Fruit("Mango", "5000 VND", "http://skds3.vcmedia.vn/2015/xoai-1432222000580.jpg"),
            new Fruit("Orange", "2000 VND", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTEYnFIEnzxcRM3BR3TFbSCPWNUbu5mHTTxliFtcwwqZjBGGArr"),
            new Fruit("Kiwi", "7000 VND", "http://thuyanhfruits.com/uploads/1/tac-dung-tuyet-voi-cua-kiwi-1.jpg"),
            new Fruit("Banana", "2000 VND", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR8i8SiqT3_BcWB7E3p4frgOmWYvpKNYdlCCoBcqFXWwqYwl5w2hA"),
            new Fruit("Pineapple", "6000 VND", "http://freenology.com/images/71442946288pineapple.jpg"),
            new Fruit("Lime", "1000 VND", "http://www.medicalnewstoday.com/content/images/articles/304/304448/limes.jpg")
    };

    private String name;
    private String cost;
    private String imgURL;

    public Fruit(String name, String cost, String imgURL) {
        this.name = name;
        this.cost = cost;
        this.imgURL = imgURL;
    }

    public String getName() {
        return name;
    }

    public String getCost() {
        return cost;
    }

    public String getImgURL() {
        return imgURL;
    }

}
