package Quizki.Pages.Main_window;

import Quizki.Pages.About_us.About_us;
import Quizki.Pages.Account.Account;
import Quizki.Pages.Create.Create;
import Quizki.Pages.Materials.Materials;
import Quizki.Pages.Repository.Repository;
import Quizki.Pages.Settings.Settings;
import Quizki.Models.Variables;
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
 * - Уменьшить код в main, путем абстрагирования
 */

public class Main extends Application {
    static public Stage temp;
    static public Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        temp = stage;
        Button b_about_as = new Button("About us");
        b_about_as.setOnAction(new About_us.changeScene());

        Button b_materials = new Button("Materials");
        b_materials.setOnAction(new Materials.changeScene());

        Button b_create = new Button("➕");
        b_create.setOnAction(new Create.changeScene());
        b_create.setId("b_create");

        Button b_repository = new Button("\uD83D\uDCC1");
        b_repository.setOnAction(new Repository.changeScene());

        Button b_account = new Button("\uD83D\uDC64");
        b_account.setOnAction(new Account.changeScene());
        b_account.getStyleClass().add("b_right");

        Button b_settings = new Button("⚙");
        b_settings.setOnAction(new Settings.changeScene());
        b_settings.getStyleClass().add("b_right");

        HBox p = new HBox(b_about_as, b_materials, b_repository, b_create, b_account, b_settings);
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