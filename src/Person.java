import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Person {
	private String name;
	private String idade;
	private String job;

	
	public Person(String name, String idade,String job){
		this.name = name;
		this.idade = idade;
		this.job = job;
	}
	
	
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "nome: "+name+" idade: "+idade+" função: "+job;
	}
	
}
