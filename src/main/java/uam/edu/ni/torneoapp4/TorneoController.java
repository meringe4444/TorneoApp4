package uam.edu.ni.torneoapp4;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class TorneoController {

    @FXML private TextField txtNombre, txtEdad, txtTelefono;
    @FXML private ComboBox<String> cmbCategoria, cmbGenero, cmbModalidad, cmbDisciplina;
    @FXML private ListView<String> listCaracteristicas;
    @FXML private CheckBox chkInscrito;

    @FXML private TableView<Participante> tabla;
    @FXML private TableColumn<Participante, String> colNombre, colCategoria,
            colModalidad, colDisciplina, colCaracteristicas, colEstado;
    @FXML private TableColumn<Participante, Integer> colEdad;

    @FXML
    public void initialize() {

        cmbCategoria.getItems().addAll("Juvenil", "Intermedia", "Senior");
        cmbGenero.getItems().addAll("Masculino", "Femenino");
        cmbModalidad.getItems().addAll("Individual", "Parejas", "Equipos");

        cmbDisciplina.getItems().addAll(
                "Fútbol", "Baloncesto", "Voleibol",
                "Atletismo", "Natación", "Tenis"
        );

        listCaracteristicas.getItems().addAll(
                "Federado",
                "Experiencia previa",
                "Disponibilidad fines de semana",
                "Seguro deportivo"
        );

        listCaracteristicas.getSelectionModel()
                .setSelectionMode(SelectionMode.MULTIPLE);

        txtTelefono.setTextFormatter(new TextFormatter<>(c ->
                c.getControlNewText().matches("\\d{0,8}") ? c : null));

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colModalidad.setCellValueFactory(new PropertyValueFactory<>("modalidad"));
        colDisciplina.setCellValueFactory(new PropertyValueFactory<>("disciplina"));
        colCaracteristicas.setCellValueFactory(new PropertyValueFactory<>("caracteristicas"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
    }

    @FXML
    private void registrar() {

        String nombre = txtNombre.getText().trim();

        if (nombre.length() < 5) {
            alerta("Nombre obligatorio, mínimo 5 caracteres.");
            return;
        }

        int edad;

        try {
            edad = Integer.parseInt(txtEdad.getText());
        } catch (Exception e) {
            alerta("Edad inválida.");
            return;
        }

        if (edad < 15 || edad > 60) {
            alerta("Edad entre 15 y 60.");
            return;
        }

        if (!txtTelefono.getText().matches("\\d{8}")) {
            alerta("Teléfono debe tener 8 números.");
            return;
        }

        if (cmbCategoria.getValue() == null ||
                cmbModalidad.getValue() == null ||
                cmbDisciplina.getValue() == null) {

            alerta("Seleccione categoría, modalidad y disciplina.");
            return;
        }

        String caracteristicas = String.join(", ",
                listCaracteristicas.getSelectionModel().getSelectedItems());

        String estado = chkInscrito.isSelected()
                ? "Inscrito" : "Pendiente";

        String telefono = txtTelefono.getText();
        telefono = telefono.substring(0,4) + "-" + telefono.substring(4);

        Participante p = new Participante(
                nombre,
                edad,
                telefono,
                cmbCategoria.getValue(),
                cmbGenero.getValue(),
                cmbModalidad.getValue(),
                cmbDisciplina.getValue(),
                caracteristicas,
                estado
        );

        tabla.getItems().add(p);
    }

    private void alerta(String mensaje) {
        new Alert(Alert.AlertType.WARNING, mensaje).showAndWait();
    }
}