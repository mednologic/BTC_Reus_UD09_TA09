/*
 * @author:		Josep Oriol L�pez Bosch / 	David Dalmau Dieguez / Octavio Bernal Vilana
 * @fecha:		16/04/2022
 * @versi�n:	0.0.2
 */

package Class;

public class LavadoraClass extends ElectrodomesticoClass {
	// Atributos de clase
	private double carga;
	private double plusConsumoEnergetico = 0;

	// Constantes por defecto
	private static final double CARGAF = 5;

	// Constructor con valores por defecto.
	public LavadoraClass() {
		this.carga = CARGAF;
	}

	// Constructor con atributos a definir y atributos por defecto.
	public LavadoraClass(double precioBase, double peso) {
		super(precioBase, peso);
		this.carga = CARGAF;
	}

	// Constructor completo.
	public LavadoraClass(double precioBase, String color, char consumo, double peso, double carga) {
		super(precioBase, color, consumo, peso);
		this.carga = carga;
		precioFinal();
	}

	// Getters y setters
	public double getCarga() {
		return carga;
	}

	public void setCarga(double carga) {
		this.carga = carga;
	}

	/*
	 * M�todo comprobarColor() valida que el color seleccionado est� dentro del
	 * rango de colores.
	 */
	@Override
	public String comprobarColor(String color) {
		String colorCorrecto = COLORF;
		String[] colores = { "blanco", "negro", "rojo", "azul", "gris" };

		for (int i = 0; i < colores.length; i++) {
			if (color.toLowerCase().equals(colores[i])) {
				colorCorrecto = color;
			} else {

			}
		}
		return colorCorrecto;
	}

	// M�todo para comprobar la eficiencia energ�tica , mediante la letra
	// correspondiente incrementaremos el precio final del producto.
	@Override
	public char comprobarConsumoEnergetico(char letra) {
		char letraCorrecta = CONSUMOF;
		char[] letras = { 'A', 'B', 'C', 'D', 'E', 'F' };

		for (int i = 0; i < letras.length; i++) {
			if (letra == letras[i]) {
				letraCorrecta = letra;
			}
		}
		return letraCorrecta;
	}

	// Calculamos los pluses seg�n la carga y el consumo energ�tico.
	// Sumamos los pluses al precioBase y obtenemos el precioTotal.
	public double precioFinal() {
		double precioTotal = 0;
		double plusCarga = 0;

		if (carga > 30) {
			plusCarga = precioBase * 1.50;
		}

		// Seg�n el consumo de la lavadora incrementaremos el precio del plus.
		if (consumo == 'A') {
			plusConsumoEnergetico += 100;
		} else if (consumo == 'B') {
			plusConsumoEnergetico += 80;
		} else if (consumo == 'C') {
			plusConsumoEnergetico += 60;
		} else if (consumo == 'D') {
			plusConsumoEnergetico += 50;
		} else if (consumo == 'E') {
			plusConsumoEnergetico += 30;
		} else if (consumo == 'F') {
			plusConsumoEnergetico += 10;
		}

		precioTotal = plusConsumoEnergetico + plusCarga + precioBase;

		return precioTotal;
	}

	// Generamos el m�todo toString para dar formato al texto generado.
	@Override
	public String toString() {
		return "LavadoraClass [carga=" + carga + ",  precioBase=" + precioBase + ", color=" + color + ", consumo="
				+ consumo + ", peso=" + peso + "]";
	}

}
