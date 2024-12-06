/**
 * Зависимости для JavaFX
 */

module com.example.quizki {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.smartcardio;
    requires com.google.gson;
    requires com.fasterxml.jackson.databind;
    requires java.desktop;

    opens Quizki to javafx.fxml;
    //exports Quizki;

    opens Quizki.Pages.Main_window to javafx.fxml;
    exports Quizki.Pages.Main_window;
    exports Quizki.Models;
    opens Quizki.Models to javafx.fxml;
}