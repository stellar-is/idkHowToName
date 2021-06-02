package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class AddCategoryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField AddCatField;

    @FXML
    private CheckBox isActiveBox;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnCancel;

    @FXML
    void initialize() {

    }
}
