module com.iamsinghankit.javafxlearning {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.web;
    exports com.iamsinghankit.javafxlearning;
    opens com.iamsinghankit.javafxlearning to javafx.fxml;
}
