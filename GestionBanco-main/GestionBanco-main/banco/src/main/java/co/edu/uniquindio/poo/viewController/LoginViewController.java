package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.app.App;
import co.edu.uniquindio.poo.controllers.UsuarioController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

public class LoginViewController {


    App app;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    

    @FXML
    private Label lblMensaje;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private TextField txtUsuario;

    @FXML
    
    UsuarioController usuarioController = new UsuarioController(app.getBanco());
    void ingresarAction(ActionEvent event) {
        String usuario = txtUsuario.getText();
        String contraseña = txtContrasena.getText();
        

    if (validarDatos(usuario, contraseña)) {
        boolean usuarioIdentificado = usuarioController.iniciarsesion(usuario, contraseña);
            if (usuarioIdentificado) {
                app.openTipoView(); // Asume que app no es null.
            } else {
                lblMensaje.setText("Usuario o contraseña incorrectos");
            }
        }
    }

    private boolean validarDatos(String usuario, String contraseña) {
        boolean valido = true;
        if (usuario.isEmpty()) {
            txtUsuario.setTooltip(new Tooltip("Usuario inválido"));
            valido = false;
        }
        if (contraseña.isEmpty()) {
            txtContrasena.setTooltip(new Tooltip("Contraseña inválida"));
            valido = false;
        }
        return valido;
    }

    @FXML
    void initialize() {
        assert lblMensaje != null : "fx:id=\"lblMensaje\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtContrasena != null : "fx:id=\"txtContrasena\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnIngresar != null : "fx:id=\"btnIngresar\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnRegistrar != null : "fx:id=\"btnRegistrar\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtUsuario != null : "fx:id=\"txtUsuario\" was not injected: check your FXML file 'Login.fxml'.";
        
    }


    public void setApp(App app){
        this.app = app;
    }

}
