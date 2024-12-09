package Quizki.Pages.Settings;

import Quizki.Models.JsonHandler;
import Quizki.Models.Variables;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import static Quizki.Models.Variables.curLanguageList;

/**
 * Реализация класса обработки событий установления
 * специальных настроек интерфейса программы (см. Settings).
 */

public class Events {

    //Изменение языкового набора
    static class ChangeLanguage implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            // Проверка выбора языкового набора
            String temp = Settings.languageChoiceBox.getValue();

            if(temp.equals(curLanguageList.get("Settings_LanguageRus"))){
                curLanguageList = Variables.rusList;
                Settings.curLang = curLanguageList.get("Settings_LanguageRus");
                Settings.user1.setLanguage("rus");

            } else if (temp.equals(curLanguageList.get("Settings_LanguageEng"))) {
                curLanguageList = Variables.engList;
                Settings.curLang = curLanguageList.get("Settings_LanguageEng");
                Settings.user1.setLanguage("eng");

            } else if (temp.equals(curLanguageList.get("Settings_LanguageDeu"))) {
                curLanguageList = Variables.deuList;
                Settings.curLang = curLanguageList.get("Settings_LanguageDeu");
                Settings.user1.setLanguage("deu");

            } else if (temp.equals(curLanguageList.get("Settings_LanguageChn"))) {
                curLanguageList = Variables.chnList;
                Settings.curLang = curLanguageList.get("Settings_LanguageChn");
                Settings.user1.setLanguage("chn");

            } else if (temp.equals(curLanguageList.get("Settings_LanguageCats"))) {
                curLanguageList = Variables.style_1List;
                Settings.curLang = curLanguageList.get("Settings_LanguageCats");
                Settings.user1.setLanguage("cat");

            } else {
                curLanguageList = Variables.style_2List;
                Settings.curLang = curLanguageList.get("Settings_Language1337");
                Settings.user1.setLanguage("1337");
            }
            // Обновление параметров
            Settings.languageChoiceBox.setValue(Settings.curLang);
        }
    }

    // Изменение цвета темы
    static class ChangeColor implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            // Проверка выбора цветовой темы
            String temp = Settings.colorChoiceBox.getValue();

            if(temp.equals(curLanguageList.get("Settings_ColorBlue"))){
                Settings.curColor = curLanguageList.get("Settings_ColorBlue");

            } else if (temp.equals(curLanguageList.get("Settings_ColorYellow"))) {
                Settings.curColor = curLanguageList.get("Settings_ColorYellow");

            } else if (temp.equals(curLanguageList.get("Settings_ColorBlack"))) {
                Settings.curColor = curLanguageList.get("Settings_ColorBlack");

            }else if (temp.equals(curLanguageList.get("Settings_ColorGreen"))) {
                Settings.curColor = curLanguageList.get("Settings_ColorGreen");

            } else {
                Settings.curColor = curLanguageList.get("Settings_ColorWhite");
            }
            // Обновление параметров
            Settings.colorChoiceBox.setValue(Settings.curColor);
        }
    }

    // Сохранить выбранные настройки
    public static class ApplySettings implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            // Проверка выбора языкового набора
            String temp = Settings.languageChoiceBox.getValue();

            if(temp.equals(curLanguageList.get("Settings_LanguageRus"))){
                temp = "rus";
            } else if (temp.equals(curLanguageList.get("Settings_LanguageEng"))) {
                temp = "eng";
            } else if (temp.equals(curLanguageList.get("Settings_LanguageDeu"))) {
                temp = "deu";
            } else if (temp.equals(curLanguageList.get("Settings_LanguageChn"))) {
                temp = "chn";
            } else if (temp.equals(curLanguageList.get("Settings_LanguageCats"))) {
                temp = "cat";
            } else {
                temp = "1337";
            }
            JsonHandler.changeLanguage(temp);

            temp = Settings.colorChoiceBox.getValue();

            if(temp.equals(curLanguageList.get("Settings_ColorBlue"))){
                temp = "blue";
            } else if (temp.equals(curLanguageList.get("Settings_ColorYellow"))) {
                temp = "yellow";
            } else if (temp.equals(curLanguageList.get("Settings_ColorBlack"))) {
                temp = "black";
            }else if (temp.equals(curLanguageList.get("Settings_ColorGreen"))) {
                temp = "green";
            } else {
                temp = "white";
            }

            JsonHandler.changeColor(Settings.settings_p, temp);

            // Обновление параметров
            Settings.languageChoiceBox.setValue(Settings.curLang);
            Settings.colorChoiceBox.setValue(Settings.curColor);
            //JsonHandler.createAccount(Settings.user1);

            new Settings.changeScene();
        }
    }
}
