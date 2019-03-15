package tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Generator {

	private static List<String> letras_maiusculas = Arrays.asList("A","B","C","D","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
	private static List<String> letras_minusculas = letras_maiusculas.stream().map(String::toLowerCase).collect(Collectors.toList());
	private static List<String> numbers = Arrays.asList("1","2","3","4","5","6","7","8","9","0");
	private static List<String> caracters = Arrays.asList("/",".",",","|",")","(","'","#","@","!","$","%","&","*");
	
	private static Random rd = new Random();
			
	public static ObservableList<String> GeneratorAll(int passwords, int caracter) {
		ObservableList<String> pass = FXCollections.observableArrayList();
		
		for(int i = 0; i < passwords; i++) {
			StringBuilder montar = new StringBuilder();
			for(int i2 = 0; i2 < caracter; i2++) {
				int num1 = 1 + Math.round(rd.nextInt(4));
				switch(num1) {
				case 1:
					montar.append(letras_maiusculas.get(Math.round(rd.nextInt(letras_maiusculas.size()))));
					break;
				case 2:
					montar.append(letras_minusculas.get(Math.round(rd.nextInt(letras_minusculas.size()))));
					break;
				case 3:
					montar.append(numbers.get(Math.round(rd.nextInt(numbers.size()))));
					break;
				case 4:
					montar.append(caracters.get(Math.round(rd.nextInt(caracters.size()))));
					break;
				}
			}
			pass.add(montar.toString());
		}				
		return pass;
	}
	
	public static ObservableList<String> GeneratorSet(int g1, int g2, int g3, int g4, int passwords, int caracter){
		ObservableList<String> pass = FXCollections.observableArrayList();
		
		List<Integer> part = new ArrayList<Integer>();
		
		if(g1 == 1)part.add(1);
		if(g2 == 1)part.add(2);
		if(g3 == 1)part.add(3);
		if(g4 == 1)part.add(4);
		
		for(int i = 0; i < passwords; i++) {
			StringBuilder montar = new StringBuilder();
			for(int i2 = 0; i2 < caracter; i2++) {
				int num1 = Math.round(rd.nextInt(part.size()));
				int num2 = part.get(num1);
				switch(num2) {
				case 1:
					montar.append(letras_maiusculas.get(Math.round(rd.nextInt(letras_maiusculas.size()))));
					break;
				case 2:
					montar.append(letras_minusculas.get(Math.round(rd.nextInt(letras_minusculas.size()))));
					break;
				case 3:
					montar.append(numbers.get(Math.round(rd.nextInt(numbers.size()))));
					break;
				case 4:
					montar.append(caracters.get(Math.round(rd.nextInt(caracters.size()))));
					break;				
				}
			}
			pass.add(montar.toString());
		}		
		
		return pass;
	}
	
}
