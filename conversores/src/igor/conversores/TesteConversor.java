package igor.conversores;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class TesteConversor {

	public static void main(String[] args) {
		boolean start = true;
		while (start) {
			// Usuário escolhe a opção de conversor de sua preferência
			Object[] menu = { "Conversor de Moeda", "Conversor de Temperatura" };
			Object selectedMenu = JOptionPane.showInputDialog(null, "Escolha um item", "Menu",
					JOptionPane.INFORMATION_MESSAGE, null, menu, menu[0]);
			// Usuário escolha a opção de moeda ou escala termométrica que deseja
			Object selectedOptions = chooseConverterOption(selectedMenu);

			// Tratamento de erro

			try {
				// Input de valor para conversão
				Double inputValue = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor:"));

				// Output do resultado da conversão

				Double outputValue = convert(inputValue, selectedOptions);
				String formatOutputValue = convertDoubleString(outputValue);
				String currencySimbol = currencySymbols(selectedOptions, formatOutputValue);

				JOptionPane.showMessageDialog(null, "O valor da conversão é de " + currencySimbol);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "O valor não é válido!");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Programa concluído!");
			}

			// Deseja continuar?
			Object desejaContinuar = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Select an Option",
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (desejaContinuar.equals(1)) {
				start = false;
				JOptionPane.showMessageDialog(null, "Programa finalizado!");
			}
			if (desejaContinuar.equals(2)) {
				start = false;
				JOptionPane.showMessageDialog(null, "Programa concluído!");
			}
		}
	}

	public static Object chooseConverterOption(Object selectedMenu) {

		Object selectedOptions;
		if (selectedMenu.equals("Conversor de Moeda")) {

			// Em caso de Conversor de Moeda
			Object[] coinsOptions = { "Converter de Reais a Dólar", "Converter de Reais a Euro",
					"Converter de Reais a Libras Esterlinas", "Converter de Reais a Peso argentino",
					"Converter de Reais a Peso Chileno", "Converter de Dólar a Reais", "Converter de Euro a Reais",
					"Converter de Libras Esterlinas a Reais", "Converter de Peso argentino a  Reais",
					"Converter de Peso Chileno a Reais" };

			Object selectedCoinsOptions = JOptionPane.showInputDialog(null,
					"Escolha a moeda a qual deseja cambiar seu dinheiro", "Moedas", JOptionPane.INFORMATION_MESSAGE,
					null, coinsOptions, coinsOptions[0]);
			selectedOptions = selectedCoinsOptions;
		} else {
			// Em caso de Conversor de Temperatura

			Object[] temperatureOptions = { "Converter de Celsius a Fahrenheit", "Converter de Celsius a Kelvin",
					"Converter de Fahrenheit a Celsius", "Converter de Fahrenheit a Kelvin",
					"Converter de Kelvin a Celsius", "Converter de Kelvin a Fahrenheit" };

			Object selectedTemperatureOptions = JOptionPane.showInputDialog(null,
					"Escolha a escala termométrica a qual deseja cambiar a temperatura", "Escalas Termométricas",
					JOptionPane.INFORMATION_MESSAGE, null, temperatureOptions, temperatureOptions[0]);

			selectedOptions = selectedTemperatureOptions;
		}
		return selectedOptions;

	}

	public static double convert(Double inDouble, Object selectedOptions) {
		double outValue = 0;
		// Cotação do dia 15/08
		double dolar = 5.10;
		double euro = 5.18;
		double libra = 6.15;
		double pesoArgentino = 0.038;
		double pesoChileno = 0.0058;

		// Opções de Conversores de moeda
		if (selectedOptions.equals("Converter de Reais a Dólar"))
			outValue = inDouble / dolar;
		if (selectedOptions.equals("Converter de Reais a Euro"))
			outValue = inDouble / euro;
		if (selectedOptions.equals("Converter de Reais a Libras Esterlinas"))
			outValue = inDouble / libra;
		if (selectedOptions.equals("Converter de Reais a Peso argentino"))
			outValue = inDouble / pesoArgentino;
		if (selectedOptions.equals("Converter de Reais a Peso Chileno"))
			outValue = inDouble / pesoChileno;
		if (selectedOptions.equals("Converter de Dólar a Reais"))
			outValue = inDouble * dolar;
		if (selectedOptions.equals("Converter de Euro a Reais"))
			outValue = inDouble * euro;
		if (selectedOptions.equals("Converter de Libras Esterlinas a Reais"))
			outValue = inDouble * libra;
		if (selectedOptions.equals("Converter de Peso argentino a  Reais"))
			outValue = inDouble * pesoArgentino;
		if (selectedOptions.equals("Converter de Peso Chileno a Reais"))
			outValue = inDouble * pesoChileno;

		// Opções de conversores de escalas termométricas
		if (selectedOptions.equals("Converter de Celsius a Fahrenheit"))
			outValue = ((9 * inDouble) / 5) + 32;
		if (selectedOptions.equals("Converter de Celsius a Kelvin"))
			outValue = inDouble + 273.15;
		if (selectedOptions.equals("Converter de Fahrenheit a Celsius"))
			outValue = 5 * ((inDouble - 32) / 9);
		if (selectedOptions.equals("Converter de Fahrenheit a Kelvin"))
			outValue = 5 * ((inDouble - 32) / 9) + 273.15;
		if (selectedOptions.equals("Converter de Kelvin a Celsius"))
			outValue = inDouble - 273.15;
		if (selectedOptions.equals("Converter de Kelvin a Fahrenheit"))
			outValue = ((9 * (inDouble - 273.15)) / 5) + 32;
		;
		return outValue;

	}

	public static String currencySymbols(Object selectedOptions, String formatOutputValue) {
		String outSymbol = null;
		// Símbolos monetários
		String dolar = "US$ ";
		String euro = "€";
		String libra = "£ ";
		String peso = "$ ";
		String real = "R$ ";

		// escalas termométricas
		String celsius = "° C";
		String fahreinheit = "° F";
		String kelvin = " K";

		// Opções de Conversores de moeda
		if (selectedOptions.equals("Converter de Reais a Dólar"))
			outSymbol = dolar + formatOutputValue;
		if (selectedOptions.equals("Converter de Reais a Euro"))
			outSymbol = formatOutputValue + euro;
		if (selectedOptions.equals("Converter de Reais a Libras Esterlinas"))
			outSymbol = libra + formatOutputValue;
		if (selectedOptions.equals("Converter de Reais a Peso argentino"))
			outSymbol = peso + formatOutputValue + " ARS";
		if (selectedOptions.equals("Converter de Reais a Peso Chileno"))
			outSymbol = peso + formatOutputValue + " CLP";
		if (selectedOptions.equals("Converter de Dólar a Reais") || selectedOptions.equals("Converter de Euro a Reais")
				|| selectedOptions.equals("Converter de Libras Esterlinas a Reais")
				|| selectedOptions.equals("Converter de Peso argentino a  Reais")
				|| selectedOptions.equals("Converter de Peso Chileno a Reais"))
			outSymbol = real + formatOutputValue;

		// Opções de conversores de escalas termométricas
		if (selectedOptions.equals("Converter de Fahrenheit a Celsius")
				|| selectedOptions.equals("Converter de Kelvin a Celsius"))
			outSymbol = formatOutputValue + celsius;
		if (selectedOptions.equals("Converter de Celsius a Fahrenheit")
				|| selectedOptions.equals("Converter de Kelvin a Fahrenheit"))
			outSymbol = formatOutputValue + fahreinheit;
		if (selectedOptions.equals("Converter de Celsius a Kelvin")
				|| selectedOptions.equals("Converter de Fahrenheit a Kelvin"))
			outSymbol = formatOutputValue + kelvin;
		return outSymbol;
	}

	public static String convertDoubleString(double outputValue) {
		/* Transformando um double em 2 casas decimais */
		DecimalFormat fmt = new DecimalFormat("0.00"); // limita o número de casas decimais
		String string = fmt.format(outputValue);
		// String[] part = string.split("[,]");
		// String formatOutputValue = part[0]+"."+part[1];
		return string;
	}
}
