package Quizki.Pages.Create;

import Quizki.Pages.Main_window.Main;
import Quizki.Variables;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 * Реализация неполного функционала создания единичных объектов
 * тестов (форма измерения знаний, путем прохождения запросно-ответной системы)
 * и карточек (форма измерения знаний, путем самостоятельного сопоставления ответа к запросу).
 * На данный момент реализованы функции:
 * - Изменения поля имени теста;
 * - Изменения поля описания теста;
 * - Изменения поля запроса теста;
 * - Добавления и удаления полей ответов теста.
 * Необходимо реализовать функции:
 * - Внесения созданного теста в репозиторий и БД относительно к пользователю;
 * - Добавления единичных объектов системы тестирования.
 */

public class Create {
    public static ComboBox<String> langsComboBox;   // контейнер кнопок
    public static TextField tf_face_card, tf_back_card;     // сущности карточки
    public static TextField tf_name, tf_describe;   // сущности коллекции
    public static Button b_plus, b_minus;   // кнопки добавления и убавления полей ответов
    public static VBox p;
    public static ArrayList<TextField> tf_list = new ArrayList<>();     // список ответов

    public static class changeScene implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            ObservableList<String> langs = FXCollections.observableArrayList("Test", "Card");
            langsComboBox = new ComboBox<String>(langs);
            langsComboBox.setValue("Card");
            langsComboBox.setOnAction(new Events.ChangeType());

            tf_name = new TextField();
            tf_describe = new TextField();
            tf_face_card = new TextField();
            tf_back_card = new TextField();
            tf_face_card.setVisible(false);
            tf_back_card.setVisible(false);

            Button b_create = new Button("Create");
            if (langsComboBox.getValue().equals("Test")){
                b_create.setOnAction(new Events.CreateTest());
            }
            else{
                b_create.setOnAction(new Events.CreateCard());
            }

            Button b_back = new Button("Back");
            b_plus = new Button("Add new answer field");
            b_minus = new Button("Delete last answer field");
            b_plus.setOnAction(new Events.AddTf());
            b_minus.setOnAction(new Events.DelTf());

            b_back.setOnAction(new Events.BackScene());

            b_plus.setVisible(false);

            p = new VBox(tf_name, tf_describe, langsComboBox, tf_face_card, tf_back_card, b_create, b_back, b_plus, b_minus);
            Scene scene = new Scene(p, Variables.appWidth, Variables.appHeight);
            Main.temp.setScene(scene);
        }

    }
}
