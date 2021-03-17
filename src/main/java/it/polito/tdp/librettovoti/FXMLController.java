package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Libretto model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtEsame;

    @FXML
    private TextField txtVoto;
    
    @FXML
    private DatePicker pickerEsame;

    @FXML
    private TextArea txtOutput;

    @FXML
    void doInserisci(ActionEvent event) {
    	
    	String nomeEsame = txtEsame.getText();
    	String votoEsame = txtVoto.getText();
    	LocalDate data = pickerEsame.getValue();
    	
    	if(nomeEsame.length() == 0) {
    		
    		txtOutput.setText("ERRORE: Nome esame vuoto!");
    		return;
    		
    	}
    	
    	if(votoEsame.equals("")) {
    		
    		txtOutput.setText("ERRORE: Voto esame vuoto!");
    		return;
    		
    	}
    	
    	int votoInt = 0;
    	
    	try {
    		votoInt = Integer.parseInt(votoEsame);
    	} catch(NumberFormatException nfe) {
    		
    		txtOutput.setText("ERRORE: Il voto deve essere numerico!");
    		return;
    		
    	}
    	
    	if(votoInt<18 || votoInt>30) {
    		
    		txtOutput.setText("ERRORE: Il voto deve essere compreso tra 18 e 30!");
    		return;
    		
    	}
    	
    	if(data == null) {
    		
    		txtOutput.setText("ERRORE: Data esame vuota o sbagliata!");
    		return;
    		
    	}
    	
    	Voto Voto = new Voto(nomeEsame, votoInt, data);
    	model.add(Voto);
    	
    	txtOutput.setText(model.toString());
    	
    	txtEsame.clear();
    	txtVoto.clear();
    	pickerEsame.setValue(null);
    	
    }
    
    public void setModel(Libretto model) {
    	this.model = model;
    }
    
    @FXML
    void initialize() {
    	
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert pickerEsame != null : "fx:id=\"pickerEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

