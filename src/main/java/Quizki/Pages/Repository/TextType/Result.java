package Quizki.Pages.Repository.TextType;

import Quizki.Models.JsonHandler;
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
 * Отображаются соответствия ответов пользователя и ответов теста.
 * Пользователь имеет доступ к повторному прохождению теста,
 * или прохождению специального теста, состоящего исключительно из вопросов,
 * на которые пользователь ответил неправильно (см. TextType).
 */

public class Result {
    public static Pane result_txt_type_p;
    public static Label l_correct_count, l_incorrect_count;
    public static Button b_continue, b_again, b_back;
    public static Scene scene;

    public static void changeScene() {
        result_txt_type_p = new Pane();


        l_correct_count = new Label(Variables.curLanguageList.get("Test_CorrectAnswers") + ": " + Repository.arr_corr.size());
        firstOption(result_txt_type_p, l_correct_count, 350, 300, true);

        l_incorrect_count = new Label(Variables.curLanguageList.get("Test_WrongAnswers") + ": " + Repository.arr_wrong.size());
        firstOption(result_txt_type_p, l_incorrect_count, 350, 350, true);

        b_continue = new Button(Variables.curLanguageList.get("Test_Continue"));
        firstOption(result_txt_type_p, b_continue, 530, 400, true);
        b_continue.setOnAction(new Events.ContinueTest());

        b_again = new Button(Variables.curLanguageList.get("Test_Again"));
        firstOption(result_txt_type_p, b_again, 350, 400, true);
        b_again.setOnAction(new Events.AgainTest());

        b_back = new Button(Variables.curLanguageList.get("Back"));
        firstOption(result_txt_type_p, b_back, 100, 700, true);
        b_back.setOnAction(new Events.BackScene());

        firstOption(result_txt_type_p, Variables.copyright, 5, Variables.appHeight - 20, true);
        Variables.copyright.getStyleClass().add("copyright");

        scene = new Scene(result_txt_type_p, Variables.appWidth, Variables.appHeight);
        scene.getStylesheets().add("repository_style.css");
        JsonHandler.changeColor(scene);
        Main.temp.setScene(scene);
    }
}