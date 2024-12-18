package Quizki.Pages.Repository;

import Quizki.Models.Card;
import Quizki.Models.Collect;
import Quizki.Models.JsonHandler;
import Quizki.Models.Variables;
import Quizki.Pages.Create.Create;
import Quizki.Pages.Main_window.Main;
import Quizki.Pages.Repository.CardType.CardType;
import Quizki.Pages.Repository.TestType.TestType;
import Quizki.Pages.Repository.TextType.TextType;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

import static Quizki.Models.Variables.curLanguageList;

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
    public static Scene scene;

    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            repos_p = new Pane();

            // Добавление файлов с тестами в список коллекций карточек
            ArrayList<File> arr_files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(new File(Variables.card_filepath).listFiles())));
            arr_files.remove(new File(Variables.card_filepath + Variables.user_file));

            for (File f : arr_files) {
                arr_cols.add(JsonHandler.loadCardFromFile(f.getAbsolutePath()));
            }
            // Если нет тестов - вызывается исключение
            try {
                cur_collect = arr_cols.getFirst();

            // Добавление элементов интерфейса (кнопки, текстовые поля, лейблы)
            name = new Label(curLanguageList.get("Test_Name") + ": " + cur_collect.getName());
            firstOption(repos_p, name, 300, 240, true);

            description = new Label(curLanguageList.get("Test_Description") + ": " + cur_collect.getDescription());
            firstOption(repos_p, description, 300, 280, true);

            l_count = new Label("");
            l_count.setText(arr_cols.isEmpty() ? "0" : "1");
            firstOption(repos_p, l_count, 497, 435, true);

            b_next = new Button(">");
            firstOption(repos_p, b_next, 542, 430, true);
            b_next.setOnAction(new Events.NextCollection());
            b_next.setDisable(arr_cols.size() <= 1);

            b_prev = new Button("<");
            firstOption(repos_p, b_prev, 420, 430, true);
            b_prev.setOnAction(new Events.PrevCollection());
            b_prev.setDisable(true);

            b_card = new Button(curLanguageList.get("Repos_Card"));
            firstOption(repos_p, b_card, 290, 360, true);
            b_card.setOnAction(new CardType.changeScene());
            b_card.setId("b_card");
            b_card.getStyleClass().add("tests");

            b_test = new Button(curLanguageList.get("Repos_Test"));
            firstOption(repos_p, b_test, 420, 360, true);
            b_test.setOnAction(new TestType.changeScene());
            b_test.setId("b_test");
            b_test.getStyleClass().add("tests");

            b_write = new Button(curLanguageList.get("Repos_Text"));
            firstOption(repos_p, b_write, 595, 360, true);
            b_write.setOnAction(new TextType.changeScene());
            b_write.getStyleClass().add("tests");

            b_back = new Button(curLanguageList.get("Back"));   // Кнопка назад
            firstOption(repos_p, b_back, 100, 700, true);
            b_back.setOnAction(_ -> {
                arr_cols = new ArrayList<>();
                Main.printScene();
                Main.temp.setScene(Main.scene);
            });

            b_delete = new Button(curLanguageList.get("Repos_Delete"));
            firstOption(repos_p, b_delete, 420, 500, true);
            b_delete.setOnAction(new Events.DeleteCollection());
            b_delete.setDisable(arr_cols.isEmpty());
            b_delete.setId("b_delete");

            firstOption(repos_p, Variables.copyright, 5, Variables.appHeight - 20, true);
            Variables.copyright.getStyleClass().add("copyright");

            scene = new Scene(repos_p, Variables.appWidth, Variables.appHeight);
            scene.getStylesheets().add("repository_style.css");
            JsonHandler.changeColor(scene);
            Main.temp.setScene(scene);
            }catch(NoSuchElementException e1){
                Create.alert.setContentText("No tests for watch!");
                Create.alert.showAndWait();
            }
        }

        // Методы быстрого добавления объектов интерфейса на панель
        // по определенным координатам X и Y, с видимостью Flag
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

        public static void firstOption(Pane pane, ChoiceBox<String> temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            pane.getChildren().add(temp);
        }

        public static void firstOption(Pane pane, Image temp, int x, int y, boolean flag) {
            ImageView imageView = new ImageView();
            imageView.setImage(temp);
            imageView.setLayoutX(x);
            imageView.setLayoutY(y);
            imageView.setVisible(flag);
            pane.getChildren().add(imageView);
        }

        public static void firstOption(Pane pane, ImageView temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            pane.getChildren().add(temp);
        }
    }
}