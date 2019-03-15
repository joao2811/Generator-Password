package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import tools.Generator;

public class ViewController implements Initializable {

	@FXML
	private Spinner<Integer> num1, num2;
	
	@FXML
	private Button bt1;
	
	@FXML
	private CheckBox check1, check2, check3;
	
	@FXML
	private RadioButton rd1, rd2;
	
	@FXML
	private ListView<String> list1;
	
	@FXML
	public void onRd1Action() {
		rd2.setSelected(false);
	}
	
	@FXML
	public void onRd2Action() {
		rd1.setSelected(false);
	}
	
	@FXML
	public void onCheck1Action() {
		if(check1.isSelected() == true) {
			rd1.setDisable(false);
			rd2.setDisable(false);
		}
		else {
			rd1.setDisable(true);
			rd2.setDisable(true);
		}
	}
	
	@FXML
	public void onBt1Action() {
		if(check1.isSelected() == false && check2.isSelected() == false && check3.isSelected() == false) {
			JOptionPane.showMessageDialog(null, "Please Selected At Leasts One Of The Fields!!!","Error",JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if(check1.isSelected() == true && check2.isSelected() == true && check3.isSelected() == true && rd1.isSelected() == false && rd2.isSelected() == false)
			list1.setItems(Generator.GeneratorAll(num2.getValue(), num1.getValue()));
		else
			list1.setItems(
			Generator.GeneratorSet(
			(rd1.isSelected() == true && rd2.isSelected() == false || check1.isSelected() == true ? 1 : 0),
		    (rd2.isSelected() == true && rd1.isSelected() == false || check1.isSelected() == true ? 1 : 0), 
		    (check2.isSelected() == true ? 1 : 0),
		    (check3.isSelected() == true ? 1 : 0),
		     num2.getValue(), num1.getValue()));
		JOptionPane.showMessageDialog(null, "Passwords generated successfully!!!","Sucess",JOptionPane.INFORMATION_MESSAGE);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Configurations.setSpinnerInteger(num1);
		Configurations.setSpinnerInteger(num2);
		Configurations.setListViewFont(list1);
	}
}
