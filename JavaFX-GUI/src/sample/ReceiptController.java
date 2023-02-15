package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ReceiptController implements Initializable {

    @FXML
    private Label lblFirstName;

    @FXML
    private Label lblSurname;

    @FXML
    private Label lblAge;

    @FXML
    private Label lblCity;

    @FXML
    private Label lblId;

    @FXML
    private Label lblVaccineName;

    @FXML
    private Label lblBoothNumber;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void myFunction(String fName, String lName, String lAge, String lCity, String lId, String lVac, String lBooth){
        lblFirstName.setText(fName);
        lblSurname.setText(lName);
        lblAge.setText(lAge);
        lblCity.setText(lCity);
        lblId.setText(lId);
        lblVaccineName.setText(lVac);
        lblBoothNumber.setText(lBooth);
    }


}
