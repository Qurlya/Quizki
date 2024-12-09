package Quizki.Pages.Main_window;

import Quizki.Models.Variables;
import Quizki.Pages.About_us.About_us;
import Quizki.Pages.Account.Account;
import Quizki.Pages.Create.Create;
import Quizki.Pages.Materials.Materials;
import Quizki.Pages.Repository.Repository;
import Quizki.Pages.Settings.Settings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Реализация неполного функционала тестовой сцены, где пользователю предложен выбор между
 * функциональными вкладками, реализующими полноту проекта.
 */

public class Main extends Application {
    static public Stage temp;
    static public Scene scene;
    //public static Pane main_p;
    public static boolean userExist;

    @Override
    public void start(Stage stage) {
        temp = stage;
        //main_p = new Pane();
        // Условие существования пользователя
        userExist = new ArrayList<>(Arrays.asList(
                Objects.requireNonNull(new File(Variables.card_filepath).listFiles())))
                .contains(new File(Variables.card_filepath + Variables.user_file));

        // Добавление элементов интерфейса (кнопки, текстовые поля, лейблы)
        Button b_about_us = new Button(Variables.curLanguageList.get("Page_AboutUs"));
        b_about_us.setOnAction(new About_us.changeScene());

        Button b_materials = new Button(Variables.curLanguageList.get("Page_Materials"));
        b_materials.setOnAction(new Materials.changeScene());

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
        b_materials.setDisable(!userExist);

        /*firstOption(main_p, b_about_us, 0, 0, true);
        firstOption(main_p, b_materials, 100, 0, true);
        firstOption(main_p, b_create, 200, 0, true);
        firstOption(main_p, b_repository, 300, 0, true);
        firstOption(main_p, b_account, 400, 0, true);
        firstOption(main_p, b_settings, 500, 0, true);*/

        HBox main_p = new HBox(b_about_us, b_materials, b_create, b_repository, b_account, b_settings);
        scene = new Scene(main_p, Variables.appWidth, Variables.appHeight);

        scene.getStylesheets().add("main_style.css");
        stage.setTitle(Variables.projectTitle);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}