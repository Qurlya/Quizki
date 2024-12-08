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
    public static Button b_next, b_prev, b_create, b_add, b_del, b_back;
    public static Pane p;
    public static ArrayList<Card> arr_card = new ArrayList<>();
    public static Label l_card, b_count;
    public static Scene sc_create;
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            p = new Pane();

            Label l1 = new Label("Коллекция");
            firstOption(l1, 100, 205, true);
            Label l2 = new Label("Описание");
            firstOption(l2, 107, 235, true);
            Label l3 = new Label("Вопрос");
            firstOption(l3, 138, 295, true);
            Label l4 = new Label("Ответ");
            firstOption(l4, 155, 325, true);

            tf_name = new TextField();
            firstOption(tf_name, 225, 210, true);

            tf_describe = new TextField();
            firstOption(tf_describe, 225, 240, true);

            tf_face_card = new TextField();
            firstOption(tf_face_card, 225, 300, true);

            tf_back_card = new TextField();
            firstOption(tf_back_card, 225, 330, true);

            b_create = new Button("Создать");
            firstOption(b_create, 830, 700, true);
            b_create.setOnAction(new Events.CreateCollect());
            b_create.setId("b_create");


            b_add = new Button("Добавить");
            firstOption(b_add, 605, 390, true);
            b_add.setOnAction(new Events.AddCard());

            b_del = new Button("Удалить");
            firstOption(b_del, 300, 390, true);
            b_del.setOnAction(new Events.DelCard());
            b_del.setDisable(true);

            b_next = new Button(">");
            firstOption(b_next, 542, 470, true);
            b_next.setOnAction(new Events.NextCard());
            b_next.setDisable(true);


            b_count = new Label("0");
            firstOption(b_count, 497, 475, true);
            b_count.setId("b_count");

            b_prev = new Button("<");
            firstOption(b_prev, 420, 470, true);
            b_prev.setOnAction(new Events.PrevCard());
            b_prev.setDisable(true);


            l_card = new Label("");
            firstOption(l_card, 437, 460, true);

            b_back = new Button("\uD83C\uDFE0\uD83D\uDC08");
            firstOption(b_back, 100, 700, true);
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