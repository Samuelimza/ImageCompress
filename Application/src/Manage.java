
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;

import javax.swing.JFrame;


public class Manage extends Canvas implements Runnable{

		public static int width = 100;
		public static int height = width; // / 16 * 9;
		public static int scale = 3;
		public static String title = "Project";

		private Thread thread;
		private JFrame frame;

		private boolean running = false;
		
		private Screen screen;

		private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

		public Manage() {
			Dimension size = new Dimension(width * scale, height * scale);
			setPreferredSize(size);

			screen = new Screen(width, height);

			frame = new JFrame();
		}

		public synchronized void start() {
			running = true;
			thread = new Thread(this, "Display");
			thread.start();
		}

		public synchronized void stop() {
			running = false;
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			long lastTime = System.nanoTime();
			long timer = System.currentTimeMillis();
			final double ns = 1000000000.0 / 60.0;
			double delta = 0;
			int frames = 0;
			int updates = 0;
			setFocusable(false);
			frame.requestFocus();

			while (running) {
				long now = System.nanoTime();
				delta += (now - lastTime) / ns;
				lastTime = now;
				while (delta >= 1) {
					update();
					updates++;
					delta--;
				}
				render();
				frames++;

				if (System.currentTimeMillis() - timer > 1000) {
					timer += 1000;
					frame.setTitle(title + " | " + updates + " ups, " + frames + " fps");
					updates = 0;
					frames = 0;
				}
			}
			stop();
		}

		public void update() {
			screen.update();
		}

		public void render() {
			BufferStrategy bs = getBufferStrategy();
			if (bs == null) {
				createBufferStrategy(3);
				return;
			}
			screen.clear();
			screen.render();

			for (int i = 0; i < pixels.length; i++) {
				pixels[i] = screen.pixels[i];
			}

			Graphics g = bs.getDrawGraphics();
			g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
			g.setColor(Color.RED);
			g.setFont(new Font("Verdana", 0, 15));
			g.dispose();
			bs.show();
		}

		public static void main(String[] args) {
			Manage wind = new Manage();
			wind.frame.setResizable(false);
			wind.frame.add(wind);
			wind.frame.pack();
			wind.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			wind.frame.setLocationRelativeTo(null);
			wind.frame.setVisible(true);
			try {
				Process p = Runtime.getRuntime().exec("python myFile.py");
				System.out.println("Exec");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			wind.start();
		}

	}
