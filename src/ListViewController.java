import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ListViewController {
	
	private static ObservableList<Person> listaFuncionarios = FXCollections.observableArrayList();
	
	@FXML
	private ListView<Person> listaFunc;

	public static void addList(Person person){
		if(person != null){
			listaFuncionarios.add(person);
		}
	}

	public void setListView() {

		listaFunc.setItems(listaFuncionarios);

		listaFunc.setCellFactory(new Callback<ListView<Person>, javafx.scene.control.ListCell<Person>>() {
			@Override
			public ListCell<Person> call(ListView<Person> listView) {
				return new ListViewCell();
			}
		});
	}

	@FXML
	public void initialize() {
		setListView();
	}
}
