package com.example.di_433_lambdaexpressions;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import static java.lang.Math.pow;


public class CalculadoraLambdaExpressions extends Application
{
    TextField txt1 = new TextField();
    TextField txt2 = new TextField();
    TextField txt3 = new TextField();
    TextField txt4 = new TextField();
    TextField txt5 = new TextField();

    double i;
    double n;
    double h;

    @Override
    public void start(Stage primaryStage)
    {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        primaryStage.setTitle("Calculadora Lambda Expressions");

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);

        Label lb1 = new Label("Annual Interest Rate: ");

        txt1.alignmentProperty().setValue(Pos.BASELINE_RIGHT);
        grid.add(lb1, 0, 0);
        grid.add(txt1, 1, 0);

        Label lb2 = new Label("Number of Years: ");

        txt2.alignmentProperty().setValue(Pos.BASELINE_RIGHT);
        grid.add(lb2, 0, 1);
        grid.add(txt2, 1, 1);

        Label lb3 = new Label("Loan Amount: ");

        txt3.alignmentProperty().setValue(Pos.BASELINE_RIGHT);
        grid.add(lb3, 0, 2);
        grid.add(txt3, 1, 2);

        Label lb4 = new Label("Monthly Payment: ");

        txt4.alignmentProperty().setValue(Pos.BASELINE_RIGHT);
        txt4.setEditable(false);
        grid.add(lb4, 0, 3);
        grid.add(txt4, 1, 3);

        Label lb5 = new Label("Total Payment: ");

        txt5.alignmentProperty().setValue(Pos.BASELINE_RIGHT);
        txt5.setEditable(false);
        grid.add(lb5, 0, 4);
        grid.add(txt5, 1, 4);

        Button btn = new Button("Calculate");
        grid.add(btn, 1, 5);

        btn.setOnAction(e -> {calculate();});

        primaryStage.show();
    }

    void calculate()
    {
        validate();

        double m = (h * (i / (100*12))) / (1 - (1 / pow((1 + (i / (100 * 12))), 12 * n)));

        txt4.setText(String.format("$ %.2f", m));

        double t = m * 12 * n;

        txt5.setText(String.format("$ %.2f", t));
    }

    void validate()
    {
        try
        {
            i = Double.parseDouble(txt1.getText());
            n = Double.parseDouble(txt2.getText());
            h = Double.parseDouble(txt3.getText());
        }
        catch (Exception e)
        {
            System.out.println("Dato, inválido. Introduzca un número...");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}