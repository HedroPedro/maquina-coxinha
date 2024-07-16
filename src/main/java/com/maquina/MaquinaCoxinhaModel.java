package com.maquina;

public class MaquinaCoxinhaModel {
    private Integer qtdCoxinhas;
    
    public MaquinaCoxinhaModel(){
        qtdCoxinhas = 0;
    }
    
    public Integer getCoxinhas(){
        return qtdCoxinhas;
    }
    
    public void abastecer(Integer coxinhas){
        if(coxinhas > 0){
            qtdCoxinhas += coxinhas;
        }
    }
    
    public void vender(){
        if(qtdCoxinhas > 0) {
            qtdCoxinhas--;
        }
    }
    
    public void vender(Integer qtdVender){
        if(qtdCoxinhas >= qtdVender){
            qtdCoxinhas -= qtdVender;
        }
    }
    
    public void zerarMaquina(){
        qtdCoxinhas = 0;
    }
}
