package Entity;

import java.io.Serializable;

/**
 * @author y1881
 * @date 2020.3.28 9:47
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 3L;
    private String ID;
    private String name;
    private int age;
    private String school;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
