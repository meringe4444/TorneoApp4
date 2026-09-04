module uam.edu.ni.torneoapp4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens uam.edu.ni.torneoapp4 to javafx.fxml;
    exports uam.edu.ni.torneoapp4;
}