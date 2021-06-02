package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MainPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuBar menu;

    @FXML
    private Menu mCat;

    @FXML
    private MenuItem mCatShow;

    @FXML
    private MenuItem mCatAdd;

    @FXML
    private MenuItem mCatDelete;

    @FXML
    private MenuItem mCatEdit;

    @FXML
    private Menu goods;

    @FXML
    private MenuItem goodsShow;

    @FXML
    private MenuItem goodsEdit;

    @FXML
    private MenuItem goodsAdd;

    @FXML
    private MenuItem goodsDelete;

    @FXML
    private Menu admin;

    @FXML
    private MenuItem adminExit;

    @FXML
    private MenuItem adminAbout;

    @FXML
    void initialize() {

    }
    public void AddCat(){
        mCatAdd.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/AddCategory.fxml"));
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
