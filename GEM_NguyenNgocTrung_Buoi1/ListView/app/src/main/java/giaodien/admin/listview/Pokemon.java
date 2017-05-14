package giaodien.admin.listview;

/**
 * Created by Admin on 31/03/2017.
 */

public class Pokemon {
    public String id;
    public String name;
    public String gen;

    public Pokemon(String id, String name, String gen) {
        this.id = id;
        this.name = name;
        this.gen = gen;
    }

    public Pokemon() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }
    @Override
    public String toString() {
        return this.id+"-"+this.name;
    }
}
