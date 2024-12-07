package Quizki.Pages.Repository;

import Quizki.Models.Collect;
import Quizki.Models.JsonHandler;
import Quizki.Pages.Main_window.Main;
import Quizki.Models.Variables;
import Quizki.Pages.Repository.CardType.CardType;
import Quizki.Pages.Repository.TestType.TestType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Реализация функционального окна персонального репозитория.
 * Репозиторий представляет структуру тестов, созданных конкретным пользователем.
 * В репозитории хранится информация о тестах: имя, описание и сам тест, доступный к прохождению.
 * К тестам должен быть предоставлен свободный доступ для каждого стороннего пользователя.
 */

public class Repository {
    public static Pane p;
    public static Label name, description, l_count;
    public static Button b_next, b_prev, b_card, b_write, b_test;
    public static Collect cur_collect;
    public static ArrayList<Collect> arr_cols = new ArrayList<>();
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            p = new Pane();

            // Добавление файлов с тестами в массив коллекций карточек
            ArrayList<File> arr_files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(new File(Variables.card_filepath).listFiles())));
            for (File f : arr_files){
                try {
                    arr_cols.add(JsonHandler.loadCardFromFile(f.getPath()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            cur_collect = arr_cols.getFirst();

            name = new Label("Название: " + cur_collect.getName());
            firstOption(name, 10, 10, true);

            description = new Label("Описание: " + cur_collect.getDescription());
            firstOption(description, 10, 40, true);


            b_next = new Button(">");
            firstOption(b_next, 215, 210, true);
            b_next.setOnAction(new Events.NextCollection());

            l_count = new Label("");
            l_count.setText(arr_cols.isEmpty() ? "0" : "1");
            firstOption(l_count, 175, 210, true);

            b_prev = new Button("<");
            firstOption(b_prev, 115, 210, true);
            b_prev.setOnAction(new Events.PrevCollection());

            b_card = new Button("Карточки");
            firstOption(b_card, 0, 300, true);

            b_card.setOnAction(new CardType.changeScene());
            b_test = new Button("Тест");
            firstOption(b_test, 150, 300, true);
            b_test.setOnAction(new TestType.changeScene());
            b_write = new Button("Письменный");
            firstOption(b_write, 250, 300, true);

            Scene scene = new Scene(p, Variables.appWidth, Variables.appHeight);
            scene.getStylesheets().add("repository_style.css");
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
    }
}
