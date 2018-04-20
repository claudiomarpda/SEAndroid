package sea.com.seandroid.data.model;

import java.util.ArrayList;
import java.util.List;

public class User extends Person {

    private String id;
    private List<Knowledge> knowledgeList = new ArrayList<>();
    private List<String> frequentLocalList;

    public User() {
    }

    public List<String> getFrequentLocalList() {
        return frequentLocalList;
    }

    public void setFrequentLocalList(List<String> frequentLocalList) {
        this.frequentLocalList = frequentLocalList;
    }

    public List<Knowledge> getKnowledgeList() {
        return knowledgeList;
    }

    public void setKnowledgeList(List<Knowledge> knowledgeList) {
        this.knowledgeList = knowledgeList;
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
                ", frequentLocalList='" + frequentLocalList + '\'' +
                '}';
    }
}
