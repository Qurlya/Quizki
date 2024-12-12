package Quizki.Models;

/**
 * Карточка - ФИЗ (форма измерения знаний), основанный на однозначном соответствии запроса и единственного ответа.
 * Имеет 2 сущности:
 * - Лицевая сторона (Сущность запроса);
 * - Задняя сторона (Сущность ответа).
 * Карточка соответствует такому формату самопроверки, когда пользователь
 * должен самостоятельно однозначно ответить на вопрос, далее проверяя содержимое своего ответа
 * с ответом на задней стороне карточки.
 */

public class Card {
    private String face;
    private String back;

    //конструкторы (с параметрами и без)
    public Card(String face, String back) {
        this.face = face;
        this.back = back;
    }

    public Card() {
    }

    //геттеры и сеттеры
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

    public String toString() {
        return "{" + face + ":" + back + "}";
    }
}