package sea.com.seandroid.data.model;

import java.util.ArrayList;
import java.util.List;

public class User extends Person {

    private String id;
    private List<Knowledge> knowledgeList = new ArrayList<>();

    public User() {}

    public User(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public User(String firstName, String lastName, String id) {
        super(firstName, lastName);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", knowledgeList=" + knowledgeList +
                '}';
    }
}
