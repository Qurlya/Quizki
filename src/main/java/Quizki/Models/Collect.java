package Quizki.Models;

import java.util.ArrayList;

/**
 * Коллекция - совокупность тестов (карточек). Имеет имя, описание
 * соответствующие сущности, а также список, по которому можно обращаться
 * к каждой карточке.
 */

public class Collect {
    private String name;
    private String description;
    private ArrayList<Card> card_set;

    public Collect(String name, String description){
        this.name = name;
        this.description = description;
        this.card_set = new ArrayList<>();
    }

    public Collect(){
        this.name = "no-name";
        this.description = "...";
        this.card_set = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Card> getCard_set() {
        return card_set;
    }

    public void setCard_set(ArrayList<Card> card_set) {
        this.card_set = card_set;
    }
}
