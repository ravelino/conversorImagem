package br.com.conversorimagem.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Main extends JFrame {
	
	private static final long serialVersionUID = -6077502405709769621L;

	private JPanel panel;
	
	private JButton escolherArquivo;
	
	private final Container container = getContentPane();
	
	
	public Main() {
		super("Conversor de Imagens");
		initEcolherArquivo();
	}
	
	private void initEcolherArquivo(){
		escolherArquivo = new JButton("Escolher Pasta das Imagens");
		escolherArquivo.setSize(250, 30);
		escolherArquivo.setLocation(20, 20);
		
		escolherArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DiretorioImagensPanel pDiretorioImagensUI = new DiretorioImagensPanel();
				container.add(pDiretorioImagensUI);
			}
		});
	}
	
	public void init(){
		
		try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());} catch (Exception e) {}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		panel.add(escolherArquivo);
		
		container.add(panel);
		setSize(500, 350);
		setVisible(Boolean.TRUE);
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.init();
	}

}
