package Quizki.Models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Пользователь - единичный участник системы тестирования Quizki.
 * Имеет такие данные, как:
 * - Логин;
 * - Пароль;
 * - Актуальный рейтинг в локальной системе учета активности;
 * - Информация о созданных тестах;
 * - Дата последнего входа в приложение;
 * - Дата регистрации.
 */

public class User {
    private String login;
    private String registr_date;
    private String last_enter_date;
    private int col_created;
    private int col_studied;
    private int rate;
    public String language;
    public String color;

    public User(String login) {
        this.login = login;
        this.registr_date = new SimpleDateFormat(Variables.dataFormat).format(new Date());
        this.last_enter_date = this.registr_date;
        this.col_created = 0;
        this.col_studied = 0;
        this.rate = 0;
        this.language = "eng";
        this.color = "green";
    }

    public User(){}

    public String getLast_enter_date() {
        return last_enter_date;
    }

    public void setLast_enter_date(String last_enter_date) {
        this.last_enter_date = last_enter_date;
    }

    public String getLogin() {
        return login;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRegistr_date() {
        return registr_date;
    }

    public void setRegistr_date(String registr_date) {
        this.registr_date = registr_date;
    }

    public int getCol_created() {
        return col_created;
    }

    public void setCol_created(int col_created) {
        this.col_created = col_created;
    }

    public int getCol_studied() {
        return col_studied;
    }

    public void setCol_studied(int col_studied) {
        this.col_studied = col_studied;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
