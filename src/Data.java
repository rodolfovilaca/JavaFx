
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class Data {
	
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

	private ListView<Person> listaFunc;
	
	@FXML
	public void deleteCell(){
	int index;
	index = listaFunc.getSelectionModel().getSelectedIndex();
	System.out.println("deleteCell()");
	ListViewController.removeFromList(index);
	//listaFunc.getItems().remove(index);
	listaFunc.refresh();
	}

	public Data(ListView<Person> listView){
		listaFunc = listView;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Cell.fxml"));
        fxmlLoader.setController(this);
        try
        {
            fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
	}
	public void setInfo(Person person)
    {
		nome.setText(person.getName());
		idade.setText(person.getIdade());
		funcao.setText(person.getJob());
    }

    public HBox getBox()
    {
        return hBox;
    }
}
