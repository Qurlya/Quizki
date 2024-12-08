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

import java.io.IOException;

/**
 * Реализация неполного функционала тестовой сцены, где пользователю предложен выбор между
 * функциональными вкладками, реализующими полноту проекта.
 * На будущее:
 * - Перенести лейбл с кнопками для каждого функционального окна в top_center
 */

public class Main extends Application {
    static public Stage temp;
    static public Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        temp = stage;

        // Добавление элементов интерфейса (кнопки, текстовые поля, лейблы)
        Button b_about_as = new Button(Variables.curLanguageList.get("Page_AboutUs"));
        b_about_as.setOnAction(new About_us.changeScene());

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

        HBox p = new HBox(b_about_as, b_materials, b_create, b_repository, b_account, b_settings);
        scene = new Scene(p, Variables.appWidth, Variables.appHeight);

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