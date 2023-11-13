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
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TelaTimeThread extends JDialog {
	
	private JPanel jp = new JPanel(new GridBagLayout());
	
	private JLabel descricao = new JLabel("Time Thread 1");
	private JTextField mostraTempo = new JTextField();
	
	private JLabel descricao2 = new JLabel("Time Thread 2");
	private JTextField mostraTempo2 = new JTextField();
	
	private JButton jb = new JButton("Start");
	private JButton jbs = new JButton("Stop");
	
	private Thread tt;
	private Thread tt2;
	
	private Runnable thread1 = new Runnable() {
		
		@Override
		public void run() {
			
			while(true) {
				
				mostraTempo.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss").format(Calendar.getInstance().getTime()));
				
				try {
					
					Thread.sleep(1000);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				
			}
			
		}
		
	};
	
	private Runnable thread2 = new Runnable() {
		
		@Override
		public void run() {
			
			while(true) {
				
				mostraTempo2.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(Calendar.getInstance().getTime()));
				
				try {
					
					Thread.sleep(1000);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				
			}
			
		}
		
	};
	
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
		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				tt = new Thread(thread1);
				tt.start();
				
				tt2 = new Thread(thread2);
				tt2.start();
				
				jb.setEnabled(false);
				jbs.setEnabled(true);
				
			}
		});
		
		jbs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				tt.stop();
				tt2.stop();
				
				jb.setEnabled(true);
				jbs.setEnabled(false);
				
			}
		});
		
		jbs.setEnabled(false);
		
		add(jp,BorderLayout.WEST);
		
		setVisible(true);
		
	}

}
