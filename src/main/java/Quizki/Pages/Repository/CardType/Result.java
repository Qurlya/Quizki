package Quizki.Pages.Repository.CardType;

import Quizki.Models.Variables;
import Quizki.Pages.Main_window.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 *  Реализация функционального окна результат прохождения теста с карточками.
 *  Отображается количество правильных и неправильных ответов, а также пользователю
 *  доступны варианты прохождения этого же теста (см. CardType).
 */

public class Result {
    public static Pane p;
    public static Label l_correct_count, l_incorrect_count;
    public static Button b_continue, b_again, b_back;
    public static Scene scene;
    public static void changeScene() {
        p = new Pane();
        l_correct_count = new Label("Верных ответов: " + CardType.arr_corr.size());
        firstOption(l_correct_count, 400, 300, true);

        l_incorrect_count = new Label("Неверных ответов: " + CardType.arr_wrong.size());
        firstOption(l_incorrect_count, 400, 350, true);

        b_continue = new Button("Продолжить");
        firstOption(b_continue, 530, 400, true);
        b_continue.setOnAction(new Events.Continue());

        b_again = new Button("Начать заново");
        firstOption(b_again, 350, 400, true);
        b_again.setOnAction(new Events.Reset());

        b_back = new Button("Назад");
        firstOption(b_back, 100, 700, true);
        b_back.setOnAction(new Events.BackScene());

        scene = new Scene(p, Variables.appWidth, Variables.appHeight);
        scene.getStylesheets().add("repository_style.css");
        Main.temp.setScene(scene);
    }
    static private void firstOption(Button temp, int x, int y, boolean flag) {
        temp.setLayoutX(x);
        temp.setLayoutY(y);
        temp.setVisible(flag);
        p.getChildren().add(temp);
    }
    static private void firstOption(TextField temp, int x, int y, boolean flag) {
        temp.setLayoutX(x);
        temp.setLayoutY(y);
        temp.setVisible(flag);
        p.getChildren().add(temp);
    }
    static private void firstOption(Label temp, int x, int y, boolean flag) {
        temp.setLayoutX(x);
        temp.setLayoutY(y);
        temp.setVisible(flag);
        p.getChildren().add(temp);
    }
}
