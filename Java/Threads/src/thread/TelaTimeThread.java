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

public class TelaTimeThread extends JDialog {
	
	private JPanel jp = new JPanel(new GridBagLayout());
	
	private JLabel descricao = new JLabel("Time Thread 1");
	private JTextField mostraTempo = new JTextField();
	
	private JLabel descricao2 = new JLabel("Time Thread 2");
	private JTextField mostraTempo2 = new JTextField();
	
	private JButton jb = new JButton("Start");
	private JButton jbs = new JButton("Stop");
	
	public TelaTimeThread() {
		
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
		mostraTempo.setEditable(false);
		jp.add(mostraTempo,gbc);
		
		gbc.gridy++;
		descricao2.setPreferredSize(new Dimension(200,25));
		jp.add(descricao2,gbc);
		
		gbc.gridy++;
		mostraTempo2.setPreferredSize(new Dimension(200,25));
		mostraTempo2.setEditable(false);
		jp.add(mostraTempo2,gbc);
		
		gbc.gridwidth = 1;
		
		gbc.gridy++;
		jb.setPreferredSize(new Dimension(92,25));
		jp.add(jb,gbc);
		
		gbc.gridx++;
		jbs.setPreferredSize(new Dimension(92,25));
		jp.add(jbs,gbc);
		
		add(jp,BorderLayout.WEST);
		
		setVisible(true);
		
	}

}
