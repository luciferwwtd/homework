package jump;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

public class MyFrame extends JFrame {
	JLabel label;
	
	public int FPS = 60;
	
	MyFrame(){
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((screen.getWidth() - getWidth()) /2) - 900;
		int y = (int) ((screen.getHeight() -getHeight()) /2) - 520;
		this.setLocation(x, y);
		
		JLabel label = new JLabel();
		
		label.setBackground(Color.blue);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setOpaque(true);
		label.setIconTextGap(50);
		label.setBounds(100, 885, 130, 200);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Jump Simulation");
		this.setSize(1800, 1020);
		this.setVisible(true);
		this.add(label);
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int passedFrame = 0;
		
		while(passedFrame < 61) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) {
				passedFrame++;
				delta--;
				
				label.setLocation(label.getX(), label.getY() + (2/3*passedFrame - 20));
			}
			
			if(timer >= 1000000000) {
//				System.out.println("FPS:" + drawCount);
				timer = 0;
			}
		}
	}
}
