package Quizki.Pages.Repository;

import Quizki.Models.Card;
import Quizki.Models.Collect;
import Quizki.Models.JsonHandler;
import Quizki.Models.Variables;
import Quizki.Pages.Main_window.Main;
import Quizki.Pages.Repository.CardType.CardType;
import Quizki.Pages.Repository.TestType.TestType;
import Quizki.Pages.Repository.TextType.TextType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
    public static Pane repos_p;
    public static Label name, description, l_count;
    public static Button b_next, b_prev, b_card, b_write, b_test, b_back, b_delete;
    public static Collect cur_collect;
    public static ArrayList<Collect> arr_cols = new ArrayList<>();
    public static ArrayList<Card> arr_corr, arr_wrong, arr_cards;
    public static int card_count = 1;
    public static Card cur_card;

    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            repos_p = new Pane();

            // Добавление файлов с тестами в список коллекций карточек
            ArrayList<File> arr_files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(new File(Variables.card_filepath).listFiles())));
            for (File f : arr_files) {
                try {
                    arr_cols.add(JsonHandler.loadCardFromFile(f.getPath()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            cur_collect = arr_cols.getFirst();

            // Добавление элементов интерфейса (кнопки, текстовые поля, лейблы)
            name = new Label(Variables.curLanguageList.get("Test_Name") + ": " + cur_collect.getName());
            firstOption(repos_p, name, 10, 10, true);

            description = new Label(Variables.curLanguageList.get("Test_Description") + ": " + cur_collect.getDescription());
            firstOption(repos_p, description, 10, 40, true);

            l_count = new Label("");
            l_count.setText(arr_cols.isEmpty() ? "0" : "1");
            firstOption(repos_p, l_count, 175, 210, true);

            b_next = new Button(">");
            firstOption(repos_p, b_next, 215, 210, true);
            b_next.setOnAction(new Events.NextCollection());
            b_next.setDisable(arr_cols.size() == 1);

            b_prev = new Button("<");
            firstOption(repos_p, b_prev, 115, 210, true);
            b_prev.setOnAction(new Events.PrevCollection());
            b_prev.setDisable(arr_cols.size() == 1);

            b_card = new Button(Variables.curLanguageList.get("Repos_Card"));
            firstOption(repos_p, b_card, 0, 300, true);
            b_card.setOnAction(new CardType.changeScene());

            b_test = new Button(Variables.curLanguageList.get("Repos_Test"));
            firstOption(repos_p, b_test, 150, 300, true);
            b_test.setOnAction(new TestType.changeScene());

            b_write = new Button(Variables.curLanguageList.get("Repos_Text"));
            firstOption(repos_p, b_write, 250, 300, true);
            b_write.setOnAction(new TextType.changeScene());

            b_back = new Button(Variables.curLanguageList.get("Back"));   // Кнопка назад
            firstOption(repos_p, b_back, 0, 400, true);
            b_back.setOnAction(new Events.BackScene());

            b_delete = new Button(Variables.curLanguageList.get("Repos_Delete"));
            firstOption(repos_p, b_delete, 0, 450, true);
            b_delete.setOnAction(new Events.DeleteCollection());

            Scene scene = new Scene(repos_p, Variables.appWidth, Variables.appHeight);
            scene.getStylesheets().add("repository_style.css");
            Main.temp.setScene(scene);
        }

        // Методы быстрого добавления объекта интерфейса по определенным координатам с видимостью flag
        public static void firstOption(Pane pane, Button temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            pane.getChildren().add(temp);
        }

        public static void firstOption(Pane pane, TextField temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            pane.getChildren().add(temp);
        }

        public static void firstOption(Pane pane, Label temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            pane.getChildren().add(temp);
        }

        public static void firstOption(Pane pane, RadioButton temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            pane.getChildren().add(temp);
        }
    }
}