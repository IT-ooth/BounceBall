module com.itooth {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.itooth to javafx.fxml;
    exports com.itooth;
}
