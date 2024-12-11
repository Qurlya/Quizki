package Quizki.Pages.Create;

import Quizki.Models.Card;
import Quizki.Models.JsonHandler;
import Quizki.Models.Variables;
import Quizki.Pages.Main_window.Main;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

import static Quizki.Pages.Repository.Repository.changeScene.firstOption;

/**
 * Реализация неполного функционала создания единичных объектов карточек.
 * На данный момент реализованы функции:
 * - Изменения полей имени, описания теста;
 * - Изменения полей запроса и ответа каждой карточки;
 * - Переключения между карточками;
 * - Сохранение карточек в JSON-файл;
 */

public class Create {

    public static TextField tf_face_card, tf_back_card, tf_name, tf_describe;
    public static Button b_next, b_prev, b_create, b_add, b_del, b_back;
    public static Pane create_p;
    public static ArrayList<Card> arr_card = new ArrayList<>();
    public static Label l_card, b_count;
    public static Scene sc_create;
    public static Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            create_p = new Pane();
            alert.setTitle("Quizki Alarm");


            // Добавление элементов интерфейса (кнопки, текстовые поля, лейблы)
            Label l_name = new Label(Variables.curLanguageList.get("Test_Name"));
            firstOption(create_p, l_name, 100, 205, true);
            Label l_desc = new Label(Variables.curLanguageList.get("Test_Description"));
            firstOption(create_p, l_desc, 107, 235, true);
            Label l_quest = new Label(Variables.curLanguageList.get("Create_Question"));
            firstOption(create_p, l_quest, 138, 295, true);
            Label l_answer = new Label(Variables.curLanguageList.get("Create_Answer"));
            firstOption(create_p, l_answer, 155, 325, true);

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
            b_create.setId("b_create");

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
            firstOption(create_p, b_count, 497, 475, true);
            b_count.setId("b_count");

            b_prev = new Button("<");
            firstOption(create_p, b_prev, 420, 470, true);
            b_prev.setOnAction(new Events.PrevCard());
            b_prev.setDisable(true);

            l_card = new Label("");
            firstOption(create_p, l_card, 437, 460, true);

            b_back = new Button(Variables.curLanguageList.get("Back"));
            firstOption(create_p, b_back, 100, 700, true);
            b_back.setOnAction(_ -> Main.temp.setScene(Main.scene));

            firstOption(create_p, Variables.copyright, 0, Variables.appHeight - 20, true);

            //create_p.getStyleClass().add("greenTheme"); - цветовая тема
            sc_create = new Scene(create_p, Variables.appWidth, Variables.appHeight);
            sc_create.getStylesheets().add("create_style.css");
            JsonHandler.changeColor(sc_create);
            Main.temp.setScene(sc_create);
        }
    }

    // Окно загрузки (необходимо при создании/удалении файлов)
    public static void showLoadingWindow() {
        Stage loadingStage = new Stage();
        loadingStage.initModality(Modality.APPLICATION_MODAL);
        loadingStage.setTitle("Download");

        ProgressIndicator progressIndicator = new ProgressIndicator();
        VBox loadingLayout = new VBox(progressIndicator);
        loadingLayout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        Scene loadingScene = new Scene(loadingLayout, 200, 100);
        loadingStage.setResizable(false);
        // Отменяем событие закрытия
        loadingStage.setOnCloseRequest(Event::consume); // Без возможности закрыть
        loadingStage.setScene(loadingScene);
        loadingStage.show();

        // Запускаем задачу в отдельном потоке
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                // ИСПРАВИТЬ НА ЦИКЛ 'ПОКА ФАЙЛА НЕТ'
                Thread.sleep(7500);
                return null;
            }

            @Override
            protected void succeeded() {
                loadingStage.close(); // Закрываем окно загрузки
            }

            @Override
            protected void failed() {
                loadingStage.close(); // Закрываем окно загрузки в случае ошибки
            }
        };

        new Thread(task).start(); // Запускаем задачу в новом потоке
    }
}