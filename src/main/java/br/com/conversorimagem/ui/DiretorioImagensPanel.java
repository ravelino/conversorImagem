package br.com.conversorimagem.ui;

import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;

public class DiretorioImagensPanel extends Panel {

	private static final long serialVersionUID = 6054147438015884106L;

	private JFileChooser chooser;
	
	private static final String BARRA = System.getProperty("file.separator");
	
	private static int CONTADOR = 1;
	
	public DiretorioImagensPanel(){
		
		chooser = new JFileChooser(); 
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Escolha o dietorio das imagens");
	    //chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    
	    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
	    	CONTADOR = 1;
	    	System.out.println(chooser.getSelectedFile());
	    	System.out.println(chooser.getCurrentDirectory());
	    	
	    	for (File file : getDirectory().listFiles()){
	    		converteImagem(file.toString());
	    	}
		}
		
	}

	public JFileChooser getChooser() {
		return chooser;
	}
	
	private void converteImagem(String pathFile){
		try {
			BufferedImage imgOriginal = ImageIO.read(new File(pathFile));
			BufferedImage scaledImage = Scalr.resize(imgOriginal, Method.QUALITY, 800, 600);
			ImageIO.write(scaledImage, "JPG" , new File( getDirectory().toString() + BARRA + "imagem" + CONTADOR++ + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private File getDirectory(){
		File arquioOuDiretorio = new File(chooser.getSelectedFile().toString());
		return arquioOuDiretorio.isDirectory() ? chooser.getSelectedFile() : chooser.getCurrentDirectory();
	}
}