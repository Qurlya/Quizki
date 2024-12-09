package Quizki.Pages.Settings;

import Quizki.Models.JsonHandler;
import Quizki.Models.User;
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
    public static Button b_back, b_apply;
    public static ChoiceBox<String> languageChoiceBox, colorChoiceBox;
    public static User user1 = JsonHandler.loadAccountData();
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

            if(Main.userExist){
                String color = JsonHandler.loadAccountData().getColor();

                switch (color) {
                    case "white" -> curColor = Variables.curLanguageList.get("Settings_ColorWhite");
                    case "blue" -> curColor = Variables.curLanguageList.get("Settings_ColorBlue");
                    case "yellow" -> curColor = Variables.curLanguageList.get("Settings_ColorYellow");
                    case "black" -> curColor = Variables.curLanguageList.get("Settings_ColorBlack");
                    default -> curColor = Variables.curLanguageList.get("Settings_ColorGreen");
                }
            }else{
                Variables.curLanguageList = Variables.engList;  // цвет по умолчанию - зелёный
            }

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

            if(Main.userExist){
                String language = JsonHandler.loadAccountData().getLanguage();

                switch (language) {
                    case "rus" -> curLang = Variables.curLanguageList.get("Settings_LanguageRus");
                    case "1337" -> curLang = Variables.curLanguageList.get("Settings_Language1337");
                    case "deu" -> curLang = Variables.curLanguageList.get("Settings_LanguageDeu");
                    case "chn" -> curLang = Variables.curLanguageList.get("Settings_LanguageChn");
                    case "cat" -> curLang = Variables.curLanguageList.get("Settings_LanguageCats");
                    default -> curLang = Variables.curLanguageList.get("Settings_LanguageEng");
                }
            }else{
                Variables.curLanguageList = Variables.engList;  // язык по умолчанию - английский
            }

            languageChoiceBox = new ChoiceBox<>(languageLang);
            languageChoiceBox.setValue(curLang);
            firstOption(settings_p, languageChoiceBox, 100, 50, true);
            languageChoiceBox.setOnAction(new Events.ChangeLanguage());

            b_back = new Button(Variables.curLanguageList.get("Back"));
            firstOption(settings_p, b_back, 0, 500, true);
            b_back.setOnAction(_ -> {
                Main.printScene();
                Main.temp.setScene(Main.scene);
            });

            b_apply = new Button(Variables.curLanguageList.get("Settings_Apply"));
            firstOption(settings_p, b_apply, 200, 500, true);
            b_apply.setOnAction(new Events.ApplySettings());
            firstOption(settings_p, Variables.copyright, 0, Variables.appHeight - 20, true);

            scene.getStylesheets().add("settings_style.css");
            Main.temp.setScene(scene);
        }
    }
}