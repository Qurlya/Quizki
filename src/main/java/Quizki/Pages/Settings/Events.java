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

            if(temp.equals(curLanguageList.get("Settings_LanguageRus"))){
                curLanguageList = rusList;
                Settings.curLang = curLanguageList.get("Settings_LanguageRus");

            } else if (temp.equals(curLanguageList.get("Settings_LanguageEng"))) {
                curLanguageList = engList;
                Settings.curLang = curLanguageList.get("Settings_LanguageEng");

            } else if (temp.equals(curLanguageList.get("Settings_LanguageDeu"))) {
                curLanguageList = deuList;
                Settings.curLang = curLanguageList.get("Settings_LanguageDeu");

            } else if (temp.equals(curLanguageList.get("Settings_LanguageChn"))) {
                curLanguageList = chnList;
                Settings.curLang = curLanguageList.get("Settings_LanguageChn");

            } else if (temp.equals(curLanguageList.get("Settings_LanguageCats"))) {
                curLanguageList = style_1List;
                Settings.curLang = curLanguageList.get("Settings_LanguageCats");

            } else {
                curLanguageList = style_2List;
                Settings.curLang = curLanguageList.get("Settings_Language1337");
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

            if(temp.equals(curLanguageList.get("Settings_LanguageRus"))){
                temp = "rus";
                curLanguageList = rusList;
                Settings.curLang = curLanguageList.get("Settings_LanguageRus");

            } else if (temp.equals(curLanguageList.get("Settings_LanguageEng"))) {
                temp = "eng";
                curLanguageList = engList;
                Settings.curLang = curLanguageList.get("Settings_LanguageEng");

            } else if (temp.equals(curLanguageList.get("Settings_LanguageDeu"))) {
                temp = "deu";
                curLanguageList = deuList;
                Settings.curLang = curLanguageList.get("Settings_LanguageDeu");

            } else if (temp.equals(curLanguageList.get("Settings_LanguageChn"))) {
                temp = "chn";
                curLanguageList = chnList;
                Settings.curLang = curLanguageList.get("Settings_LanguageChn");

            } else if (temp.equals(curLanguageList.get("Settings_LanguageCats"))) {
                temp = "cat";
                curLanguageList = style_1List;
                Settings.curLang = curLanguageList.get("Settings_LanguageCats");

            } else {
                temp = "1337";
                curLanguageList = style_2List;
                Settings.curLang = curLanguageList.get("Settings_Language1337");
            }
            JsonHandler.changeLanguage(temp);

            /*ObservableList<String> tempColorLang = FXCollections.observableArrayList(
                    Variables.curLanguageList.get("Settings_ColorBlue"),
                    Variables.curLanguageList.get("Settings_ColorYellow"),
                    Variables.curLanguageList.get("Settings_ColorGreen"),
                    Variables.curLanguageList.get("Settings_ColorBlack"),
                    Variables.curLanguageList.get("Settings_ColorWhite"));
            Settings.colorChoiceBox = new ChoiceBox<>(tempColorLang);
            Settings.colorChoiceBox.setValue(Settings.curColor);*/

            temp = Settings.colorChoiceBox.getValue();
            System.out.println(temp);

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
