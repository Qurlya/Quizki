package Quizki.Pages.Create;

import Quizki.Models.Card;
import Quizki.Models.Variables;
import Quizki.Pages.Main_window.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

/**
 * Реализация неполного функционала создания единичных объектов карточек.
 * На данный момент реализованы функции:
 * - Изменения полей имени, описания теста;
 * - Изменения полей запроса и ответа каждой карточки;
 * - Переключения между карточками;
 * - Сохранение карточек в JSON-файл;
 * Необходимо добавить:
 * - Улучшение читаемости интерфейса;
 */

public class Create {

    public static TextField tf_face_card, tf_back_card, tf_name, tf_describe;
    public static Button b_count, b_next, b_prev, b_create, b_add, b_del, b_back;
    public static Pane p;
    public static ArrayList<Card> arr_card = new ArrayList<>();
    public static Label l_card;
    public static Scene sc_create;
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            p = new Pane();

            Label l1 = new Label("Name");
            firstOption(l1, 0, 5, true);
            Label l2 = new Label("Description");
            firstOption(l2, 0, 35, true);
            Label l3 = new Label("Question");
            firstOption(l3, 0, 95, true);
            Label l4 = new Label("Answer");
            firstOption(l4, 0, 125, true);

            tf_name = new TextField();
            firstOption(tf_name, 125, 10, true);

            tf_describe = new TextField();
            firstOption(tf_describe, 125, 40, true);

            tf_face_card = new TextField();
            firstOption(tf_face_card, 125, 100, true);

            tf_back_card = new TextField();
            firstOption(tf_back_card, 125, 130, true);

            b_create = new Button("Create");
            firstOption(b_create, 0, 500, true);
            b_create.setOnAction(new Events.CreateCollect());


            b_add = new Button("Add");
            firstOption(b_add, 100, 160, true);
            b_add.setOnAction(new Events.AddCard());

            b_del = new Button("Delete");
            firstOption(b_del, 200, 160, true);
            b_del.setOnAction(new Events.DelCard());
            b_del.setDisable(true);

            b_next = new Button(">");
            firstOption(b_next, 215, 210, true);
            b_next.setOnAction(new Events.NextCard());
            b_next.setDisable(true);


            b_count = new Button("0");
            firstOption(b_count, 165, 210, true);

            b_prev = new Button("<");
            firstOption(b_prev, 115, 210, true);
            b_prev.setOnAction(new Events.PrevCard());
            b_prev.setDisable(true);


            l_card = new Label("");
            firstOption(l_card, 100, 260, true);

            b_back = new Button("Back");
            firstOption(b_back, 100, 500, true);
            b_back.setOnAction(new Events.BackScene());


            sc_create = new Scene(p, Variables.appWidth, Variables.appHeight);
            sc_create.getStylesheets().add("create_style.css");
            Main.temp.setScene(sc_create);
        }

        // Абстрагированные методы установки кнопок по координатам с определенной видимостью
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
    }
}