package co.edu.uniquindio.poo;

import java.io.IOException;

import co.edu.uniquindio.poo.app.App;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
