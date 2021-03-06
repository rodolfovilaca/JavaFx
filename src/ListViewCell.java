import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

import java.io.IOException;

import org.omg.CORBA.INITIALIZE;


public class ListViewCell extends ListCell<Person> {

	@FXML
	private HBox hBox;
	@FXML
	private Label nome;
	@FXML
	private Label idade;
	@FXML
	private Label funcao;
	@FXML
	private Button deleteBtn;

	private void voltarAoMenuPrincipal() {
		// Go back to main screen

		Parent telaInicial = null;
		try {
			telaInicial = (Parent) new FXMLLoader(getClass().getResource("sample.fxml")).load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Main.getPrimaryStage().setTitle("Tela Principal");
		Main.getPrimaryStage().setScene(new Scene(telaInicial, 200, 200));
		Main.getPrimaryStage().show();
	}

//	@FXML
//	private void deleteCell(ActionEvent event){
//		getListView().getItems().remove(getItem());
//
//		if (getListView().getItems().size() == 0) {
//			voltarAoMenuPrincipal();
//		}
//	}
	
	@FXML
	public void initialize(){
		deleteBtn.setOnAction(event -> {getListView().getItems().remove(getItem());
		if (getListView().getItems().size() == 0){
			voltarAoMenuPrincipal();
		}
		});
	}

	@Override
	protected void updateItem(Person item, boolean empty) {
		super.updateItem(item, empty);
		if (item != null) {
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Cell.fxml"));
			fxmlLoader.setController(this);
			try {
				fxmlLoader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}

			nome.setText(item.getName());
			idade.setText(item.getIdade());
			funcao.setText(item.getJob());
			setGraphic(hBox);
		} else {
			setGraphic(null);
		}
	}
}
