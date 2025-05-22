/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.spotifei;

import com.mycompany.spotifei.view.Login;

/**
 *
 * @author becastal
 */
public class Spotifei {

    public static void main(String[] args) {
        System.out.println("Spotifei rodando...");

	    java.awt.EventQueue.invokeLater(() -> {
		    new Login().setVisible(true);
	    });
    }
}
