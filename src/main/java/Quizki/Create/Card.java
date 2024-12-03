package Quizki.Create;

public class Card{
    private String face;
    private String back;
    private String name;
    private String description;
    Card(String name, String description, String face, String back){
        this.face = face;
        this.back = back;
        this.name = name;
        this.description = description;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
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
}
