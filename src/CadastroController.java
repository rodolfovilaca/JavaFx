
import java.awt.Color;

import javax.xml.datatype.DatatypeConstants.Field;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Border;
import javafx.stage.Stage;

public class CadastroController {
	private static Stage controlStage;

	private static final String REGEX = "^[a-zA-Z]+$";

	private static final String REGEXNUM = "[0-9]+";

	@FXML
	private ComboBox<String> currentJob;

	@FXML
	private TextField nameField;

	@FXML
	private TextField idadeField;

	@FXML
	private Button cadastrar;

	@FXML
	private Button cancelar;

	@FXML
	private Label labelFinal;

	@FXML
	public void initialize() {
		controlStage = Main.getPrimaryStage();
	}

	@FXML
	public void handleCombo(final ActionEvent event) {
		validate();
	}

	public void setBorderStyle(boolean valido, TextField field) {
		if (valido) {
			field.setStyle("-fx-border-color: white;-fx-border-width: 2px;");
		} else
			field.setStyle("-fx-border-color: red;-fx-border-width: 2px;");
	}

	@FXML
	public void handleInput(final KeyEvent keyEvent) {
		TextField field = (TextField) keyEvent.getTarget();
		if (field.equals(nameField)) {
			setBorderStyle(validName(field.getText()), field);
		}
		if (field.equals(idadeField)) {
			setBorderStyle(validIdade(field.getText()), field);
		}
		validate();
	}

	public void validate() {
		String text = nameField.getText();
		String text2 = idadeField.getText();
		String combo = currentJob.getSelectionModel().getSelectedItem();
		String erro = "";
		System.out.println(combo);
		if (text != null && !validName(text)) {
			erro += "O primeiro campo deve apenas conter caracteres.\n";
		}
		if (text2 != null && !validIdade(text2)) {
			erro += "O Segundo campo deve conter apenas numeros.\n";
		}
		if (validName(text) && validIdade(text2) && validFuncao(combo)) {
			cadastrar.setDisable(false);
		} else {
			cadastrar.setDisable(true);
		}
		labelFinal.setText(erro);
		labelFinal.setTextFill(javafx.scene.paint.Color.RED);
	}

	public boolean validName(String name) {
		return (name.matches(REGEX) && name.length() > 2);
	}

	public boolean validIdade(String idade) {
		return (idade.matches(REGEXNUM) && idade.length() > 1 && idade.length() < 4);
	}

	public boolean validFuncao(String funcao) {
		return (funcao!=null && funcao.length() > 0);
	}

	@FXML
	public void cadastroAction(ActionEvent event) {
		if (event.getSource().equals(cadastrar)) {
			System.out.println("Cadastrar");
			if (nameField.getText() != null && idadeField.getText() != null && currentJob.getValue() != null) {
				Person recentPerson = new Person(nameField.getText(), idadeField.getText(), currentJob.getValue());
				System.out.println(recentPerson.getJob());
				ListViewController.addList(recentPerson);
				try {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
					Parent telaCadastro = (Parent) fxmlLoader.load();
					controlStage.setTitle("Cadastro de Funcionários");
					controlStage.setScene(new Scene(telaCadastro, 200, 200));
					controlStage.show();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		if (event.getSource().equals(cancelar)) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
				Parent telaCadastro = (Parent) fxmlLoader.load();
				controlStage.setTitle("Cadastro de Funcionários");
				controlStage.setScene(new Scene(telaCadastro, 200, 200));
				controlStage.show();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
