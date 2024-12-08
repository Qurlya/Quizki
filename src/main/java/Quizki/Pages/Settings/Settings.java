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
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Реализация функционала настроечного окна.
 * С помощью настроек каждый пользователь будет иметь доступ к
 * персональному уточнению интерфейса (язык, цвет и т.д.)
 */

public class Settings {
    public static Pane p;
    public static Button b_back;
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            p = new Pane();
            Scene scene = new Scene(p, Variables.appWidth, Variables.appHeight);


            Label l_choiceLang = new Label("Выберите язык:");
            firstOption(l_choiceLang, 0, 50, true);
            Label l_choiceColor = new Label("Выберите цвет: ");
            firstOption(l_choiceColor, 0, 100, true);

            ObservableList<String> langs = FXCollections.observableArrayList("Синий", "Жетлый", "Черный", "Белый");
            ChoiceBox<String> langsChoiceBox = new ChoiceBox<String>(langs);
            langsChoiceBox.setValue("Зеленый");
            firstOption(langsChoiceBox, 100, 100, true);

            ObservableList<String> lang = FXCollections.observableArrayList("Русский", "Английский", "Татарский", "Японский");
            ChoiceBox<String> langChoiceBox = new ChoiceBox<String>(lang);
            langChoiceBox.setValue("Русский");
            firstOption(langChoiceBox, 100, 50, true);















            b_back = new Button("Назад");
            firstOption(b_back, 0, 500, true);
            b_back.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Main.temp.setScene(Main.scene);
                }

            });
            scene.getStylesheets().add("settings_style.css");
            Main.temp.setScene(scene);
        }
        private void firstOption(Button temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            p.getChildren().add(temp);
        }
        private void firstOption(TextField temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            p.getChildren().add(temp);
        }
        private void firstOption(Label temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            p.getChildren().add(temp);
        }
        private void firstOption(ChoiceBox temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            p.getChildren().add(temp);
        }
    }
}
