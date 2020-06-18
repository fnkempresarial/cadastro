/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.carregaSoftware;

import br.com.telas.Login;
import br.com.telas.Splash;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author frank
 */
public class Carregador {
    
    public static void main (String [] args){
        Splash inicio = new Splash();
        
        inicio.setVisible(true);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Carregador.class.getName()).log(Level.SEVERE, null, ex);
        }
        inicio.dispose();
        Login comeca = new Login();
        comeca.setVisible(true);
    }
    
}
