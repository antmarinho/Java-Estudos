package swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Observador {
	
	public static void main(String[] args) {
		
		JFrame janela = new JFrame("Observador");
		
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setSize(600, 200);
		janela.setLayout(new FlowLayout());
		janela.setLocationRelativeTo(null); //centraliza na tela
		
		JButton botao = new JButton("Clicar");
		janela.add(botao);
		
		botao.addActionListener(e -> {
			
			System.out.println("evento ocorreu");
			
		});

		
		janela.setVisible(true);
		
	}

}
