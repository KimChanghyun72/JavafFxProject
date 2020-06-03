package view_pack;

import javafx.beans.property.SimpleStringProperty;
//5개를 입력받는 생성자, get/set/simplestringproperty, return값등을 사용해 board를 완성해서 오기.
public class Board {
	private SimpleStringProperty title;
	private SimpleStringProperty password;
	private SimpleStringProperty publicity;
	private SimpleStringProperty exitDate;
	private SimpleStringProperty content;
	
	Board(String title){
		this.title = new SimpleStringProperty(title);
//		this.password = new SimpleStringProperty(password);
//		this.publicity = new SimpleStringProperty(publicity);
//		this.exitDate = new SimpleStringProperty(exitDate);
//		this.content = new SimpleStringProperty(content);
	}

	public String getTitle() {
		return this.title.get();
	}

	public void setTitle(String title) {
		this.title.set(title);
	}
	public SimpleStringProperty titleProperty() {
		return this.title;
	}

	public SimpleStringProperty getPassword() {
		return password;
	}

	public void setPassword(SimpleStringProperty password) {
		this.password = password;
	}

	public SimpleStringProperty getPublicity() {
		return publicity;
	}

	public void setPublicity(SimpleStringProperty publicity) {
		this.publicity = publicity;
	}

	public SimpleStringProperty getExitDate() {
		return exitDate;
	}

	public void setExitDate(SimpleStringProperty exitDate) {
		this.exitDate = exitDate;
	}

	public SimpleStringProperty getContent() {
		return content;
	}

	public void setContent(SimpleStringProperty content) {
		this.content = content;
	}
	
	
}
