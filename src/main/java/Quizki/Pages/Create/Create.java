package Quizki.Pages.Create;

import Quizki.Models.Card;
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
    public static ArrayList<Card> arr_card = new ArrayList<Card>();
    public static Label l_card;
    public static Scene sc_create;
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            p = new Pane();

            tf_name = new TextField();
            firstOption(tf_name, 100, 10, true);

            tf_describe = new TextField();
            firstOption(tf_describe, 100, 40, true);

            tf_face_card = new TextField();
            firstOption(tf_face_card, 100, 100, true);

            tf_back_card = new TextField();
            firstOption(tf_back_card, 100, 130, true);

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
            firstOption(b_next, 200, 210, true);
            b_next.setOnAction(new Events.NextCard());
            b_next.setDisable(true);


            b_count = new Button("0");
            firstOption(b_count, 150, 210, true);

            b_prev = new Button("<");
            firstOption(b_prev, 100, 210, true);
            b_prev.setOnAction(new Events.PrevCard());
            b_prev.setDisable(true);


            l_card = new Label("");
            firstOption(l_card, 100, 260, true);

            b_back = new Button("Back");
            firstOption(b_back, 100, 500, true);
            b_back.setOnAction(new Events.BackScene());


            sc_create = new Scene(p, 500, 600);
            sc_create.getStylesheets().add("create_style.css");
            Main.temp.setScene(sc_create);
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
    }
}