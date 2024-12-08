package Quizki.Pages.Settings;

import Quizki.Pages.Main_window.Main;
import Quizki.Models.Variables;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import static Quizki.Pages.Repository.Repository.changeScene.firstOption;

/**
 * Реализация функционала настроечного окна.
 * С помощью настроек каждый пользователь будет иметь доступ к
 * персональному уточнению интерфейса (пока что - язык и цвет).
 */

public class Settings {
    public static Pane settings_p;
    public static Button b_back;
    public static ChoiceBox<String> languageChoiceBox, colorChoiceBox;
    public static String curColor = Variables.curLanguageList.get("Settings_ColorGreen");
    public static String curLang = Variables.curLanguageList.get("Settings_LanguageEng");
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            settings_p = new Pane();
            Scene scene = new Scene(settings_p, Variables.appWidth, Variables.appHeight);

            Label l_choiceLang = new Label(Variables.curLanguageList.get("Settings_Language") + ": ");
            firstOption(settings_p, l_choiceLang, 0, 50, true);
            Label l_choiceColor = new Label(Variables.curLanguageList.get("Settings_Color") + ": ");
            firstOption(settings_p, l_choiceColor, 0, 100, true);

            // Контейнер цветовых наборов
            ObservableList<String> colorLang = FXCollections.observableArrayList(
                    Variables.curLanguageList.get("Settings_ColorBlue"),
                    Variables.curLanguageList.get("Settings_ColorYellow"),
                    Variables.curLanguageList.get("Settings_ColorGreen"),
                    Variables.curLanguageList.get("Settings_ColorBlack"),
                    Variables.curLanguageList.get("Settings_ColorWhite"));

            colorChoiceBox = new ChoiceBox<>(colorLang);
            colorChoiceBox.setValue(curColor);
            firstOption(settings_p, colorChoiceBox, 100, 100, true);
            colorChoiceBox.setOnAction(new Events.ChangeColor());

            // Контейнер языковых наборов
            ObservableList<String> languageLang = FXCollections.observableArrayList(
                    Variables.curLanguageList.get("Settings_LanguageEng"),
                    Variables.curLanguageList.get("Settings_LanguageRus"),
                    Variables.curLanguageList.get("Settings_LanguageDeu"),
                    Variables.curLanguageList.get("Settings_LanguageChn"),
                    Variables.curLanguageList.get("Settings_Language1337"),
                    Variables.curLanguageList.get("Settings_LanguageCats"));

            languageChoiceBox = new ChoiceBox<>(languageLang);
            languageChoiceBox.setValue(curLang);
            firstOption(settings_p, languageChoiceBox, 100, 50, true);
            languageChoiceBox.setOnAction(new Events.ChangeLanguage());

            b_back = new Button(Variables.curLanguageList.get("Back"));
            firstOption(settings_p, b_back, 0, 500, true);
            b_back.setOnAction(_ -> Main.temp.setScene(Main.scene));
            scene.getStylesheets().add("settings_style.css");
            Main.temp.setScene(scene);
        }
    }
}