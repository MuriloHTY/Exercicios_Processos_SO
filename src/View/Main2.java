package View;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controller.RedesController;

public class Main2 {

	public static void main(String[] args) {

		RedesController RC = new RedesController();
		
		JFrame popup = new JFrame ();

		int n = 0;
		String process = "";
		int processP;
		
		do {
			n = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione uma opção: \n 1 - Consultar o Sistema Operacional \n 2 - Mostrar a lista de Processos Ativos \n 3 - Matar um Processo pelo PID \n 4 - Matar um Processo pelo Nome \n 9 - Finalizar"));
			switch(n) {
				case 1 :
					JOptionPane.showMessageDialog(popup, "O Sistema Operacional desta máquina é o "+RC.getOS());
					break;
				case 2 :
					JOptionPane.showMessageDialog(popup, "Dê 'ok' e verifique o Console :)");
					RC.listaProcessos(process);
					break;
				case 3 :
					processP = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o PID do processo que deseja finalizar:"));
					RC.mataPid(processP);
					JOptionPane.showMessageDialog(popup, "Processo Finalizado.");
					break;
				case 4 :
					process = (JOptionPane.showInputDialog(null, "Insira o Nome do processo que deseja finalizar:"));
					RC.mataNome(process);
					JOptionPane.showMessageDialog(popup, "Processo Finalizado.");
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
