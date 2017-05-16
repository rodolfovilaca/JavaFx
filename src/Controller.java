
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
	private static Stage controlStage;
	
	@FXML
	private Button cadastroBtn;
	
	@FXML
	private Button listaBtn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		controlStage = Main.getPrimaryStage();
	}
	
	@FXML
	public void actionButtons(ActionEvent event) {
		if (event.getSource().equals(cadastroBtn)) {
			System.out.println("actionbtn cadastro");
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cadastro.fxml"));
				Parent telaCadastro = (Parent) fxmlLoader.load();
				controlStage.setTitle("Cadastro de Funcion�rios");
				controlStage.setScene(new Scene(telaCadastro,400,400));
				controlStage.show();		
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (event.getSource().equals(listaBtn)) {
			System.out.println("actionbtn lista");

			try {
				FXMLLoader fxml = new FXMLLoader(getClass().getResource("lista.fxml"));
				Parent telaLista = (Parent) fxml.load();
				controlStage.setTitle("Lista de Funcion�rios");
				controlStage.setScene(new Scene(telaLista,400,400));
				controlStage.show();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
