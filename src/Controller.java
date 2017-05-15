
import java.awt.Color;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;
import java.util.jar.Attributes.Name;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

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
				controlStage.setTitle("Cadastro de Funcionários");
				controlStage.setScene(new Scene(telaCadastro,400,400));
				controlStage.show();		
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (event.getSource().equals(listaBtn)) {
			System.out.println("actionbtn lista");
			for(int i=0; i<ListViewController.getList().size();i++){
				System.out.println(ListViewController.getList().get(i));
			}
			try {
				FXMLLoader fxml = new FXMLLoader(getClass().getResource("lista.fxml"));
				Parent telaLista = (Parent) fxml.load();
				//StackPane root = new StackPane();
				//root.getChildren().add(listaFunc);
				controlStage.setTitle("Lista de Funcionários");
				controlStage.setScene(new Scene(telaLista,400,400));
				controlStage.show();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
