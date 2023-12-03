package com.dayfour.day4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;


public class HelloController {

    @FXML
    private TextField val1,val2;

    @FXML
    protected void clean(){
        val1.setText("");
        val2.setText("");
    }

    @FXML
    protected void initialize(){

        val1.setOnKeyReleased(event -> {
        String validacion=val1.getText();
            if (validacion.equals("")){
                val2.setText("");
            }else {
                try {


                    int valor1 = Integer.parseInt(val1.getText());
                    String binario = Integer.toBinaryString(valor1);
                    val2.setText(binario);
                } catch (NumberFormatException e){
                val2.setText("Error de formato");
            }

            }
        });
        val2.setOnKeyReleased(event -> {

            String validacion=val2.getText();
            if (validacion.equals("")){
                val1.setText("");

            }else {
                try {


                    String valor2 = val2.getText();

                    int decimal = Integer.parseInt(valor2, 2);
                    val1.setText(String.valueOf(decimal));
                }catch (NumberFormatException e){
                    val1.setText("Error de formato");
                }
            }
        });

    }
    @FXML
    protected void copy1(){
        String textToCopy = val1.getText();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(textToCopy);
        clipboard.setContents(stringSelection, stringSelection);
    }
    @FXML
    protected void copy2(){
        String textToCopy = val2.getText();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(textToCopy);
        clipboard.setContents(stringSelection, stringSelection);
    }




}