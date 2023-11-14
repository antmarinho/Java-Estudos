package thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaThread extends JDialog {
	
	private JPanel jp = new JPanel(new GridBagLayout());
	
	private JLabel descricao = new JLabel("Nome");
	private JTextField mostraTempo = new JTextField();
	
	private JLabel descricao2 = new JLabel("E-mail");
	private JTextField mostraTempo2 = new JTextField();
	
	private JButton jb = new JButton("Add lista");
	private JButton jbs = new JButton("Stop");

	private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();
	
	public TelaThread() {
		
		setTitle("Time com Thread");
		setSize(new Dimension(240,240));
		setLocationRelativeTo(null);
		setResizable(false);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(5,10,5,5);
		gbc.anchor = GridBagConstraints.WEST;
		
		descricao.setPreferredSize(new Dimension(200,25));
		jp.add(descricao,gbc);
		
		gbc.gridy++;
		mostraTempo.setPreferredSize(new Dimension(200,25));
		jp.add(mostraTempo,gbc);
		
		gbc.gridy++;
		descricao2.setPreferredSize(new Dimension(200,25));
		jp.add(descricao2,gbc);
		
		gbc.gridy++;
		mostraTempo2.setPreferredSize(new Dimension(200,25));
		jp.add(mostraTempo2,gbc);
		
		gbc.gridwidth = 1;
		
		gbc.gridy++;
		jb.setPreferredSize(new Dimension(92,25));
		jp.add(jb,gbc);
		
		gbc.gridx++;
		jbs.setPreferredSize(new Dimension(92,25));
		jp.add(jbs,gbc);
		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(fila == null) {
					
					fila.start();
					
				}
				
				for(int i = 0; i < 100; i++) { //simulando 100 envios
				
					ObjetoFilaThread ob = new ObjetoFilaThread();
				
					ob.setNome(mostraTempo.getText());
					ob.setEmail(mostraTempo2.getText());
				
					fila.add(ob);
				}
				
			}
		});
		
		jbs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				fila.stop();
				fila = null;
				
			}
		});
		
		fila.start();
		
		add(jp,BorderLayout.WEST);
		
		setVisible(true);
		
	}

}

