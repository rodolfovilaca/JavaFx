import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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

	public static void addList(Person person) {
		if (person != null) {
			listaFuncionarios.add(person);
		}
		saveToFileAsCharacter();
	}
	
	public static void saveToFileAsObject(){
		
	}
	
	public static void saveToFileAsBinary(){
		
	}
	
	public static void saveToFileAsCharacter(){
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("lista.txt"))) {
			for (Person p : listaFuncionarios) {
				writer.write(p.getName() + " , " + p.getIdade() + " , " + p.getJob() + "\r\n");
			}
		} catch (IOException e) {
			System.out.println("IOException " + e.getMessage());
		}
	}

	public void setListView() {

		listaFunc.setItems(listaFuncionarios);

		listaFunc.setCellFactory(cell -> new ListViewCell());
		
//		listaFunc.setCellFactory(new Callback<ListView<Person>, javafx.scene.control.ListCell<Person>>() {
//			@Override
//			public ListCell<Person> call(ListView<Person> listView) {
//				return new ListViewCell();
//			}
//		});
	}

	@FXML
	public void initialize() {
		setListView();
	}
}
