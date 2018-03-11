import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Manage implements ActionListener {
	private JFrame frame;
	private JLabel label1;
	private JLabel label2;
	private JTextField compressionPath;
	private JButton compress;
	private JTextField decompressionPath;
	private JButton decompress;

	public Manage() {
		frame = new JFrame();
		frame.setTitle("Image Compression");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.black);
		frame.setSize(new Dimension(400, 300));
		frame.setLayout(new GridLayout(6, 1));
		label1 = new JLabel("Enter the path of the file to be compressed.");
		label2 = new JLabel("Enter the path of the file to be decompressed.");
		compressionPath = new JTextField(20);
		compress = new JButton();
		compress.setText("Compress");
		decompressionPath = new JTextField(20);
		decompress = new JButton();
		decompress.setText("Decompress");
		frame.add(label1);
		frame.add(compressionPath);
		frame.add(compress);
		frame.add(label2);
		frame.add(decompressionPath);
		frame.add(decompress);

		frame.setVisible(true);
		compress.addActionListener(this);
		decompress.addActionListener(this);
	}

	public static void main(String args[]) {
		Manage cipher = new Manage();
	}

	void runCompress(){
		try {
			Process p = Runtime.getRuntime().exec("python C:/Users/Ashhad/Desktop/Project/file0.py");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	void runDecompress(){
		try {
			Process p = Runtime.getRuntime().exec("python C:/Users/Ashhad/Desktop/Project/file1.py");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		int flag = 0;
		String cPath = "";
		String dPath = "";
		if (e.getSource() == compress) {
			cPath = compressionPath.getText();
		} else if (e.getSource() == decompress) {
			flag = 1;
			dPath = decompressionPath.getText();
		}
		if(flag == 0){
			String filename = "path.txt";
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
				writer.write(cPath);
			    writer.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			runCompress();
		}else if(flag == 1){
			String filename = "path.txt";
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
				writer.write(dPath);
			    writer.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			runDecompress();
		}
	}
}