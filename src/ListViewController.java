import java.util.ArrayList;
import java.util.List;

import com.sun.media.jfxmedia.events.NewFrameEvent;

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
	
//	private List<Person> stringList = new ArrayList<>();
//
//	private ObservableList observableList = FXCollections.observableArrayList();

	public ListViewController() {

	}
	
	public static ObservableList<Person> getList(){
		return listaFuncionarios;
	}
	
	public static void removeFromList(int index){
		System.out.println(index);
		listaFuncionarios.remove(index);
	}
	
	public static void addList(Person person){
		if(person != null){
			listaFuncionarios.add(person);
		}
	}
	
	public ListView<Person> getListView(){
		return listaFunc;
	}

	public void setListView() {
//		stringList = Person.getList();
//
//		observableList.setAll(stringList);

		listaFunc.setItems(listaFuncionarios);

		listaFunc.setCellFactory(new Callback<ListView<Person>, javafx.scene.control.ListCell<Person>>() {
			@Override
			public ListCell<Person> call(ListView<Person> listView) {
				return new ListViewCell(listView);
			}
		});
	}

	@FXML
	public void initialize() {
		System.out.println("listView " + listaFunc);
		assert listaFunc != null : "fx:id=\"listView\" was not injected: check your FXML file 'listview.fxml'.";

		setListView();
	}
}
