package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtLlogin;

//    @FXML
//    private TextField txtPassword;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnEnter;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnReg;
    Stage stage;
    @FXML
    private void handleButtonAction(javafx.event.ActionEvent event) {
    stage = (Stage)((Button)event.getSource()).getScene().getWindow();
    stage.close();
    }

    @FXML
    void initialize() {
        btnEnter.setOnAction(actionEvent ->{
            if(txtLlogin.getText().equals("")&&txtPassword.getText().equals("")){
                Alert alert = new Alert(Alert.AlertType.WARNING,"Не введены данные");
                alert.show();
                return ;
            }else if(txtLlogin.getText().equals("")){
                Alert alert = new Alert(Alert.AlertType.WARNING,"Не введён логин");
                alert.show();
                return ;
            }else if(txtPassword.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Не введён пароль");
                alert.show();
                return ;
            }else {
                btnEnter.getScene().getWindow().hide();
                String login = txtLlogin.getText().trim();
                String password = txtPassword.getText().trim();

                System.out.println("Password in " + password);
                System.out.println("Login in " + login);

                User user = new User(login, password);
                DbWork dbWork = new DbWork();
                boolean isChecked = dbWork.checkUser(user);
                if (isChecked) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/view/mainPage.fxml"));
                    try {
                        Scene scene = new Scene(loader.load(),500, 270);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Вход не выполнен, пошёл нахххой!");
                    alert.show();
                }
            }
        });

        btnReg.setOnAction(actionEvent -> {
            btnReg.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/SecondWindow.fxml"));
            try {
                Scene scene = new Scene(loader.load(),250, 270);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
