package Quizki.Pages.Settings;

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
            // Проверка выбора языкового набора
            String temp = Settings.languageChoiceBox.getValue();
            if(temp.equals(Variables.curLanguageList.get("Settings_LanguageRus"))){
                Variables.curLanguageList = Variables.rusList;
                Settings.curLang = Variables.curLanguageList.get("Settings_LanguageRus");

            } else if (temp.equals(Variables.curLanguageList.get("Settings_LanguageEng"))) {
                Variables.curLanguageList = Variables.engList;
                Settings.curLang = Variables.curLanguageList.get("Settings_LanguageEng");

            } else if (temp.equals(Variables.curLanguageList.get("Settings_LanguageDeu"))) {
                Variables.curLanguageList = Variables.deuList;
                Settings.curLang = Variables.curLanguageList.get("Settings_LanguageDeu");

            } else if (temp.equals(Variables.curLanguageList.get("Settings_LanguageChn"))) {
                Variables.curLanguageList = Variables.chnList;
                Settings.curLang = Variables.curLanguageList.get("Settings_LanguageChn");

            } else if (temp.equals(Variables.curLanguageList.get("Settings_LanguageCats"))) {
                Variables.curLanguageList = Variables.style_1List;
                Settings.curLang = Variables.curLanguageList.get("Settings_LanguageCats");
            } else {
                Variables.curLanguageList = Variables.style_2List;
                Settings.curLang = Variables.curLanguageList.get("Settings_Language1337");
            }
            // Обновление параметров
            Settings.languageChoiceBox.setValue(Settings.curLang);
        }
    }

    // Изменение цвета темы
    static class ChangeColor implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            /*String temp = Settings.colorChoiceBox.getValue();
            if(temp.equals(Variables.curLanguageList.get("Settings_ColorBlue"))){
                Variables.curLanguageList = Variables.rusList;
            } else if (temp.equals(Variables.curLanguageList.get("Settings_ColorYellow"))) {
                Variables.curLanguageList = Variables.engList;
            } else if (temp.equals(Variables.curLanguageList.get("Settings_ColorGreen"))) {
                Variables.curLanguageList = Variables.deuList;
            } else if (temp.equals(Variables.curLanguageList.get("Settings_ColorBlack"))) {
                Variables.curLanguageList = Variables.chnList;
            } else {
                Variables.curLanguageList = Variables.style_1List;
            }*/
            Settings.curColor = Variables.curLanguageList.get("Settings_ColorGreen");
            Settings.colorChoiceBox.setValue(Settings.curColor);
        }
    }
}
