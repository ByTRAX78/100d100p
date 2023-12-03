module com.dayfour.day4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;


    opens com.dayfour.day4 to javafx.fxml;
    exports com.dayfour.day4;
}