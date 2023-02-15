package sample;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.io.IOException;


public class FormController {


    @FXML
    private Button btnGenerate;

    @FXML
    private TextField txtFname;

    @FXML
    private TextField txtLname;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtVac;

    @FXML
    private TextField txtBooth;

    @FXML
    void navigate(ActionEvent event) {
        FXMLLoader loader =  new FXMLLoader(getClass().getResource("Receipt.fxml"));
        try {
            Parent root = (Parent) loader.load();
            ReceiptController receController = loader.getController();
            receController.myFunction(txtFname.getText(), txtLname.getText(),txtAge.getText(), txtCity.getText(), txtId.getText(),  txtVac.getText(), txtBooth.getText());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
