package Quizki.Pages.Main_window;

import Quizki.Models.JsonHandler;
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
 * Реализация функционала окна главного меню, где пользователю предложен выбор между
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
            JsonHandler.changeUserRate();
            JsonHandler.changeLastEnter();
            Variables.changeMainCat();
        }else{
            //Variables.curLanguageList = Variables.engList;  // по умолчанию - английский
        }

        // Добавление элементов интерфейса (кнопки, текстовые поля, лейблы)
        Button b_about_us = new Button(Variables.curLanguageList.get("Page_AboutUs"));
        b_about_us.setOnAction(new About_us.changeScene());
        b_about_us.getStyleClass().add("b_left");

        Button b_create = new Button(Variables.curLanguageList.get("Page_Create"));
        b_create.setOnAction(new Create.changeScene());
        b_create.setId("b_create");
        b_create.getStyleClass().add("b_create");

        Button b_repository = new Button("\uD83D\uDCC1 " + Variables.curLanguageList.get("Page_Repository"));
        b_repository.setOnAction(new Repository.changeScene());
        b_repository.getStyleClass().add("b_left");

        Button b_account = new Button("\uD83D\uDC64 " + Variables.curLanguageList.get("Page_Account"));
        b_account.setOnAction(new Account.changeScene());
        b_account.getStyleClass().add("b_right");

        Button b_settings = new Button("⚙ " + Variables.curLanguageList.get("Page_Settings"));
        b_settings.setOnAction(new Settings.changeScene());
        b_settings.getStyleClass().add("b_right");

        // Принудительная регистрация
        b_about_us.setDisable(!userExist);
        b_create.setDisable(!userExist);
        b_settings.setDisable(!userExist);
        b_repository.setDisable(!userExist);

        firstOption(main_p, b_about_us, 0, 0, true);
        firstOption(main_p, b_create, 265, 0, true);
        firstOption(main_p, b_repository, 200, 0, true);
        firstOption(main_p, b_account, 660, 0, true);
        firstOption(main_p, b_settings, 835, 0, true);
        firstOption(main_p, Variables.copyright, 5, Variables.appHeight - 20, true);
        Variables.copyright.getStyleClass().add("copyright");
        scene = new Scene(main_p, Variables.appWidth, Variables.appHeight);

        scene.getStylesheets().add("main_style.css");
        if(userExist){
            JsonHandler.changeColor(scene);
        }else{
            scene.getStylesheets().add("green.css");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}