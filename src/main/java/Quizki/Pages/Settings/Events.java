package Quizki.Pages.Settings;

import Quizki.Models.JsonHandler;
import Quizki.Models.User;
import Quizki.Models.Variables;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Реализация класса обработки событий установления
 * специальных настроек интерфейса программы (см. Settings).
 */

public class Events {

    //Изменение языкового набора
    static class ChangeLanguage implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            User user1 = JsonHandler.loadAccountData();

            // Проверка выбора языкового набора
            String temp = Settings.languageChoiceBox.getValue();

            if(temp.equals(Variables.curLanguageList.get("Settings_LanguageRus"))){
                Variables.curLanguageList = Variables.rusList;
                Settings.curLang = Variables.curLanguageList.get("Settings_LanguageRus");
                user1.setLanguage("rus");

            } else if (temp.equals(Variables.curLanguageList.get("Settings_LanguageEng"))) {
                Variables.curLanguageList = Variables.engList;
                Settings.curLang = Variables.curLanguageList.get("Settings_LanguageEng");
                user1.setLanguage("eng");

            } else if (temp.equals(Variables.curLanguageList.get("Settings_LanguageDeu"))) {
                Variables.curLanguageList = Variables.deuList;
                Settings.curLang = Variables.curLanguageList.get("Settings_LanguageDeu");
                user1.setLanguage("deu");

            } else if (temp.equals(Variables.curLanguageList.get("Settings_LanguageChn"))) {
                Variables.curLanguageList = Variables.chnList;
                Settings.curLang = Variables.curLanguageList.get("Settings_LanguageChn");
                user1.setLanguage("chn");

            } else if (temp.equals(Variables.curLanguageList.get("Settings_LanguageCats"))) {
                Variables.curLanguageList = Variables.style_1List;
                Settings.curLang = Variables.curLanguageList.get("Settings_LanguageCats");
                user1.setLanguage("cat");

            } else {
                Variables.curLanguageList = Variables.style_2List;
                Settings.curLang = Variables.curLanguageList.get("Settings_Language1337");
                user1.setLanguage("1337");
            }
            // Обновление параметров
            Settings.languageChoiceBox.setValue(Settings.curLang);
        }
    }

    // Изменение цвета темы
    static class ChangeColor implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            User user1 = JsonHandler.loadAccountData();

            // Проверка выбора цветовой темы
            String temp = Settings.colorChoiceBox.getValue();
            if(temp.equals(Variables.curLanguageList.get("Settings_ColorBlue"))){
                Settings.curColor = Variables.curLanguageList.get("Settings_ColorBlue");
                user1.setColor("blue");

            } else if (temp.equals(Variables.curLanguageList.get("Settings_ColorYellow"))) {
                Settings.curColor = Variables.curLanguageList.get("Settings_ColorYellow");
                user1.setColor("yellow");

            } else if (temp.equals(Variables.curLanguageList.get("Settings_ColorBlack"))) {
                Settings.curColor = Variables.curLanguageList.get("Settings_ColorBlack");
                user1.setColor("black");

            }else if (temp.equals(Variables.curLanguageList.get("Settings_ColorGreen"))) {
                Settings.curColor = Variables.curLanguageList.get("Settings_ColorGreen");
                user1.setColor("green");

            } else {
                Settings.curColor = Variables.curLanguageList.get("Settings_ColorWhite");
                user1.setColor("white");
            }
            // Обновление параметров
            Settings.colorChoiceBox.setValue(Settings.curColor);
        }
    }

    // Сохранить выбранные настройки
    public static class ApplySettings implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            User user1 = JsonHandler.loadAccountData();

            // Проверка выбора языкового набора
            String temp = Settings.languageChoiceBox.getValue();

            if(temp.equals(Variables.curLanguageList.get("Settings_LanguageRus"))){
                Variables.curLanguageList = Variables.rusList;
                Settings.curLang = Variables.curLanguageList.get("Settings_LanguageRus");
                user1.setLanguage("rus");

            } else if (temp.equals(Variables.curLanguageList.get("Settings_LanguageEng"))) {
                Variables.curLanguageList = Variables.engList;
                Settings.curLang = Variables.curLanguageList.get("Settings_LanguageEng");
                user1.setLanguage("eng");

            } else if (temp.equals(Variables.curLanguageList.get("Settings_LanguageDeu"))) {
                Variables.curLanguageList = Variables.deuList;
                Settings.curLang = Variables.curLanguageList.get("Settings_LanguageDeu");
                user1.setLanguage("deu");

            } else if (temp.equals(Variables.curLanguageList.get("Settings_LanguageChn"))) {
                Variables.curLanguageList = Variables.chnList;
                Settings.curLang = Variables.curLanguageList.get("Settings_LanguageChn");
                user1.setLanguage("chn");

            } else if (temp.equals(Variables.curLanguageList.get("Settings_LanguageCats"))) {
                Variables.curLanguageList = Variables.style_1List;
                Settings.curLang = Variables.curLanguageList.get("Settings_LanguageCats");
                user1.setLanguage("cat");

            } else {
                Variables.curLanguageList = Variables.style_2List;
                Settings.curLang = Variables.curLanguageList.get("Settings_Language1337");
                user1.setLanguage("1337");
            }

            temp = Settings.colorChoiceBox.getValue();

            if(temp.equals(Variables.curLanguageList.get("Settings_ColorBlue"))){
                Settings.curColor = Variables.curLanguageList.get("Settings_ColorBlue");
                user1.setColor("blue");

            } else if (temp.equals(Variables.curLanguageList.get("Settings_ColorYellow"))) {
                Settings.curColor = Variables.curLanguageList.get("Settings_ColorYellow");
                user1.setColor("yellow");

            } else if (temp.equals(Variables.curLanguageList.get("Settings_ColorBlack"))) {
                Settings.curColor = Variables.curLanguageList.get("Settings_ColorBlack");
                user1.setColor("black");

            }else if (temp.equals(Variables.curLanguageList.get("Settings_ColorGreen"))) {
                Settings.curColor = Variables.curLanguageList.get("Settings_ColorGreen");
                user1.setColor("green");

            } else {
                Settings.curColor = Variables.curLanguageList.get("Settings_ColorWhite");
                user1.setColor("white");
            }

            // Обновление параметров
            Settings.languageChoiceBox.setValue(Settings.curLang);
            Settings.colorChoiceBox.setValue(Settings.curColor);
            JsonHandler.createAccount(user1);
        }
    }
}
