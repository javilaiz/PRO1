package Paneles;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Bonoloto {
	private static JLabel labelCombGanadora, labelReintGanador, labelComb, labelReint, labelAciertos, labelAciertoReint,
			labelPremio, labelPremioReint;
	private static JPanel pBono, pUser, pWinner;
	static ArrayList<Integer> combinacion = new ArrayList<>();
	static ArrayList<Integer> combinacionGanadora = new ArrayList<>();
	static int reintegro;
	static int reintegroFinal;
	static int aciertos;
	static double premio;
	static boolean aciertoReint = false;

	public static void main(String[] args) {

		JFrame Frame = new JFrame("Bonoloto");
		Frame.setLayout(new BorderLayout());

		pBono = new JPanel(new GridLayout(2, 0));
		pWinner = new JPanel(new GridLayout(2, 2));
		pUser = new JPanel(new GridLayout(2, 0));

		Frame.add(pBono, BorderLayout.NORTH);
		Frame.add(pWinner, BorderLayout.SOUTH);
		Frame.add(pUser, BorderLayout.WEST);

		Usuario();
		CreadorBonoloto();
		Comparador();
		Premios();
		InicializaLabel();

		pBono.add(labelCombGanadora);
		pBono.add(labelReintGanador);
		pUser.add(labelComb);
		pUser.add(labelReint);
		pWinner.add(labelAciertos);
		pWinner.add(labelPremio);
		pWinner.add(labelAciertoReint);
		pWinner.add(labelPremioReint);
		Frame.pack();
		Frame.setVisible(true);

	}

	private static void Premios() {
		switch (aciertos) {
		case 0:
			premio = 0;
			break;
		case 1:
			premio = 1.5;
			break;
		case 2:
			premio = 3;
			break;
		case 3:
			premio = 6.5;
			break;
		case 4:
			premio = 1025.16;
			break;
		case 5:
			premio = 159800.50;
			break;
		case 6:
			premio = 200150.25;
		}

	}

	private static void Comparador() {
		for (int i = 0; i < combinacionGanadora.size(); i++) {

			for (int e = 0; e < combinacion.size(); e++) {
				if (combinacionGanadora.get(i) == combinacion.get(e)) {
					aciertos++;
				}
			}
		}
		if (reintegro == reintegroFinal) {
			aciertoReint = true;
		}

	}

	private static void CreadorBonoloto() {

		do {
			reintegroFinal = (int) (Math.random() * 9);
		} while (reintegroFinal == 0);

		for (int i = 0; i < 6; i++) {

			int numero = (int) (Math.random() * 49);
			combinacionGanadora.add(numero);

		}
	}

	private static void Usuario() {
		for (int i = 0; i < 6; i++) {
			combinacion.add(Integer.parseInt(JOptionPane.showInputDialog("Introduzca los números uno a uno")));
		}
		reintegro = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el reintegro"));
	}

	private static void InicializaLabel() {

		labelCombGanadora = new JLabel("La combinación es: " + combinacionGanadora);
		labelReintGanador = new JLabel("El reintrgro es: " + reintegroFinal);
		labelComb = new JLabel("Su combinación ha sido: " + combinacion);
		labelReint = new JLabel("Su reintegro ha sido: " + reintegro);
		labelAciertos = new JLabel("Número de aciertos: " + aciertos);
		labelPremio = new JLabel("Su premio es de: " + premio + " euros");
		if (aciertoReint) {
			labelAciertoReint = new JLabel("Ha acertado el reintegro");
			labelPremioReint = new JLabel("Su premio por el reintegro es de 2 euros");
		} else {
			labelAciertoReint = new JLabel("No ha acertado el reintegro");
			labelPremioReint = new JLabel("");
		}

	}

}
