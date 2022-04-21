
/*
 * @author:		Josep Oriol L�pez Bosch / 	David Dalmau Dieguez / Octavio Bernal Vilana
 * @fecha:		14/04/2022
 * @versi�n:	0.0.2
 */

package Class;

public class TelevisorClass extends ElectrodomesticoClass {

	/* Atributos de clase */
	protected double resolucion;
	protected boolean sintonizador;

	/* Constantes por defecto */
	protected static final double RESOLUCIONF = 20.0;
	protected static final boolean SINTONIZADORF = false;

	/* Constructor por defecto */
	public TelevisorClass() {
		this.resolucion = RESOLUCIONF;
		this.sintonizador = SINTONIZADORF;
	}

	/* Constructor de superclase. */
	public TelevisorClass(double precioBase, double peso) {
		super(precioBase, peso);
		// TODO Auto-generated constructor stub
	}

	/* Constructor de clase con superclase. */
	public TelevisorClass(double precioBase, String color, char consumo, double peso, double resolucion,
			boolean sintonizador) {
		super(precioBase, color, consumo, peso);
		this.resolucion = resolucion;
		this.sintonizador = sintonizador;
		precioFinal();
	}

	/* Getters y setters solo de resoluci�n y sintonizador */
	public double getResolucion() {
		return resolucion;
	}

	public void setResolucion(double resolucion) {
		this.resolucion = resolucion;
	}

	public boolean isSintonizador() {
		return sintonizador;
	}

	public void setSintonizador(boolean sintonizador) {
		this.sintonizador = sintonizador;
	}

	/* M�todo toString() con los atributos de clase y de super clase. */
	@Override
	public String toString() {
		return "TelevisorClass [resolucion=" + resolucion + ", sintonizador=" + sintonizador + ", precioBase="
				+ precioBase + ", color=" + color + ", consumo=" + consumo + ", peso=" + peso + "]";
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

	/* Meto comprobarConsumoEnergetico(), comprueba que la letra es correcta. */
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

	/* M�todo precioFinal exclusivo clase Televisor. */
	public double precioFinal() {

		double plusResolucion = 0;
		double plusPeso = 0;
		double plusConsumo = 0;
		double plusSintonizador = 0;
		double precioTotal = 0;

		/*
		 * Seg�n la resoluci�n de la televisi�n incrementaremos su valor en un 30% o no.
		 */
		if (resolucion > 40) {
			plusResolucion = precioBase * 1.30;
		}

		/* Si la televisi�n dispone de sintonizador incrementaremos su precio en 50� */
		if (sintonizador == true) {
			plusSintonizador += 50;
		}

		/* Seg�n el consumo del electrodom�stico incrementaremos su precio. */
		if (consumo == 'A') {
			plusConsumo += 100;
		} else if (consumo == 'B') {
			plusConsumo += 80;
		} else if (consumo == 'C') {
			plusConsumo += 60;
		} else if (consumo == 'D') {
			plusConsumo += 50;
		} else if (consumo == 'E') {
			plusConsumo += 30;
		} else if (consumo == 'F') {
			plusConsumo += 10;
		}

		/* Seg�n el peso del electrodomestico , incrementaremos su valor */
		if (peso >= 0 && peso <= 19) {
			plusPeso += 10;
		} else if (peso >= 20 && peso <= 49) {
			plusPeso += 50;
		} else if (peso >= 50 && peso <= 79) {
			plusPeso += 80;
		} else if (peso > 80) {
			plusPeso += 100;
		}

		precioTotal = plusConsumo + plusPeso + plusResolucion + plusSintonizador + precioBase;

		return precioTotal;
	}

}
