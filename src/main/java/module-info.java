module com.example.di_433_lambdaexpressions {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.di_433_lambdaexpressions to javafx.fxml;
    exports com.example.di_433_lambdaexpressions;
}