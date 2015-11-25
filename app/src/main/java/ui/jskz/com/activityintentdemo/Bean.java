package ui.jskz.com.activityintentdemo;

import java.io.Serializable;

/**
 * Created by Ivor on 2015/11/25.
 */
public class Bean implements Serializable {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
