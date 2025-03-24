module com.life.lifegame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.life.lifegame to javafx.fxml;
    exports com.life.lifegame;
}