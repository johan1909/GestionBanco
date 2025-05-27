package co.edu.uniquindio.poo.viewController;


import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.app.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TipoViewController {

    App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCajero;

    @FXML
    private Button btnCliente;

    @FXML
    private Button btnAdministrador;

    @FXML
    void initialize() {
        assert btnCajero != null : "fx:id=\"btnCajero\" was not injected: check your FXML file 'Tipo.fxml'.";
        assert btnCliente != null : "fx:id=\"btnCliente\" was not injected: check your FXML file 'Tipo.fxml'.";
        assert btnAdministrador != null : "fx:id=\"btnAdministrador\" was not injected: check your FXML file 'Tipo.fxml'.";

    }


    public void setApp(App app){
        this.app = app;

    }
}



