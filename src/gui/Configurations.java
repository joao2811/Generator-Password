package gui;

import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class Configurations {

	@SuppressWarnings("unchecked")
	public static void setSpinnerInteger(@SuppressWarnings("rawtypes") Spinner spin) {
		SpinnerValueFactory<Integer> value = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
		spin.setValueFactory(value);
		spin.setStyle("-fx-font-family: 'News706 BT';");
	}
	
	public static void setListViewFont(@SuppressWarnings("rawtypes") ListView ListView) {
		ListView.setStyle("-fx-font-family: 'News706 BT'");
	}
	
}
