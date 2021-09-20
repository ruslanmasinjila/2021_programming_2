/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playlistapp;

import controllers.PlaylistController;

/**
 *
 * @author mga
 */
public class PlaylistApp {

    public static void run() {        
        System.out.println("PlaylistApp\n========\n\n");
        
        PlaylistController playlistController = new PlaylistController();  
        
        playlistController.run();
        
        System.out.println("Thank you for using PlaylistApp. Good bye.\n");        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PlaylistApp playlistApp = new PlaylistApp();
        playlistApp.run();
    }
    
}
