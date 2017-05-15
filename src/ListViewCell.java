
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;


public class ListViewCell extends ListCell<Person> {
	private ListView<Person> listaFunc;
	
	public ListViewCell(ListView<Person> listView) {
		listaFunc = listView;
	}

	@Override
	protected void updateItem(Person item, boolean empty) {
		super.updateItem(item, empty);
		if (item != null) {
			System.out.println(item.getName());
			Data data = new Data(listaFunc);
            data.setInfo(item);
            setGraphic(data.getBox());
		}
	}
}
