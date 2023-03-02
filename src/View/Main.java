package View;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controller.RedesController;

public class Main {

	public static void main(String[] args) {

		RedesController RC = new RedesController();
		
		JFrame popup = new JFrame ();

		int n = 0;
		String process = "";
		
		do {
			n = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione uma opção: \n 1 - Consultar o Sistema Operacional \n 2 - Consultar o IP \n 3 - Consultar o ping médio (URL www.google.com.br)\n 9 - Finalizar"));
			switch(n) {
				case 1 :
					JOptionPane.showMessageDialog(popup, "O Sistema Operacional desta máquina é o "+RC.getOS());
					break;
				case 2 :
					JOptionPane.showMessageDialog(popup, "Dê 'ok' e verifique o Console :)");
					RC.ip(process);
					break;
				case 3 :
					JOptionPane.showMessageDialog(popup, "Dê 'ok', este processo pode levar até 10 segundos :)");
					RC.ping(process);
					break;
				case 9 :
					JOptionPane.showMessageDialog(popup, "Fim.");
					System.exit(0);
				default :
					JOptionPane.showMessageDialog(popup, "Opção inválida! Opções válidas: 1, 2, 3 ou 9.");
					break;
			}
		}while(n != 9);
		
		
		
	}

}
