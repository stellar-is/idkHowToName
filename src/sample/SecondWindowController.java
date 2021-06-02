package sample;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SecondWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField newLogin;

//    @FXML
//    private TextField newPassword;

    @FXML
    private Button btnSave;

    @FXML
    private PasswordField newPassword;

    @FXML
    private Button btnCancel;
    Stage stage;

    @FXML
    private void handleButtonAction(javafx.event.ActionEvent event) {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {

        btnSave.setOnAction(actionEvent -> {
            if(newLogin.getText().equals("")&&newPassword.getText().equals("")){
                Alert alert = new Alert(Alert.AlertType.WARNING,"Не введены данные");
                alert.show();
                return ;
            }else if(newLogin.getText().equals("")){
                Alert alert = new Alert(Alert.AlertType.WARNING,"Не введён логин");
                alert.show();
                return ;
            }else if(newPassword.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Не введён пароль");
                alert.show();
                return ;
            }else{
                btnSave.getScene().getWindow().hide();
                User user = new User(newLogin.getText(), newPassword.getText());
                DbWork dbWork = new DbWork();
                dbWork.saveUser(user);
            }

        });
    }


}

