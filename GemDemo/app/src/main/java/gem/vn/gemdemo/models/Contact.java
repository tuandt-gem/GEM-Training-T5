package gem.vn.gemdemo.models;

import java.util.ArrayList;

/**
 * Created by Lush on 5/15/2017.
 */

public class Contact {

    public static ArrayList<Contact> CONTACTS = new ArrayList<>();

    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

}
