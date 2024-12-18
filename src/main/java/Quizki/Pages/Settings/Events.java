package Quizki.Pages.Settings;

import Quizki.Models.JsonHandler;
import Quizki.Pages.Main_window.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import static Quizki.Models.Variables.*;

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

            switch (temp) {
                case "Русский" -> {
                    curLanguageList = rusList;
                    Settings.curLang = "Русский";
                }
                case "English" -> {
                    curLanguageList = engList;
                    Settings.curLang = "English";
                }
                case "Deutsch" -> {
                    curLanguageList = deuList;
                    Settings.curLang = "Deutsch";
                }
                case "中文" -> {
                    curLanguageList = chnList;
                    Settings.curLang = "中文";
                }
                case "q(≧▽≦q)" -> {
                    curLanguageList = style_1List;
                    Settings.curLang = "q(≧▽≦q)";
                }
                default -> {
                    curLanguageList = style_2List;
                    Settings.curLang = "1337";
                }
            }
            // Обновление параметров
            Settings.languageChoiceBox.setValue(Settings.curLang);

            Main.temp.setScene(Settings.scene);
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

            switch (temp) {
                case "Русский" -> {
                    temp = "rus";
                    curLanguageList = rusList;
                    Settings.curLang = "Русский";
                }
                case "English" -> {
                    temp = "eng";
                    curLanguageList = engList;
                    Settings.curLang = "English";
                }
                case "Deutsch" -> {
                    temp = "deu";
                    curLanguageList = deuList;
                    Settings.curLang = "Deutsch";
                }
                case "中文" -> {
                    temp = "chn";
                    curLanguageList = chnList;
                    Settings.curLang = "中文";
                }
                case "q(≧▽≦q)" -> {
                    temp = "cat";
                    curLanguageList = style_1List;
                    Settings.curLang = "q(≧▽≦q)";
                }
                default -> {
                    temp = "1337";
                    curLanguageList = style_2List;
                    Settings.curLang = "1337";
                }
            }

            JsonHandler.changeLanguage(temp);

            temp = Settings.colorChoiceBox.getValue();

            if(temp.equals(curLanguageList.get("Settings_ColorBlue"))){
                temp = "blue";
            } else if (temp.equals(curLanguageList.get("Settings_ColorYellow"))) {
                temp = "yellow";
            } else if (temp.equals(curLanguageList.get("Settings_ColorBlack"))) {
                temp = "black";
            } else if (temp.equals(curLanguageList.get("Settings_ColorGreen"))) {
                temp = "green";
            } else {
                temp = "white";
            }
            JsonHandler.changeColor(Settings.scene, temp);

            // Обновление параметров
            Settings.languageChoiceBox.setValue(Settings.curLang);
            Settings.colorChoiceBox.setValue(Settings.curColor);
        }
    }
}
