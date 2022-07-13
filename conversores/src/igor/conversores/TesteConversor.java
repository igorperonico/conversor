package igor.conversores;

import javax.swing.JOptionPane;

public class TesteConversor {

	public static void main(String[] args) {
		Object[] menu = { "Conversor de Moeda", "Conversor de Temperatura" };
		Object selectedMenu = JOptionPane.showInputDialog(null, "Escolha um item", "Menu",
				JOptionPane.INFORMATION_MESSAGE, null, menu, menu[0]);

		Object[] coinsOptions = { "Converter de Reais a Dólar", "Converter de Reais a Euro",
				"Converter de Reais a Libras Esterlinas", "Converter de Reais a Peso argentino",
				"Converter de Reais a Peso Chileno", "Converter de Dólar a Reais", "Converter de Euro a Reais",
				"Converter de Libras Esterlinas a Reais", "Converter de Peso argentino a  Reais",
				"Converter de Peso Chileno a Reais" };

		Object selectedCoinsOptions = JOptionPane.showInputDialog(null, "Escolha a moeda a qual deseja cambiar seu dinheiro", "Moedas",
				JOptionPane.INFORMATION_MESSAGE, null, coinsOptions, coinsOptions[0]);

	}
}
