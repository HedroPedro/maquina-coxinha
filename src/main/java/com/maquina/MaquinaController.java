/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maquina;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


public class MaquinaController {
    @FXML
    private TextField fieldCoxinhas;
    
    @FXML
    private TextField fieldVender;
 
    @FXML
    private TextField fieldAbastecer;
    
    private MaquinaCoxinhaModel maquina;
    
    @FXML
    private void initialize(){
        maquina = new MaquinaCoxinhaModel();
        fieldCoxinhas.setText(String.valueOf(maquina.getCoxinhas()));
        fieldAbastecer.setText("0");
        fieldVender.setText("0");
    }
    
    @FXML
    private void abastecer(){
        Integer qtd = Integer.valueOf(fieldAbastecer.getText());
        if(qtd < 0){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro");
            alerta.setContentText("Quantidade de coxinhas negativo");
            alerta.show();
        }else{
            maquina.abastecer(qtd);
            updateCoxinhasQtd();
        }
        fieldAbastecer.setText("0");
    }
    
    @FXML
    private void vender(){
        if(maquina.getCoxinhas()-1 < 0){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro");
            alerta.setContentText("Sem coxinhas para vender");
            alerta.show();
            return;
        }
        maquina.vender();
        updateCoxinhasQtd();
    }
    
    @FXML
    private void venderQtd(){
        Integer qtd = Integer.valueOf(fieldVender.getText());
        if(maquina.getCoxinhas() < qtd){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro");
            alerta.setContentText("Quantidade de coxinhas para vender sobrepõe quantidade de coxinhas no estoque");
            alerta.setHeight(250.0d);
            alerta.show();
        }else{
            maquina.vender(qtd);
            updateCoxinhasQtd();
        }
        fieldVender.setText("0");
    }
    
    @FXML
    private void zeraMaquina(){
        maquina.zerarMaquina();
        cleanTextFields();
    }
    
    private void updateCoxinhasQtd(){
        fieldCoxinhas.setText(String.valueOf(maquina.getCoxinhas()));
    }
    
    private void cleanTextFields(){
        fieldCoxinhas.setText("0");
        fieldAbastecer.setText("0");
        fieldVender.setText("0");
    }
}
