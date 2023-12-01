package com.example.demo1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import Exception.ExceptionChoose;


public class HelloController {
    private double valor,valor1;
    private String message1,message2;

    @FXML
    private TextField val1,val2;
    @FXML
    private MenuButton principal,principal1;
    @FXML
    private  MenuItem mxn,usd,eur,mxn1,usd1,eur1;
    private final Model model = new Model();



    @FXML
    protected void clean(){
        val1.setText("");
        val2.setText("");
    }






    @FXML
   protected void initialize() {




setListeners();



    }




    private void setListeners(){

        mxn.setOnAction(event -> selectedItem(mxn));
        usd.setOnAction(event -> selectedItem(usd));
        eur.setOnAction(event -> selectedItem(eur));
        mxn1.setOnAction(event -> selectedItem(mxn1));
        usd1.setOnAction(event -> selectedItem(usd1));
        eur1.setOnAction(event -> selectedItem(eur1));
        val1.setOnKeyReleased(event -> convertCurrency());
        val2.setOnKeyReleased(event -> convertCurrency());

    }


private void selectedItem(MenuItem selectedItem){
        if (mxn.equals(selectedItem) || usd.equals(selectedItem) || eur.equals(selectedItem)){
    principal.setText(selectedItem.getText());
            val1.setDisable(false);
        }
    if (mxn1.equals(selectedItem) || usd1.equals(selectedItem) || eur1.equals(selectedItem)){
        principal1.setText(selectedItem.getText());
        val2.setDisable(false);}


    convertCurrency();

}

    private void convertCurrency(){

        String monedaOrigen = principal.getText();
        String monedaDestino = principal1.getText();


        if(monedaOrigen != null && monedaDestino != null){
            try{
                double quantity = Double.parseDouble(val1.getText());
                double result = model.converse(monedaOrigen, monedaDestino, quantity);
               val2.setText(String.format("%.2f",result));

            }catch(NumberFormatException e){
               val2.setText("error");

            }
        }
    }


}