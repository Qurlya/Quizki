package Quizki.Models;

import java.util.LinkedList;
import java.util.List;

/**
 * Коллекция - совокупность единичных вопросов. Имеет имя, описание
 * соответствующие сущности, а также двусвязный список, по которому можно обращаться
 * к каждому вопросу.
 */

public class Collect{
    private String name;
    private String description;
    private List<Question> qSet;

    public Collect(String name, String description) {
        this.name = name;
        this.description = description;
        this.qSet = new LinkedList<>();
    }

    public Collect(){
        this.name = "no-name";
        this.description = "...";
        this.qSet = new LinkedList<>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getqSet() {
        return qSet;
    }

    public void setqSet(List<Question> qSet) {
        this.qSet = qSet;
    }
}
