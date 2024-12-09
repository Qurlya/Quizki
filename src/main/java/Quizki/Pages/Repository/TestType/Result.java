package Quizki.Pages.Repository.TestType;

import Quizki.Models.Variables;
import Quizki.Pages.Main_window.Main;
import Quizki.Pages.Repository.Repository;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import static Quizki.Pages.Repository.Repository.changeScene.firstOption;

/**
 * Реализация окна результатов прохождения текстового формата теста.
 * Отображаются соответствия между ответами пользователя и ответами теста.
 * Пользователь имеет доступ к повторному прохождению теста,
 * или прохождению специального теста, состоящего исключительно из вопросов,
 * на которые пользователь ответил неправильно (см. TestType).
 */

public class Result {
    public static Pane result_test_p;
    public static Label l_correct_count, l_incorrect_count;
    public static Button b_continue, b_again, b_back;
    public static Scene scene;

    public static void changeScene() {
        result_test_p = new Pane();
        l_correct_count = new Label(Variables.curLanguageList.get("Test_CorrectAnswers") + ": " + Repository.arr_corr.size());
        firstOption(result_test_p, l_correct_count, 0, 20, true);

        l_incorrect_count = new Label(Variables.curLanguageList.get("Test_WrongAnswers") + ": " + Repository.arr_wrong.size());
        firstOption(result_test_p, l_incorrect_count, 0, 50, true);

        b_continue = new Button(Variables.curLanguageList.get("Test_Continue"));
        firstOption(result_test_p, b_continue, 0, 100, true);
        b_continue.setOnAction(new Events.ContinueTest());

        b_again = new Button(Variables.curLanguageList.get("Test_Again"));
        firstOption(result_test_p, b_again, 150, 100, true);
        b_again.setOnAction(new Events.AgainTest());

        b_back = new Button(Variables.curLanguageList.get("Back"));
        firstOption(result_test_p, b_back, 0, 300, true);
        b_back.setOnAction(new Events.BackScene());

        scene = new Scene(result_test_p, Variables.appWidth, Variables.appHeight);
        scene.getStylesheets().add("repository_style.css");
        Main.temp.setScene(scene);
    }
}