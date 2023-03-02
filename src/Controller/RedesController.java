package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RedesController {
	public RedesController(){
		super();
	}
	
	private String os = System.getProperty("os.name");

	public String getOS() {
		return os;
	}
	
	public void ip(String process) {
		
		String ip;
		if(os.contains("Windows")) {
			ip = "ipconfig";
			callProcess(ip);
			
		}
		else {
				ip = "ifconfig";
				callProcess(ip);
				}
	}
	
	public void ping(String process) {
		
		String ping;
		if(os.contains("Windows")) {
			ping = "PING -4 -n 10 www.google.com.br";
			callProcess(ping);
			
		}
		else {
				ping = "PING -4 -c 10 www.google.com.br";
				callProcess(ping);
				}
	}

	public void listaProcessos(String process) {
		
		String processlist;
		if(os.contains("Windows")) {
			processlist = "TASKLIST /FO TABLE";
			callProcess(processlist);
			
		}
		else {
			processlist = "ps -ef";
				callProcess(processlist);
		}
	}
	
	public void mataPid(int param) {
		String windows = "TASKKILL /PID";
		String linux = "kill -9";
		int pid = 0;
		
		StringBuffer buffer = new StringBuffer();
		
		if(os.contains("Windows")) {
			pid = (param);
			buffer.append(windows);
			buffer.append(" ");
			buffer.append(pid);
		
		callProcess(buffer.toString());
			
		}
		else {
			pid = (param);
			buffer.append(linux);
			buffer.append(" ");
			buffer.append(pid);
		
		callProcess(buffer.toString());
		}
		
			
	}
	
	public void mataNome(String param) {
		String windows = "TASKKILL /IM";
		String linux = "pkill -f";
		
		StringBuffer buffer = new StringBuffer();
		
		if(os.contains("Windows")) {
			
			buffer.append(windows);
			buffer.append(" ");
			buffer.append(param);
		
		callProcess(buffer.toString());
			
		}
		else {
			buffer.append(linux);
			buffer.append(" ");
			buffer.append(param);
		
		callProcess(buffer.toString());
		}
	}
	
	public void callProcess(String process) {
		JFrame popup = new JFrame ();
		try {
			
			Process p = Runtime.getRuntime().exec(process);
			
		
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				if(process.contains("PING")) {
					String[] pm1 = linha.split("ms,");
					for (String pm2 : pm1) {
						if(pm2.contains("M�dia")) {
							JOptionPane.showMessageDialog(popup,"Resultado "+ pm2);
						}
						else{
							System.out.print("");
						}
					}
					
					linha = buffer.readLine();
				}
				else {
				System.out.println(linha);
				
				linha = buffer.readLine();
			
				}
			}
				
			buffer.close();
			fluxo.close();
			leitor.close();
		} catch (IOException e) {
			String msgErr = e.getMessage();
			System.err.println(msgErr);
		}
	}
		
}


