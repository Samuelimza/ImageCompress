import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Screen {

	public int width;
	public int height;
	public int[] pixels;

	public Screen(int width, int height) {
		pixels = new int[width * height];
		//try{
		//	InputStream in = getClass().getResourceAsStream("/model.csv");
		//	BufferedReader br = new BufferedReader(new InputStreamReader(in));
		//	String s = "";
		//	int counter = 0;
		//	while((s = br.readLine()) != null){
		//		//extract by br.readLine(); Split by String.split() on commas
		//		counter++;
		//	}
		//	
		//}catch(IOException ex){
		//	
		//}
		
	}
	

	public void render() {
		for(int i = 0; i < this.width; i++){
			for(int j = 0; j < this.height; j++){
				
			}
		}
	}
	
	public void update() {
		
	}
	
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	  
	public void save(){
		//JPanel dPanel;
	    //BufferedImage bImg = new BufferedImage(dPanel.getWidth(), dPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
	    //Graphics2D cg = bImg.createGraphics();
	    //dPanel.paintAll(cg);
	    //try {
	    //        if (ImageIO.write(bImg, "png", new File("./output_image.png")))
	    //        {
	    //            System.out.println("-- saved");
	    //        }
	    //} catch (IOException e) {
	    //       // TODO Auto-generated catch block
	    //        e.printStackTrace();
	    //}
	}
}
