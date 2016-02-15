/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Gumus
 */
public class NoteController  {

    @FXML
    private Label lnote;
   public int note;

    /**
     * Initializes the controller class.
     */
      
    /**
     * Initializes the controller class.
     * @param note
     */
    public void setNote(int note) {
        lnote.setText(note+"/20");
        this.note = note;
    }

   
    
}
