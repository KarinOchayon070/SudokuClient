module com.hit.controller{
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.hit.controller to javafx.fxml;
    exports com.hit.controller;
    exports com.hit.driver;
}


