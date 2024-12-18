package Quizki.Pages.Create;

import Quizki.Models.Card;
import Quizki.Models.JsonHandler;
import Quizki.Models.Variables;
import Quizki.Pages.Main_window.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

import static Quizki.Pages.Repository.Repository.changeScene.firstOption;

/**
 * Реализация неполного функционала создания единичных объектов карточек.
 * На данный момент реализованы функции:
 * - Изменения полей имени, описания теста;
 * - Изменения полей запроса и ответа каждой карточки;
 * - Переключения между карточками;
 * - Сохранение карточек в JSON-файл;
 * - Удаление определенной карточки.
 */

public class Create {

    public static TextField tf_face_card, tf_back_card, tf_name, tf_describe;
    public static Button b_next, b_prev, b_create, b_add, b_del, b_back;
    public static Pane create_p;
    public static ArrayList<Card> arr_card = new ArrayList<>();
    public static Label l_card, b_count;
    public static Scene sc_create;
    public static Alert alert = new Alert(Alert.AlertType.INFORMATION);
    public static Alert alertDel = new Alert(Alert.AlertType.CONFIRMATION);


    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            create_p = new Pane();
            alert.setTitle("Quizki: Alarm");
            alertDel.setTitle("Quizki: Confirm");

            // Добавление элементов интерфейса (кнопки, текстовые поля, лейблы)
            Label l_name = new Label(Variables.curLanguageList.get("Test_Name"));
            firstOption(create_p, l_name, 0, 205, true);
            l_name.setAlignment(Pos.CENTER_RIGHT);
            Label l_desc = new Label(Variables.curLanguageList.get("Test_Description"));
            l_desc.setAlignment(Pos.CENTER_RIGHT);
            firstOption(create_p, l_desc, 0, 235, true);
            Label l_quest = new Label(Variables.curLanguageList.get("Create_Question"));
            l_quest.setAlignment(Pos.CENTER_RIGHT);
            firstOption(create_p, l_quest, 0, 295, true);
            Label l_answer = new Label(Variables.curLanguageList.get("Create_Answer"));
            l_answer.setAlignment(Pos.CENTER_RIGHT);
            firstOption(create_p, l_answer, 0, 325, true);

            tf_name = new TextField();
            firstOption(create_p, tf_name,225, 210, true);

            tf_describe = new TextField();
            firstOption(create_p, tf_describe, 225, 240, true);

            tf_face_card = new TextField();
            firstOption(create_p, tf_face_card, 225, 300, true);

            tf_back_card = new TextField();
            firstOption(create_p, tf_back_card, 225, 330, true);

            b_create = new Button(Variables.curLanguageList.get("Create_MakeNew"));
            firstOption(create_p, b_create, 830, 700, true);
            b_create.setOnAction(new Events.CreateCollect());

            b_add = new Button(Variables.curLanguageList.get("Create_AddCard"));
            firstOption(create_p, b_add, 605, 390, true);
            b_add.setOnAction(new Events.AddCard());

            b_del = new Button(Variables.curLanguageList.get("Create_DelCard"));
            firstOption(create_p, b_del, 300, 390, true);
            b_del.setOnAction(new Events.DelCard());
            b_del.setDisable(true);

            b_next = new Button(">");
            firstOption(create_p, b_next, 542, 470, true);
            b_next.setOnAction(new Events.NextCard());
            b_next.setDisable(true);

            b_count = new Label("0");
            firstOption(create_p, b_count, 478, 475, true);
            b_count.setAlignment(Pos.CENTER);
            b_count.setId("b_count");

            b_prev = new Button("<");
            firstOption(create_p, b_prev, 420, 470, true);
            b_prev.setOnAction(new Events.PrevCard());
            b_prev.setDisable(true);

            l_card = new Label("");
            firstOption(create_p, l_card, 0, 540, true);
            l_card.setAlignment(Pos.CENTER);
            l_card.setId("create_card");

            b_back = new Button(Variables.curLanguageList.get("Back"));
            firstOption(create_p, b_back, 100, 700, true);
            b_back.setOnAction(_ -> Main.temp.setScene(Main.scene));

            firstOption(create_p, Variables.copyright, 5, Variables.appHeight - 20, true);

            sc_create = new Scene(create_p, Variables.appWidth, Variables.appHeight);
            sc_create.getStylesheets().add("create_style.css");
            JsonHandler.changeColor(sc_create);
            Main.temp.setScene(sc_create);
        }
    }
}