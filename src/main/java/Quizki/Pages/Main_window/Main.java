package Quizki.Pages.Main_window;

import Quizki.Models.JsonHandler;
import Quizki.Models.User;
import Quizki.Models.Variables;
import Quizki.Pages.About_us.About_us;
import Quizki.Pages.Account.Account;
import Quizki.Pages.Create.Create;
import Quizki.Pages.Repository.Repository;
import Quizki.Pages.Settings.Settings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static Quizki.Pages.Repository.Repository.changeScene.firstOption;

/**
 * Реализация неполного функционала тестовой сцены, где пользователю предложен выбор между
 * функциональными вкладками, реализующими полноту проекта.
 */

public class Main extends Application {
    static public Stage temp;
    static public Scene scene;
    public static boolean userExist;
    public static Pane main_p;

    @Override
    public void start(Stage stage) {
        temp = stage;
        printScene();
        stage.setTitle(Variables.projectTitle);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // Вынесено в отдельную функцию, для корректной работы сохранения пользовательских настроек
    public static void printScene(){
        main_p = new Pane();

        // Условие существования пользователя
        userExist = new ArrayList<>(Arrays.asList(
                Objects.requireNonNull(new File(Variables.card_filepath).listFiles())))
                .contains(new File(Variables.card_filepath + Variables.user_file));

        // Назначение языкового набора соответственно выбранного языка пользователем
        if(userExist){
            JsonHandler.changeLanguage();
            JsonHandler.changeColor(main_p);
            JsonHandler.changeUserRate();
            JsonHandler.changeLastEnter();
            Variables.changeMainCat();
        }else{
            JsonHandler.changeLanguage("eng");
            JsonHandler.changeColor(main_p, "green");
            Variables.curLanguageList = Variables.engList;  // по умолчанию - английский
        }

        // Добавление элементов интерфейса (кнопки, текстовые поля, лейблы)
        Button b_about_us = new Button(Variables.curLanguageList.get("Page_AboutUs"));
        b_about_us.setOnAction(new About_us.changeScene());

        Button b_create = new Button(Variables.curLanguageList.get("Page_Create"));
        b_create.setOnAction(new Create.changeScene());

        Button b_repository = new Button(Variables.curLanguageList.get("Page_Repository"));
        b_repository.setOnAction(new Repository.changeScene());

        Button b_account = new Button(Variables.curLanguageList.get("Page_Account"));
        b_account.setOnAction(new Account.changeScene());

        Button b_settings = new Button(Variables.curLanguageList.get("Page_Settings"));
        b_settings.setOnAction(new Settings.changeScene());

        // Принудительная регистрация
        b_about_us.setDisable(!userExist);
        b_create.setDisable(!userExist);
        b_settings.setDisable(!userExist);
        b_repository.setDisable(!userExist);

        firstOption(main_p, b_about_us, 0, 0, true);
        firstOption(main_p, b_create, 200, 0, true);
        firstOption(main_p, b_repository, 300, 0, true);
        firstOption(main_p, b_account, 450, 0, true);
        firstOption(main_p, b_settings, 550, 0, true);
        firstOption(main_p, Variables.copyright, 0, Variables.appHeight - 20, true);
        scene = new Scene(main_p, Variables.appWidth, Variables.appHeight);

        scene.getStylesheets().add("main_style.css");
    }

    public static void main(String[] args) {
        launch(args);
    }
}